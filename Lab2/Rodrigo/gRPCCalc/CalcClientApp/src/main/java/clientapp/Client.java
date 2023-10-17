package clientapp;

import calcstubs.*;
import calcstubs.Number;
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
    private static CalcServiceGrpc.CalcServiceBlockingStub blockingStub;
    private static CalcServiceGrpc.CalcServiceStub noBlockStub;


    public static void main(String[] args) {
        Number[] numbers = new Number[]{
                Number.newBuilder().setNum(3).build(),
                Number.newBuilder().setNum(4).build(),
                Number.newBuilder().setNum(7).build(),
                Number.newBuilder().setNum(9).build()
        };

        AddOperands[] addOperands = new AddOperands[]{
                AddOperands.newBuilder().setOp1(2).setOp2(3).build(),
                AddOperands.newBuilder().setOp1(5).setOp2(6).build(),
                AddOperands.newBuilder().setOp1(8).setOp2(9).build(),
                AddOperands.newBuilder().setOp1(3).setOp2(1).build(),
                AddOperands.newBuilder().setOp1(6).setOp2(7).build(),
        };

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
                        Result res = blockingStub.add(AddOperands.newBuilder()
                                .setId("50+25")
                                .setOp1(50).setOp2(25)
                                .build());
                        System.out.println("add " + res.getId() + "= " + res.getRes());
                        break;
                    case 2: // calcular as  potencias de x^y
                        ClientStreamObserver resultStreamObs = new ClientStreamObserver();
                        noBlockStub.generatePowers(NumberAndMaxExponent.newBuilder()
                                .setId("2^5").setBaseNumber(2).setMaxExponent(5).build(), resultStreamObs);

                        while (!resultStreamObs.isCompleted()) {
                            System.out.println("Active and waiting for Case2 completed ");
                            Thread.sleep(1 * 1000);
                        }
                        break;
                    case 3: //somar a sequencia dos numeros de x a y
                        StreamObserver<Number> requestObserver = noBlockStub.addSeqOfNumbers(new StreamObserver<Result>() {
                            @Override
                            public void onNext(Result result) {
                                System.out.println("addSeqOfNumbers" + result.getId() + " = " + result.getRes());
                            }

                            @Override
                            public void onError(Throwable throwable) {
                                System.out.println("addSeqOfNumbers error: " + throwable.getMessage());
                            }

                            @Override
                            public void onCompleted() {
                                System.out.println("AddSeqOfNumbers completed");
                            }
                        });
                        try {
                            for (Number number : numbers) {
                                System.out.println("Sequence of numbers: " + number.getNum());
                                requestObserver.onNext(number);
                            }
                        } catch (RuntimeException e) {
                            requestObserver.onError(e);
                            throw e;
                        }
                        requestObserver.onCompleted();
                        break;
                    case 4: //sequencia de operacões de soma x + y
                        StreamObserver<AddOperands> requestObserver1 = noBlockStub.multipleAdd(new StreamObserver<Result>() {
                            @Override
                            public void onNext(Result result) {
                                System.out.println("multipleAdd" + result.getId() + "=" + result.getRes());
                            }

                            @Override
                            public void onError(Throwable throwable) {
                                System.out.println("multipleAdd error: " + throwable.getMessage());
                            }

                            @Override
                            public void onCompleted() {
                                System.out.println("multipleAdd completed");
                            }
                        });
                        try {
                            for (AddOperands operand : addOperands) {
                                System.out.println("Sequence of numbers: " + operand.getOp1() + "+" + operand.getOp2());
                                requestObserver1.onNext(operand);
                                Thread.sleep(1000);
                            }
                        } catch (RuntimeException e) {
                            requestObserver1.onError(e);
                            throw e;
                        }
                        requestObserver1.onCompleted();
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
