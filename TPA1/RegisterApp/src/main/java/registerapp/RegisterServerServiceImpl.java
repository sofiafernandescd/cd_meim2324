package registerapp;

import io.grpc.Status;
import io.grpc.StatusException;
import io.grpc.StatusRuntimeException;
import io.grpc.stub.StreamObserver;
import registerserverstubs.ServerInfo;
import registerserverstubs.ServerResponse;
import registerserverstubs.RegisterServerServiceGrpc;

// LinkedList to keep the Servers
import java.util.LinkedList;

public class RegisterServerServiceImpl extends RegisterServerServiceGrpc.RegisterServerServiceImplBase {

    private final RegisterInfo registerInfo;

    public RegisterServerServiceImpl(RegisterInfo registerInfo) {
        this.registerInfo = registerInfo;
    }

    public synchronized void registServer(ServerInfo serverInfo, StreamObserver<ServerResponse> response) {

        // adicionar à lista de servidores
        String newServer = serverInfo.getServerIP() + ':' + serverInfo.getServerPort();
        registerInfo.addServerToList(newServer); //Formato: IP:PORT

        ServerResponse response = ServerResponse.newBuilder().setServerResponse("You have been registered!").build();
        response.onNext(response);
        response.onCompleted();

        System.out.println("> Server " + newServer + " has been registered");

    }


}


