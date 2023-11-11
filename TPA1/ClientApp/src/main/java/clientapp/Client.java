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


public class Client {

    private static String svcIP = "localhost";
    //private static String svcIP = "35.246.73.129";
    private static int svcPort = 8500;
    private static ManagedChannel channel;
    private static ClientRegisterServiceGrpc.ClientRegisterServiceBlockingStub blockingStub1;
    private static ClientRegisterServiceGrpc.ClientRegisterServiceStub noBlockStub1;
    private static ClientServerServiceGrpc.ClientServerServiceBlockingStub blockingStub2;
    private static ClientServerServiceGrpc.ClientServerServiceStub noBlockStub2;

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
                        StreamObserver<ImageBlock> responseObserver = new StreamObserver<ImageBlock>() {
                            @Override
                            public void onNext(ImageBlock response) {
                                // Trate a resposta do servidor (opcional).
                            }

                            @Override
                            public void onError(Throwable t) {
                                // Trate erros.
                            }

                            @Override
                            public void onCompleted() {
                                // Trate a conclusão do streaming.
                            }
                        };


                        StreamObserver<ImageBlock> imageStreamObserver = noBlockStub2.processImageToServer(new StreamObserver<ImageStatusResponse>() {
                        @Override
                        public void onNext(ImageStatusResponse response) {
                            // Trate a resposta do servidor (opcional).
                        }

                        @Override
                        public void onError(Throwable t) {
                            // Trate erros.
                        }

                        @Override
                        public void onCompleted() {
                            // Trate a conclusão do streaming.
                        }
                    });

                    byte[] buffer = new byte[32 * 1024]; // 32 Kbytes buffer
                    int bytesRead;
                    while ((bytesRead = fileInputStream.read(buffer)) != -1) {
                        ImagemChunk chunk = ImagemChunk.newBuilder()
                            .setChunkData(ByteString.copyFrom(buffer, 0, bytesRead))
                            .build();
                        imagemStreamObserver.onNext(chunk);
                    }

                    imagemStreamObserver.onCompleted();

                        
                  
                    case 3: // CS: Verificar o status de processamento de uma imagem (chamada unária - síncrona)
                        
                        break;
                    case 4: // CS: (ID) Fazer download de uma imagem marcada (stream de servidor)
                        
                        break;
                    case 5: // CS: (Keywords) Fazer download de uma imagem marcada (stream de cliente e servidor)
                            
                        break;
                    case 6: // CR: Informar um servidor como inativo (chamada unária - síncrona)

                                
                        break;
                    case 99:
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
        Scanner scan = new Scanner(System.in);
        do {
            System.out.println();
            System.out.println("    MENU");
            System.out.println(" 1 - Case 1 - CR: Obter localização de um servidor (chamada unária - síncrona)");
            System.out.println(" 2 - Case 2 - CS: Enviar uma imagem para processamento (chamada com stream de cliente)");
            System.out.println(" 3 - Case 3 - CS: Verificar o status de processamento de uma imagem (chamada unária - síncrona)");
            System.out.println(" 4 - Case 4 - CS: (ID) Fazer download de uma imagem marcada (stream de servidor)");
            System.out.println(" 5 - Case 5 - CS: (Keywords) Fazer download de uma imagem marcada (stream de cliente e servidor)");
            System.out.println(" 6 - Case 6 - CR: Informar um servidor como inativo (chamada unária - síncrona)");
            System.out.println("99 - Exit");
            System.out.println();
            System.out.println("Choose an Option?");
            op = scan.nextInt();
        } while (!((op >= 1 && op <= 4) || op == 99));
        return op;
    }


}
