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

    public synchronized void registServer(ServerInfo serverInfo, StreamObserver<ServerResponse> result) {

        // adicionar à lista de servidores
        String newServer = serverInfo.getIp() + ':' + serverInfo.getPort();
        registerInfo.addServerToList(newServer); //Formato: IP:PORT

        ServerResponse response = ServerResponse.newBuilder().setResponse("You have been registered!").build();
        result.onNext(response);
        result.onCompleted();

        System.out.println("> Server " + newServer + " has been registered");

    }


}


