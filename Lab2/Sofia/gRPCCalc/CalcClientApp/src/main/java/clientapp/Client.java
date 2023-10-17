package clientapp;

import calcstubs.*;
import calcstubs.Number;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;
import java.util.*;


public class Client {

    private static String svcIP = "localhost";
    //private static String svcIP = "35.246.73.129";
    private static int svcPort = 8500;
    private static ManagedChannel channel;
    private static CalcServiceGrpc.CalcServiceBlockingStub blockingStub;
    private static CalcServiceGrpc.CalcServiceStub noBlockStub;


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
            blockingStub = CalcServiceGrpc.newBlockingStub(channel);
            noBlockStub = CalcServiceGrpc.newStub(channel);

            while (true) {
                switch (Menu()) {
                    case 1:  // adicionar dois numeros
                        // Case1 - chamada unária: add two numbers
    
                        Result res = blockingStub.add(AddOperands.newBuilder()
                                .setId("50+25")
                                .setOp1(50).setOp2(25)
                                .build());
                        System.out.println("add " + res.getId() + "= " + res.getRes());
                        break;

                    case 2: // calcular as  potencias de x^y com stub não bloqueante
                        //Case 2 - chamada com sream de servidor: generate powers

                        noBlockStub.generatePowers(NumberAndMaxExponent.newBuilder()
                                .setId("2^10")
                                .setBaseNumber(2).setMaxExponent(10)
                                .build(), new StreamObserver<Result>() {
                                    @Override
                                    public void onNext(Result value) {
                                        System.out.println("generatePowers " + value.getId() + "= " + value.getRes());
                                    }

                                    @Override
                                    public void onError(Throwable t) {
                                        System.out.println("generatePowers error: " + t.getMessage());
                                    }

                                    @Override
                                    public void onCompleted() {
                                        System.out.println("generatePowers completed");
                                    }
                                });

                        break;
                    case 3: //somar a sequencia dos numeros de x a y com stub não bloqueante

                        //StreamObserver<Number> res1 = 
                        
                        noBlockStub.addSeqOfNumbers(new StreamObserver<Result>() {
                            @Override
                            public void onNext(Result value) {
                                System.out.println("addSeqOfNumbers " + value.getId() + "= " + value.getRes());
                            }

                            @Override
                            public void onError(Throwable t) {
                                System.out.println("addSeqOfNumbers error: " + t.getMessage());
                            }

                            @Override
                            public void onCompleted() {
                                System.out.println("addSeqOfNumbers completed");
                            }
                        });
                        break;
                    case 4: //sequencia de operacões de soma x + y + z + ... com stub não bloqueante

                        StreamObserver<AddOperands> req1 = noBlockStub.multipleAdd(new StreamObserver<Result>() {
                            @Override
                            public void onNext(Result value) {
                                System.out.println("multipleAdd " + value.getId() + "= " + value.getRes());
                            }

                            @Override
                            public void onError(Throwable t) {
                                System.out.println("multipleAdd error: " + t.getMessage());
                            }

                            @Override
                            public void onCompleted() {
                                System.out.println("multipleAdd completed");
                            }
                        });
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
