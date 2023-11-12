package registerapp;

import registerserverstubs.Empty;
import registerserverstubs.ServerInfo;
//import registerserverstubs.ServerList;
//import registerapp.RegisterInfo.ServersList;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.Status;
import io.grpc.StatusException;
import io.grpc.stub.StreamObserver;

import java.util.Scanner;


public class Register {

    private static final String REGISTER_IP = "localhost";
    private static final int REGISTER_PORT = 8005;


    public static void main(String[] args) {

        RegisterInfo registerInfo = new RegisterInfo();

        try {
            io.grpc.Server server = ServerBuilder.forPort(REGISTER_PORT)
                    .addService(new RegisterServerServiceImpl(registerInfo))
                    .addService(new ClientRegisterServiceImpl(registerInfo))
                    .build();

            server.start();
            System.out.println("> Register running on IP: " + REGISTER_IP);
            System.out.println("> Register running on port: " + REGISTER_PORT);

            // Separate thread to handle the termination logic
            Thread terminationThread = new Thread(() -> {
                waitForTerminationSignal(server);
            });
            terminationThread.start();

            // Wait for the server to terminate
            server.awaitTermination();
        }

        catch (Exception e) {
            System.out.println("> " + e);
        }
    }

    private static void waitForTerminationSignal(Server server) {
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


