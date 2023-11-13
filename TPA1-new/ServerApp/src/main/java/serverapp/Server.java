package serverapp;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;
import registerserverstubs.RegisterServerServiceGrpc;
import registerserverstubs.ServerInfo;
import registerserverstubs.ServerResponse;
import clientserverstubs.*;
import io.grpc.ServerBuilder;

import java.util.Scanner;

public class Server{


    //params do kvServer
    private static String SERVER_IP;
    private static int SERVER_PORT;

    //params do Register
    private static String REGISTER_IP;
    private static final int REGISTER_PORT = 8005;

    private static ManagedChannel channel;
    private static RegisterServerServiceGrpc.RegisterServerServiceBlockingStub registerServiceBlockingStub;

    public static ImagesInfo imagesInfo = new ImagesInfo();

    static boolean registerRequest() {
        System.out.println("> sending register request to IP: " + REGISTER_IP);
        System.out.println("> sending register request to Port: " + REGISTER_PORT);
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
            // Parse command-line arguments
            if (args.length == 3) {
                SERVER_IP = args[0];
                SERVER_PORT = Integer.parseInt(args[1]);
                REGISTER_IP = args[2];
            }
            

            // Start the gRPC server
            io.grpc.Server server = ServerBuilder
                    .forPort(SERVER_PORT)
                    .addService(new ProcessImageServiceImpl(imagesInfo))
                    .build();
            server.start();
            System.out.println("Server started, listening on " + SERVER_PORT);

            // Connect to the Register Server
            System.out.println("> connecting to: " + REGISTER_IP + ":" + REGISTER_PORT);
            channel = ManagedChannelBuilder.forAddress(REGISTER_IP, REGISTER_PORT)
                    .usePlaintext()
                    .build();

            // Create a blocking stub for the Register Server
            registerServiceBlockingStub = RegisterServerServiceGrpc.newBlockingStub(channel);

            // Regist Server with the Register
            registerRequest();

            // Separate thread to handle the termination logic
            Thread terminationThread = new Thread(() -> {
                waitForTerminationSignal(server);
            });
            terminationThread.start();

            // Wait for the server to terminate
            server.awaitTermination();


        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private static void waitForTerminationSignal(io.grpc.Server server) {
        System.out.println("Press 'q' and Enter to gracefully shut down the server.");
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String input = scanner.nextLine();
            if ("q".equalsIgnoreCase(input.trim())) {
                System.out.println("Terminating the server...");
                try {
                    server.shutdown();
                    break;
                } catch (Exception e) {
                    System.out.println("Error shutting down the server: " + e.getMessage());
                }
            }
        }
    }

}
