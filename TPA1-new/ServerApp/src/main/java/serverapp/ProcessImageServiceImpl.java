package serverapp;

import com.github.dockerjava.api.DockerClient;
import com.github.dockerjava.api.command.CreateContainerResponse;
import com.github.dockerjava.api.command.InspectContainerResponse;
import com.github.dockerjava.api.model.Bind;
import com.github.dockerjava.api.model.HostConfig;
import com.github.dockerjava.api.model.Volume;
import com.github.dockerjava.core.DockerClientBuilder;
import com.github.dockerjava.httpclient5.ApacheDockerHttpClient;
import com.google.protobuf.ByteString;
import io.grpc.stub.StreamObserver;
import clientserverstubs.*;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.net.URI;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import serverapp.ImagesInfo;


public class ProcessImageServiceImpl extends ClientServerServiceGrpc.ClientServerServiceImplBase{

    private final ImagesInfo imagesInfo;

    public ProcessImageServiceImpl(ImagesInfo imagesInfo) {
        this.imagesInfo = imagesInfo;
    }



    @Override
    public StreamObserver<ImageBlock> processImageToServer(StreamObserver<ImageStatusResponse> responseObserver){


       return new StreamObserver<ImageBlock>() {
            // List to store image chunks received from the client
            private List<byte[]> imageChunks = new ArrayList<>();
            ImageBlock imageBlock;
            
            // Get the image keywords from the client
            List<String> keywordsList = imageBlock.getKeywordsList();
            // Cast keywords to ArrayList<String>
            ArrayList<String> keywords = new ArrayList<String>(keywordsList);
            // Get the image pathname from the client
            String imagePath = imageBlock.getImagePathname();
            // Get the image result pathname by adding "-marked" to the image pathname
            String resultImagePath = imagePath.substring(0, imagePath.lastIndexOf('.')) + "-marked.jpg";
            // Get the image ID from the client
            String imageId = imageBlock.getImageId();


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
                // Process the image with MarkApp
                try {
                    // Concatenate image chunks into a single byte array
                    byte[] imageData = concatenateChunks(imageChunks);
                    // Convert to buffered image
                    ByteArrayInputStream inputStream = new ByteArrayInputStream(imageData);
                    BufferedImage img = ImageIO.read(inputStream);
            
                    // Process the image with MarkApp
                    BufferedImage outputImg = MarkApp.annotateImage(img, keywords);
            
                    // Save the processed image to a file
                    String resultImagePath = imageBlock.getImageResultPathname();
                    ImageIO.write(outputImg, "jpg", new File(resultImagePath));
            
                } catch (IOException e) {
                    e.printStackTrace();
                }
       
                // Add the image block to ImagesList of ImagesInfo class
                imagesInfo.addImageToList(imageBlock);
    
                ImageStatusResponse response = ImageStatusResponse.newBuilder()
                        .setImageId(imageId)
                        .setStatus(true)
                        .build();

                // Print the image processing status with ID
                System.out.println("Image processing completed for image ID: " + imageId);
                
                responseObserver.onNext(response);
                responseObserver.onCompleted();
            }

        };
    }


    

    @Override
    public void checkImageStatus(ImageStatusRequest request, StreamObserver<ImageStatusResponse> responseObserver) {

        // get ImagesList
        Map<String, ImageBlock> ImagesList = imagesInfo.getListOfImages();

        // get image ID
        String imageId = request.getImageId();

        // try get image block from ImagesList
        ImageBlock imageBlock = ImagesList.get(imageId);
        // if null
        if (imageBlock == null) {
            // Create a response with the image processing status
            ImageStatusResponse response = ImageStatusResponse.newBuilder().setImageId(request.getImageId()).setStatus(false).build();
            responseObserver.onNext(response);
            responseObserver.onCompleted();
        }
        // else
        else {
            // Create a response with the image processing status
            ImageStatusResponse response = ImageStatusResponse.newBuilder().setImageId(request.getImageId()).setStatus(true).build();
            responseObserver.onNext(response);
            responseObserver.onCompleted();
        }

    }

    @Override
    public void downloadMarkedImageById(ImageDownloadRequestId request, StreamObserver<ImageBlock> responseObserver){
        //getImageBlocksFromVolume(request.getImageId(), responseObserver);
        // get ImagesList
        Map<String, ImageBlock> ImagesList = imagesInfo.getListOfImages();

        // get image ID
        String imageId = request.getImageId();

        // try get image block from ImagesList
        ImageBlock imageBlock = ImagesList.get(imageId);
        // if null (image not found) return ImageBlock with empty data
        if (imageBlock == null) {
            ImageBlock response = ImageBlock.newBuilder().setImageId(request.getImageId()).setData(ByteString.EMPTY).build();
            responseObserver.onNext(response);
            responseObserver.onCompleted();
        }
        // else
        else {
            // Create a response with the image processing status
            ImageBlock response = ImageBlock.newBuilder().setImageId(request.getImageId()).setData(imageBlock.getData()).setImageResultPathname(imageBlock.getImageResultPathname()).build();
            responseObserver.onNext(response);
            responseObserver.onCompleted();
        }     
        
    }

    @Override
    public StreamObserver<ImageDownloadRequestKeywords> downloadMarkedImageByKeywords(StreamObserver<ImageBlock> responseObserver){
        // get ImagesList
        Map<String, ImageBlock> ImagesList = imagesInfo.getListOfImages();

        return new StreamObserver<ImageDownloadRequestKeywords> () {
            @Override
            public void onNext(ImageDownloadRequestKeywords keywords) {
                // Collect keywords
                List<String> keywordsList = keywords.getKeywordsList();
            }

            @Override
            public void onError(Throwable throwable) {
                System.out.println("Error receiving image chunks: " + throwable.getMessage());
                responseObserver.onError(throwable);
            }

            @Override
            public void onCompleted() {
                // Search for images with the specified keywords
              
                    
                // Search for images with the specified keywords
                List<ImageBlock> imageBlocksKw = new ArrayList<>();

                for (Map.Entry<String, ImageBlock> entry : ImagesList.entrySet()) {
                    String key = entry.getKey();
                    ImageBlock value = entry.getValue();
                    List<String> keywordsList = value.getKeywordsList();
                    for (int i = 0; i < keywordsList.size(); i++) {
                        for (int j = 0; j < keywordsList.size(); j++) {
                            if (keywordsList.get(i).equals(keywordsList.get(j))) {
                                imageBlocksKw.add(value);
                            }
                        }
                    }
                }

                // Send the image blocks to the client
                for (ImageBlock imageBlock : imageBlocksKw) {
                    responseObserver.onNext(imageBlock);
                }

                // Signal completion to the client
                responseObserver.onCompleted();


       
                
            }

        };

    }



    // Method to retrieve image blocks from the volume
    private void getImageBlocksFromVolume(String imageId,StreamObserver<ImageBlock> response){
       try {
           // Define the path to the volume directory where image blocks are stored
           String volumePath = "/usr/datafiles/" + imageId;

           File imageFile = new File(volumePath);
           BufferedImage img = (BufferedImage) ImageIO.read(imageFile);
           ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
           ImageIO.write((RenderedImage) img, "jpg", byteArrayOutputStream);

           // Convert the image to byte array chunks (adjust chunk size as needed)
           byte[] imageData = byteArrayOutputStream.toByteArray();
           int chunkSize = 32 * 1024;  // 32 KB chunks (adjust as needed)

           for (int i = 0; i < imageData.length; i += chunkSize) {
               int end = Math.min(imageData.length, i + chunkSize);
               byte[] chunk = Arrays.copyOfRange(imageData, i, end);

               // Create an ImageBlock and send it to the server
               ImageBlock imageBlock = ImageBlock.newBuilder()
                       .setImageId(UUID.randomUUID().toString())
                       .setData(ByteString.copyFrom(chunk))
                       .build();

               response.onNext(imageBlock);
           }

           // Signal completion to the server
           response.onCompleted();
       }catch(Exception ex){
           ex.printStackTrace();
       }
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
