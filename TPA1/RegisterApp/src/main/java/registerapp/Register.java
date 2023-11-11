package registerapp;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import clientregisterstubs.RegisterServiceGrpc;
import registerserverstubs.*;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;


public class Register {

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

    private List<ServerInfo> registedServers = new ArrayList<>();



    @Override
    public void GetNextServer(Empty request, StreamObserver<ServerInfo> responseObserver) {
        if (registedServers.isEmpty()) {
            responseObserver.onError(new StatusException(Status.NOT_FOUND.withDescription("No server available.")));
        } else {
            SeverInfo nextServer = registedServers.get(0);
            responseObserver.onNext(nextServer);
            responseObserver.onCompleted();
        }
    }

    

    ServerList myServerList = ServerList.newBuilder()
    .addServers(ServerInfo.newBuilder().setServerId("1").setIp("192.168.1.1").setPort(8080).build())
    .addServers(ServerInfo.newBuilder().setServerId("2").setIp("192.168.1.2").setPort(8081).build())
    .build();

    
}
