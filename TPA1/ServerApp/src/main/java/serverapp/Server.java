package serverapp;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;
import registerserverstubs.*;
import clientserverstubs.*;
import io.grpc.ServerBuilder;

public class Server{

    //params do kvServer
    private static String SERVER_IP;
    private static int SERVER_PORT;

    //params do Register
    private static String REGISTER_IP;
    private static final int REGISTER_PORT = 8002;

    private static ManagedChannel channel;
    private static RegisterServerServiceGrpc.RegisterServerServiceBlockingStub registerServiceBlockingStub;

    static boolean registerRequest() {
        System.out.println("> sending register request to: " + REGISTER_IP);
        ServerInfo request = ServerInfo.newBuilder()
                .setIp(SERVER_IP)
                .setPort(SERVER_PORT)
                .build();

        try {
            ServerResponse response = registerServiceBlockingStub.registServer(request);
            System.out.println("> Register response: " + response.getResponse());
            return true;
        }
        catch (StatusRuntimeException e) {
            System.out.println("> Register response: " + e.getMessage());
            return false;
        }
    }

    public static void main(String[] args) {
        try {
            if (args.length == 3) {
                SERVER_IP = args[0];
                SERVER_PORT = Integer.parseInt(args[1]);
                REGISTER_IP = args[2];
            }

            io.grpc.Server server = ServerBuilder
                    .forPort(SERVER_PORT)
                    .addService(new ProcessImageServiceImpl())
                    .build();
            server.start();
            System.out.println("Server started, listening on " + SERVER_PORT);

            // conectar ao ringManager
            System.out.println("> connecting to: " + REGISTER_IP + ":" + REGISTER_PORT);
            channel = ManagedChannelBuilder.forAddress(REGISTER_IP, REGISTER_PORT)
                    .usePlaintext()
                    .build();

            registerServiceBlockingStub = RegisterServerServiceGrpc.newBlockingStub(channel);

            // registar no Servidor de Registo
            registerRequest();

            server.awaitTermination();
            server.shutdown();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
