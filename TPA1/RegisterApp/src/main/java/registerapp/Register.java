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
            server.awaitTermination();
            server.shutdown();
        }
        catch (Exception e) {
            System.out.println("> " + e);
        }
    }

}
