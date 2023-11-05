package serverapp;

import clientregisterstubs.RegisterServiceGrpc;
import registerserverstubs.*;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;


public class Register extends RegisterServiceGrpc.RegisterServiceImplBase{

    private static int svcPort = 8500;

    public static void main(String[] args) {
        try {
            if (args.length > 0) svcPort = Integer.parseInt(args[0]);
            io.grpc.Server svc = ServerBuilder
                .forPort(svcPort)
                .addService(new Register())
                .build();
            svc.start();
            System.out.println("Server started, listening on " + svcPort);
            //Scanner scan = new Scanner(System.in);
            //scan.nextLine();
            svc.awaitTermination();
            svc.shutdown();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
