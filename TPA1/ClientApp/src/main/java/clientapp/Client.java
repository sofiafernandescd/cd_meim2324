package clientapp;

import clientregisterstubs.*;
import clientserverstubs.*;
import clientserverstubs.ClientServerServiceGrpc.ClientServerServiceBlockingStub;

import com.google.protobuf.ByteString;
// Importar as classes do pacote clientserverstubs e clientregisterstubs
// import calcstubs.Number;
import com.google.protobuf.Message;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;
import java.util.*;
import java.util.Scanner;

public class Client {

    private static String svcIP = "localhost";
    //private static String svcIP = "35.246.73.129";
    private static int svcPort = 8500;
    private static ManagedChannel channel;
    private static ClientRegisterServiceGrpc.ClientRegisterServiceBlockingStub blockingStub1;
    private static ClientRegisterServiceGrpc.ClientRegisterServiceStub noBlockStub1;
    private static ClientServerServiceGrpc.ClientServerServiceBlockingStub blockingStub2;
    private static ClientServerServiceGrpc.ClientServerServiceStub noBlockStub2;
    private static Scanner scan = new Scanner(System.in);
    public static void main(String[] args) {


        try {
            if (args.length == 2) {
                svcIP = args[0];
                svcPort = Integer.parseInt(args[1]);
            }
            System.out.println("connect to "+svcIP+":"+svcPort);
            channel = ManagedChannelBuilder.forAddress(svcIP, svcPort)
                // Channels are secure by default (via SSL/TLS). For the example we disable TLS to avoid
                // needing certificates.
                .usePlaintext()
                .build();


            blockingStub1 = ClientRegisterServiceGrpc.newBlockingStub(channel); // stub síncrono
            noBlockStub1 = ClientRegisterServiceGrpc.newStub(channel); // stub assíncrono
            blockingStub2 = ClientServerServiceGrpc.newBlockingStub(channel); // stub síncrono
            noBlockStub2 = ClientServerServiceGrpc.newStub(channel); // stub assíncrono



            while (true) {
                switch (Menu()) {
                    case 1:  // CR: Obter localização de um servidor (chamada unária - síncrona)

                        break;
                    case 2: // CS: Enviar uma imagem para processamento (chamada com stream de cliente)
                        // Crie um objeto StreamObserver para receber as respostas do servidor.
                        StreamObserver<ImageBlock> imageStreamObserver = noBlockStub2.processImageToServer(new StreamObserver<ImageStatusResponse>() {
                        @Override
                        public void onNext(ImageStatusResponse response) {
                            System.out.println("Server response: " + response.toString());
                        }

                        @Override
                        public void onError(Throwable t) {
                            System.err.println("Erro no servidor: " + t.getMessage());
                        }

                        @Override
                        public void onCompleted() {
                            System.out.println("Comunicação com o servidor concluída.");
                        }
                    });

                    case 3: // CS: Verificar o status de processamento de uma imagem (chamada unária - síncrona)
                        try {
                            System.out.println("Enter the image ID to check status:");
                            String imageId = scan.next();

                            // Crie uma instância da mensagem de solicitação
                            ImageStatusRequest imageStatusRequest = ImageStatusRequest.newBuilder()
                                    .setImageId(imageId)
                                    .build();

                            // Faça a chamada síncrona para verificar o status
                            ImageStatusResponse imageStatusResponse = blockingStub2.checkImageStatus(imageStatusRequest);

                            // Exiba o resultado
                            if (imageStatusResponse.getStatus()) {
                                System.out.println("Image with ID " + imageId + " has been processed.");
                            } else {
                                System.out.println("Image with ID " + imageId + " is still pending processing.");
                            }
                        } catch (Exception ex) {
                            ex.printStackTrace();
                        }
                        break;

                    case 4: // CS: (ID) Fazer download de uma imagem marcada (stream de servidor)
                        try {
                            System.out.println("Enter the image ID to download:");
                            String imageId = scan.next();

                            // Crie uma instância da mensagem de solicitação
                            ImageDownloadRequestId downloadRequestId = ImageDownloadRequestId.newBuilder()
                                    .setImageId(imageId)
                                    .build();

                            // Faça a chamada síncrona para obter o stream de imagem
                            Iterator<ImageBlock> imageBlockIterator = blockingStub2.downloadMarkedImageById(downloadRequestId);

                            // Itere sobre os blocos recebidos
                            while (imageBlockIterator.hasNext()) {
                                ImageBlock imageBlock = imageBlockIterator.next();
                                // Faça o processamento necessário com o bloco da imagem
                                System.out.println("Received Image Block for Image ID: " + imageBlock.getImageId());
                            }

                            System.out.println("Download completed for Image ID: " + imageId);
                        } catch (Exception ex) {
                            ex.printStackTrace();
                        }
                        break;

                    case 5: // CS: (Keywords) Fazer download de uma imagem marcada (stream de cliente e servidor)
                        try {
                            System.out.println("Enter keywords for the image download:");
                            List<String> keywordsList = new ArrayList<>();
                            scan.nextLine(); // Consumir a quebra de linha pendente
                            String keywordsInput = scan.nextLine();
                            String[] keywordsArray = keywordsInput.split("\\s+");
                            keywordsList.addAll(Arrays.asList(keywordsArray));

                            // Crie um StreamObserver para receber os blocos da imagem do servidor
                            StreamObserver<ImageBlock> imageStreamObserver = new StreamObserver<ImageBlock>() {
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
                                    .addAllKeywords(keywordsList)
                                    .build();

                            // Faça a chamada assíncrona para iniciar o download com streaming de cliente e servidor
                            StreamObserver<ImageDownloadRequestKeywords> requestObserver = noBlockStub2.downloadMarkedImageByKeywords(imageStreamObserver);
                            requestObserver.onNext(downloadRequestKeywords);
                            requestObserver.onCompleted();
                        } catch (Exception ex) {
                            ex.printStackTrace();
                        }
                        break;

                    case 6: // CR: Informar um servidor como inativo (chamada unária - síncrona)


                        break;
                    case 0:
                        System.exit(0);
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
            System.out.println("    MENU");
            System.out.println(" 1 - Case 1 - CR: Obter localização de um servidor (chamada unária - síncrona)");
            System.out.println(" 2 - Case 2 - CS: Enviar uma imagem para processamento (chamada com stream de cliente)");
            System.out.println(" 3 - Case 3 - CS: Verificar o status de processamento de uma imagem (chamada unária - síncrona)");
            System.out.println(" 4 - Case 4 - CS: (ID) Fazer download de uma imagem marcada (stream de servidor)");
            System.out.println(" 5 - Case 5 - CS: (Keywords) Fazer download de uma imagem marcada (stream de cliente e servidor)");
            System.out.println(" 6 - Case 6 - CR: Informar um servidor como inativo (chamada unária - síncrona)");
            System.out.println("0 - Exit");
            System.out.println();
            System.out.println("Choose an Option?");
            op = scan.nextInt();
        } while (!(op >= 0 && op <= 6));
        return op;
    }


}
