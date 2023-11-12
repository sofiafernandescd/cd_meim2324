package serverapp;

import com.github.dockerjava.api.DockerClient;
import com.github.dockerjava.api.command.CreateContainerResponse;
import com.github.dockerjava.api.command.InspectContainerResponse;
import com.github.dockerjava.api.model.Bind;
import com.github.dockerjava.api.model.HostConfig;
import com.github.dockerjava.api.model.Volume;
import com.github.dockerjava.core.DockerClientBuilder;
import com.github.dockerjava.httpclient5.ApacheDockerHttpClient;
import io.grpc.stub.StreamObserver;
import clientserverstubs.*;
import clientserverstubs.ImageBlock;
import clientserverstubs.ImageStatusResponse;
import clientserverstubs.ImageStatusResponse;
import serverapp.DockerAPI.*;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

public class ProcessImageServiceImpl extends ClientServerServiceGrpc.ClientServerServiceImplBase{
    public ProcessImageServiceImpl(){}

    @Override
    public StreamObserver<ImageBlock> processImageToServer(StreamObserver<ImageStatusResponse> responseObserver){

       return new StreamObserver<ImageBlock>() {
           // List to store image chunks received from the client
           private List<byte[]> imageChunks = new ArrayList<>();
           ImageBlock imageBlock;

           List<String> keywords = new ArrayList<>();

            @Override
            public void onNext(ImageBlock imageBlock) {
                // Collect image chunks
                imageChunks.add(imageBlock.getData().toByteArray());
                this.imageBlock = imageBlock;
            }

            @Override
            public void onError(Throwable throwable) {
                System.out.println("Error receiving image chunks: " + throwable.getMessage());
                responseObserver.onError(throwable);
            }

            @Override
            public void onCompleted() {
                // Concatenate image chunks into a single byte array
                byte[] imageData = concatenateChunks(imageChunks);


                // Process the image using MarkImages and DockerAPI
                processImageWithDocker(imageData, imageBlock.getKeywordsList(), imageBlock.getImagePathname(), imageBlock.getImageResultPathname());


                ImageStatusResponse response = ImageStatusResponse.newBuilder()
                        .setImageId(UUID.randomUUID().toString())
                        .setStatus(false)
                        .build();

                responseObserver.onNext(response);
                responseObserver.onCompleted();
            }
        };
    }


    // Utility method to concatenate a list of byte arrays into a single byte array
    private byte[] concatenateChunks(List<byte[]> chunks) {
        int totalSize = chunks.stream().mapToInt(chunk -> chunk.length).sum();
        byte[] result = new byte[totalSize];

        int offset = 0;
        for (byte[] chunk : chunks) {
            System.arraycopy(chunk, 0, result, offset, chunk.length);
            offset += chunk.length;
        }

        return result;
    }

    // Method to process the image using DockerAPI
    private void processImageWithDocker(byte[] imageData, List<String> keywords, String image_pathname, String image_result_pathname) {
        try {
            // Convert byte array to BufferedImage
            ByteArrayInputStream inputStream = new ByteArrayInputStream(imageData);
            BufferedImage img = ImageIO.read(inputStream);

            // Save the image to a temporary file (you might want to use a unique file name)
            String tempImagePath = "temp_input_image.jpg";
            ImageIO.write(img, "jpg", new java.io.File(tempImagePath));

            // Run DockerAPI to process the image
            String HOST_URI = "unix:///var/run/docker.sock";// Docker daemon URI, TODO
            String containerName = "countMarkimage";
            String pathVolDir = "/usr/datafiles"; // Host volume directory, TODO
            String imageName = "Dockerfile";


            String command= "docker run -d -v " + "/usr/images:" + pathVolDir + " –name " + containerName + " " + imageName + " " + image_pathname + " " + "/home/CD2324-G06/" + image_result_pathname;

            System.out.println(command);

            for(int i= 0; i < keywords.size(); i++){
                command = command + " " + keywords.get(i);
            }

            System.out.println(command);
            // Create Docker client
            DockerClient dockerClient = DockerClientBuilder
                    .getInstance()
                    .withDockerHttpClient(
                            new ApacheDockerHttpClient.Builder()
                                    .dockerHost(URI.create(HOST_URI))
                                    .build())
                    .build();

            System.out.println("Hello");
            // Configure host options for the container
            HostConfig hostConfig = HostConfig.newHostConfig()
                    .withBinds(new Bind(pathVolDir, new Volume("/usr/datafiles")));

            System.out.println("Hello");
            // Create a Docker container
            CreateContainerResponse containerResponse = dockerClient
                    .createContainerCmd(imageName)
                    .withName(containerName)
                    .withHostConfig(hostConfig)
                    .withCmd(command)
                    .exec();

            System.out.println("ID:" + containerResponse.getId());

            // Start the Docker container
            dockerClient.startContainerCmd(containerResponse.getId()).exec();

            // Inspect the container to get its status
            InspectContainerResponse inspResp = dockerClient.inspectContainerCmd(containerName).exec();
            System.out.println("Container Status: " + inspResp.getState().getStatus());

            // TODO You can add more logic here to handle the processing result if needed

            // Clean up: Kill and remove the container
            dockerClient.killContainerCmd(containerName).exec();
            dockerClient.removeContainerCmd(containerName).exec();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



/*    @Override
    public void processImageToServer(StreamObserver<ImageStatusResponse> responseObserver) {
        // Implement the logic to process images using Docker here

        // Example Docker-related logic
        try {
            String HOST_URI = "tcp://localhost:2375"; // Adjust as needed
            String containerName = "my-container";
            String pathVolDir = "/path/to/volume"; // Adjust as needed
            String imageName = "my-image";
            List<String> command = List.of("keyword1", "keyword2", "keyword3");

            DockerClient dockerclient = DockerClientBuilder
                    .getInstance()
                    .withDockerHttpClient(
                            new ApacheDockerHttpClient.Builder()
                                    .dockerHost(URI.create(HOST_URI))
                                    .build())
                    .build();

            HostConfig hostConfig = HostConfig.newHostConfig()
                    .withBinds(new Bind(pathVolDir, new Volume("/usr/datafiles")));

            CreateContainerResponse containerResponse = dockerclient
                    .createContainerCmd(imageName)
                    .withName(containerName)
                    .withHostConfig(hostConfig)
                    .withCmd(command)
                    .exec();

            System.out.println("ID:" + containerResponse.getId());

            dockerclient.startContainerCmd(containerResponse.getId()).exec();

            InspectContainerResponse inspResp = dockerclient.inspectContainerCmd(containerName).exec();
            System.out.println("Container Status: " + inspResp.getState().getStatus());

            // Handle the image processing logic here

            dockerclient.killContainerCmd(containerName).exec();
            dockerclient.removeContainerCmd(containerName).exec();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        // Notify the gRPC client about the image processing status
        ImageStatusResponse response = ImageStatusResponse.newBuilder()
                .setStatus("Image processing completed")
                .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }*/
}
