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
import clientserverservice.ImageBlock;
import clientserverservice.ImageProcessingServiceGrpc;
import clientserverservice.ImageStatusResponse;
import serverapp.DockerAPI.*;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

public class ProcessImageServiceImpl extends ClientServerServiceGrpc.ImageProcessingServiceImplBase {

    @Override
    public void processImageToServer(StreamObserver<ImageStatusResponse> responseObserver) {
        // List to store image chunks received from the client
        List<byte[]> imageChunks = new ArrayList<>();

        // Receive image chunks from the client
        StreamObserver<ImageBlock> imageBlockObserver = new StreamObserver<ImageBlock>() {
            @Override
            public void onNext(ImageBlock imageBlock) {
                // Collect image chunks
                imageChunks.add(imageBlock.getData().toByteArray());
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
                processImageWithDocker(imageData);

                // Notify the gRPC client about the image processing status
                ImageStatusResponse response = ImageStatusResponse.newBuilder()
                        .setStatus("Image processing completed")
                        .build();

                responseObserver.onNext(response);
                responseObserver.onCompleted();
            }
        };

        // Set up the image block observer
        responseObserver.onNext(ImageBlock.newBuilder().build());
        responseObserver.onCompleted();

        // Return the observer to receive image chunks from the client
        return imageBlockObserver;
    }


    // Utility method to concatenate a list of byte arrays into a single byte array
    private byte[] concatenateChunks(List<byte[]> chunks) {
        int totalSize = chunks.stream().mapToInt(byte[]::length).sum();
        byte[] result = new byte[totalSize];

        int offset = 0;
        for (byte[] chunk : chunks) {
            System.arraycopy(chunk, 0, result, offset, chunk.length);
            offset += chunk.length;
        }

        return result;
    }

    // Method to process the image using DockerAPI
    private void processImageWithDocker(byte[] imageData) {
        try {
            // Convert byte array to BufferedImage
            ByteArrayInputStream inputStream = new ByteArrayInputStream(imageData);
            BufferedImage img = ImageIO.read(inputStream);

            // Save the image to a temporary file (you might want to use a unique file name)
            String tempImagePath = "/tmp/input_image.jpg";
            ImageIO.write(img, "jpg", new java.io.File(tempImagePath));

            // Run DockerAPI to process the image
            String HOST_URI = "tcp://localhost:2375"; // Docker daemon URI, TODO
            String containerName = "mark-app-container";
            String pathVolDir = "/path/to/volume"; // Host volume directory, TODO
            String imageName = "Dockerfile";
            List<String> command = List.of(tempImagePath);

            // Create Docker client
            DockerClient dockerClient = DockerClientBuilder
                    .getInstance()
                    .withDockerHttpClient(
                            new ApacheDockerHttpClient.Builder()
                                    .dockerHost(URI.create(HOST_URI))
                                    .build())
                    .build();

            // Configure host options for the container
            HostConfig hostConfig = HostConfig.newHostConfig()
                    .withBinds(new Bind(pathVolDir, new Volume("/usr/datafiles")));

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
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }



    @Override
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
    }
}
