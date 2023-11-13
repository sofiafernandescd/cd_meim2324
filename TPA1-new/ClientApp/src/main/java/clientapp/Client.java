package clientapp;

import clientregisterstubs.ClientRegisterServiceGrpc;
import clientregisterstubs.ClientRequest;
import clientregisterstubs.ServerInfo;
import clientserverstubs.*;

import com.google.common.io.Files;
import com.google.protobuf.ByteString;
import com.google.protobuf.Message;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.Server;
import io.grpc.stub.StreamObserver;

import javax.imageio.ImageIO;
import javax.imageio.stream.ImageOutputStream;
import java.awt.image.RenderedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.Scanner;
import java.util.stream.Stream;

import static java.nio.file.Path.of;

public class Client {

    // private static String REGISTER_IP = "localhost";
    private static String REGISTER_IP;
    private static int REGISTER_PORT;
    private static String SERVER_IP;
    private static int SERVER_PORT;
    private static ManagedChannel channel;
    private static ClientRegisterServiceGrpc.ClientRegisterServiceBlockingStub blockingStub1;
    private static ClientRegisterServiceGrpc.ClientRegisterServiceStub noBlockStub1;
    private static ClientServerServiceGrpc.ClientServerServiceBlockingStub blockingStub2;
    private static ClientServerServiceGrpc.ClientServerServiceStub noBlockStub2;
    private static Scanner scan = new Scanner(System.in);
    public static void main(String[] args) {

        try {
            if (args.length == 2) {
                REGISTER_IP = args[0];
                REGISTER_PORT = Integer.parseInt(args[1]);

                // Connect to the Register Server
                System.out.println("> Connecting to Register: " + REGISTER_IP + ":" + REGISTER_PORT);
                channel = ManagedChannelBuilder.forAddress(REGISTER_IP, REGISTER_PORT)
                        .usePlaintext()
                        .build();

                blockingStub1 = ClientRegisterServiceGrpc.newBlockingStub(channel);
                noBlockStub1 = ClientRegisterServiceGrpc.newStub(channel); // stub assíncrono

                System.out.println(blockingStub1.getChannel().toString());
                // Call getServerEndpoint
                ServerInfo serverInfo = blockingStub1.getServerEndpoint(
                        ClientRequest.newBuilder()
                                .setClientId("1").build());

                SERVER_IP = serverInfo.getIp();
                SERVER_PORT = serverInfo.getPort();
            }
            System.out.println("Connecting to Server: " + SERVER_IP +":" + SERVER_PORT);
            channel = ManagedChannelBuilder.forAddress(SERVER_IP, SERVER_PORT)
                // Channels are secure by default (via SSL/TLS). For the example we disable TLS to avoid
                // needing certificates.
                .usePlaintext()
                .build();

            blockingStub2 = ClientServerServiceGrpc.newBlockingStub(channel); // stub síncrono
            noBlockStub2 = ClientServerServiceGrpc.newStub(channel); // stub assíncrono



            while (true) {
                switch (Menu()) {
                    case 1: // CS: Enviar uma imagem para processamento (chamada com stream de cliente)

                        /*// Pedir ao utilizador o caminho da imagem
                        System.out.println("Enter the image path to upload:");
                        String imagePath = scan.next();
                        String resultImagePath = imagePath.substring(0, imagePath.lastIndexOf('.')) + "-marked.jpg";
                        // Pedir ao utilizador as keywords
                        List<String> keywordsList = new ArrayList<>();
                        scan.nextLine(); // Consumir a quebra de linha pendente
                        System.out.println("Insere as Keywords:");
                        String keywordsInput = scan.nextLine();
                        String[] keywordsArray = keywordsInput.split(" ");
                        keywordsList.addAll(Arrays.asList(keywordsArray));
                        // Pedir ao utilizador o ID da imagem
                        System.out.println("Insere o ID da imagem:");
                        String imageId = scan.next();


                        // Get data in ByteString format from the image file
                        File imageFile = new File(imagePath);
                        ByteString imageData = ByteString.copyFrom(Files.toByteArray(imageFile));


                        // contruir o imageBlock
                        ImageBlock imageBlock = ImageBlock.newBuilder()
                                .setImageId(imageId)
                                .setData(imageData)
                                .setImagePathname(imagePath)
                                .setImageResultPathname(resultImagePath)
                                .addAllKeywords(keywordsList)
                                .build();*/

                        // Crie um objeto StreamObserver para receber as respostas do servidor.
                        StreamObserver<ImageBlock> imageStreamObserver1 = noBlockStub2.processImageToServer(new StreamObserver<ImageStatusResponse>() {
                        @Override
                        public void onNext(ImageStatusResponse response) {
                            System.out.println("Server response: " + response.toString());
                        }

                        @Override
                        public void onError(Throwable t) {
                            System.err.println("Erro no servidor: " + t.getMessage());
                            /*ServerInfo s = blockingStub1.failInform(ServerInfo.newBuilder().setIp(SERVER_IP).setPort(SERVER_PORT).build());
                            SERVER_IP = s.getIp();
                            SERVER_PORT = s.getPort();
                            System.out.println("Informando que um servidor está como inativo \nLigando a um novo servidor\n" + s.toString());*/
                        }

                        @Override
                        public void onCompleted() {
                            System.out.println("Comunicação com o servidor concluída.");
                        }
                    });

                        // Send the image data in chunks
                        sendImageChunks(imageStreamObserver1);
                        break;

                    case 2: // CS: check image status
                        try {
                            System.out.println("Inserir ID da imagem para ver o estado:");
                            String imageId2 = scan.next();
                            
                            // Check Image Mark Status
                            ImageStatusResponse response = blockingStub2.checkImageStatus(ImageStatusRequest.newBuilder().setImageId(imageId2).build());
                            if(!response.getStatus()) {
                                System.out.println("Imagem ainda não marcada");
                            }else {
                                System.out.println("Imagem marcada");
                            }
                        } catch (Exception ex) {
                            ex.printStackTrace();
                            // Handle exception if needed
                        }
                        break;

                    case 3: // CS: (ID) Fazer download de uma imagem marcada (stream de servidor)
                        try {
                            System.out.println("Inserir o ID da imagem para fazer download:");
                            String imageId3 = scan.next();

                            // Crie uma instância da mensagem de solicitação
                            ImageDownloadRequestId downloadRequestId = ImageDownloadRequestId.newBuilder()
                                    .setImageId(imageId3)
                                    .build();

                            // Faça a chamada síncrona para obter o stream de imagem
                            Iterator<ImageBlock> imageBlockIterator = blockingStub2.downloadMarkedImageById(downloadRequestId);

                            // Itere sobre os blocos recebidos
                            while (imageBlockIterator.hasNext()) {
                                ImageBlock imageBlock3 = imageBlockIterator.next();
                                // Faça o processamento necessário com o bloco da imagem
                                System.out.println("Received Image Block for Image ID: " + imageBlock3.getImageId());
                            }

                            System.out.println("Download completed for Image ID: " + imageId3);
                        } catch (Exception ex) {
                            ex.printStackTrace();
                           /* ServerInfo s = blockingStub1.failInform(ServerInfo.newBuilder().setIp(SERVER_IP).setPort(SERVER_PORT).build());
                            SERVER_IP = s.getIp();
                            SERVER_PORT = s.getPort();
                            System.out.println("Informando que um servidor está como inativo \n Ligando a um novo servidor" + s.toString());*/
                        }
                        break;

                    case 4: // CS: (Keywords) Fazer download de uma imagem marcada (stream de cliente e servidor)
                        try {
                            System.out.println("Inserir keywords para fazer download de imagem:");
                            List<String> keywordsList4 = new ArrayList<>();
                            scan.nextLine(); // Consumir a quebra de linha pendente
                            String keywordsInput4 = scan.nextLine();
                            String[] keywordsArray4 = keywordsInput4.split(" ");
                            keywordsList4.addAll(Arrays.asList(keywordsArray4));

                            // Crie um StreamObserver para receber os blocos da imagem do servidor
                            StreamObserver<ImageBlock> imageDownloadStreamObserver = new StreamObserver<ImageBlock>() {
                                @Override
                                public void onNext(ImageBlock imageBlock) {
                                    // Processar o bloco da imagem recebido
                                    System.out.println("Received Image Block for Image ID: " + imageBlock.getImageId());
                                }

                                @Override
                                public void onError(Throwable t) {
                                    System.err.println("Erro no servidor: " + t.getMessage());
                                }

                                @Override
                                public void onCompleted() {
                                    System.out.println("Download completed for the specified keywords.");
                                }
                            };

                            // Crie uma instância da mensagem de solicitação
                            ImageDownloadRequestKeywords downloadRequestKeywords = ImageDownloadRequestKeywords.newBuilder()
                                    .addAllKeywords(keywordsList4)
                                    .build();

                            // Faça a chamada assíncrona para iniciar o download com streaming de cliente e servidor
                            StreamObserver<ImageDownloadRequestKeywords> requestObserver = noBlockStub2.downloadMarkedImageByKeywords(imageDownloadStreamObserver);
                            requestObserver.onNext(downloadRequestKeywords);
                            requestObserver.onCompleted();
                        } catch (Exception ex) {
                            ex.printStackTrace();
                           /* ServerInfo s = blockingStub1.failInform(ServerInfo.newBuilder().setIp(SERVER_IP).setPort(SERVER_PORT).build());
                            SERVER_IP = s.getIp();
                            SERVER_PORT = s.getPort();
                            System.out.println("Informando que um servidor está como inativo \n Ligando a um novo servidor" + s.toString());*/
                        }
                        break;
                    case 0:
                        // Gracefully terminate the client
                        System.out.println("Exiting the client gracefully.");
                        // Add any cleanup logic here
                        channel.shutdown();
                        return; // Exit the while loop and end the main method

                    default:
                        break;
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private static int Menu() {
        int op;
        do {
            System.out.println();
            System.out.println("     MENU");
            System.out.println(" 1 - Enviar uma imagem para processamento (chamada com stream de cliente)");
            System.out.println(" 2 - Verificar o status de processamento de uma imagem (chamada unária - síncrona)");
            System.out.println(" 3 - (ID) Fazer download de uma imagem marcada (stream de servidor)");
            System.out.println(" 4 - (Keywords) Fazer download de uma imagem marcada (stream de cliente e servidor)");
            System.out.println(" 0 - Exit");
            System.out.println();
            System.out.println("Choose an Option?");
            op = scan.nextInt();
        } while (!(op >= 0 && op <= 4));
        return op;
    }

    private static <BufferedImage> void sendImageChunks(StreamObserver<ImageBlock> imageStreamObserver) {
        try {
            System.out.println("Nome do ficheiro da imagem:");
            String imagePath = scan.next();
            String resultImagePath = imagePath.substring(0, imagePath.lastIndexOf('.')) + "-marked.jpg";

            List<String> keywordsList = new ArrayList<>();
            scan.nextLine(); // Consumir a quebra de linha pendente
            System.out.println("Insere as Keywords:");
            String keywordsInput = scan.nextLine();
            String[] keywordsArray = keywordsInput.split(" ");
            keywordsList.addAll(Arrays.asList(keywordsArray));
            File imageFile = new File(imagePath);

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
                        .setImagePathname(imagePath)
                        .setImageResultPathname(resultImagePath)  // Adjust the path as needed
                        .addAllKeywords(keywordsList)
                        .build();

                imageStreamObserver.onNext(imageBlock);
            }

            // Signal completion to the server
            imageStreamObserver.onCompleted();
        } catch (Exception ex) {
            ex.printStackTrace();
            // Handle exception if needed
        }
    }


}
