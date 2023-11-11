package serverapp;

// import calcstubs.*;
// import calcstubs.Number;
import registerserverstubs.*;
import clientserverstubs.*;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;
import serverapp.DockerAPI;
import serverapp.MarkApp;


public class Server extends RegisterServerServiceGrpc.RegisterServerServiceImplBase {

    private static int svcPort = 8500;

    private static RegisterServerServiceGrpc.RegisterServiceBlockingStub registerServiceBlockingStub;


    public static void main(String[] args) {
        try {
            if (args.length > 0) svcPort = Integer.parseInt(args[0]);
            io.grpc.Server svc = ServerBuilder
                .forPort(svcPort)
                .addService(new Server())
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

        @Override
        public void RegistServer(ServerInfo request, StreamObserver<Empty> responseObserver) {
            registedServers.add(request);
            responseObserver.onNext(Empty.getDefaultInstance());
            responseObserver.onCompleted();
        }
    }

}
