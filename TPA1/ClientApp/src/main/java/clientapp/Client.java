package clientapp;

import clientregisterstubs.*;
import clientserverstubs.*;
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
            blockingStub1 = ClientRegisterServiceGrpc.newBlockingStub(channel);
            noBlockStub1 = ClientRegisterServiceGrpc.newStub(channel);
            blockingStub2 = ClientServerServiceGrpc.newBlockingStub(channel);
            noBlockStub2 = ClientServerServiceGrpc.newStub(channel);



            while (true) {
                switch (Menu()) {
                    case 1:  // adicionar dois numeros
                        
                        break;
                    case 2: // calcular as  potencias de x^y
                        
                        break;
                    case 3: //somar a sequencia dos numeros de x a y
                        
                        break;
                    case 4: //sequencia de operacões de soma x + y
                        
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
            System.out.println(" 1 - Case1 - chamada unária: add two numbers");
            System.out.println(" 2 - Case 2 - chamada com sream de servidor: generate powers");
            System.out.println(" 3 - Case 3 - chamada com stream de cliente: add a sequence of numbers");
            System.out.println(" 4 - stream de cliente e de servidor: Multiple add operations ");
            System.out.println("99 - Exit");
            System.out.println();
            System.out.println("Choose an Option?");
            op = scan.nextInt();
        } while (!((op >= 1 && op <= 4) || op == 99));
        return op;
    }


}
