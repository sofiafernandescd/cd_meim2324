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

    public synchronized void getNextServer(ServerInfo serverInfo, StreamObserver<ServerInfo> result) {
        String requestServer = serverInfo.getServerIP() + ':' + serverInfo.getServerPort();
        LinkedList<String> ServersList = registerInfo.getListOfServers();

        // se o servidor que faz o pedido  do próximo servidor for o último da lista, retornar o primeiro da lista
        if (ServersList.getLast().equals(requestServer)) {
            String[] nextServer = ServersList.getFirst().split(":");

            ServerInfo response = ServerInfo.newBuilder()
                    .setServerInfoIP(nextServer[0])
                    .setServerInfoPort(Integer.parseInt(nextServer[1]))
                    .build();

            result.onNext(response);
            result.onCompleted();
        } else {
            // apenas retornar o próximo elemento da lista
            int index = ServersList.indexOf(requestServer);
            String[] nextServer = ServersList.get(++index).split(":");

            ServerInfo response = ServerInfo.newBuilder()
                    .setServerInfoIP(nextServer[0])
                    .setServerInfoPort(Integer.parseInt(nextServer[1]))
                    .build();

            result.onNext(response);
            result.onCompleted();
        }
    }
}


}
