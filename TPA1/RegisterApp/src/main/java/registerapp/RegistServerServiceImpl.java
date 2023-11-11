package registerapp;

import io.grpc.Status;
import io.grpc.StatusException;
import io.grpc.StatusRuntimeException;
import io.grpc.stub.StreamObserver;
import ContractRegisterServer.ServerInfo;
import ContractRegisterServer.ServerResponse;
//import ContractRegisterServer.ServerInfo;
import ContractRegisterServer.RegistServerServiceGrpc;

// LinkedList to keep the Servers
import java.util.LinkedList;

public class RegistServerServiceImpl extends RegistServerServiceGrpc.RegistServerServiceImplBase {

    private final RegisterInfo registerInfo;

    public RegistServerServiceImpl(RegisterInfo registerInfo) {
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

        // se o servidor que faz o pedido não estiver registado, retornar erro
        if (!ServersList.contains(requestServer)) {
            Throwable th = new StatusException(Status.PERMISSION_DENIED
                    .withDescription("Can't get next server because you are not registered"));

            result.onError(th);
        }
        // se faltarem servidores por se registar, informar para fazer um novo pedido
        else if (registerInfo.getNumberOfServers() < registerInfo.getNServers()) {
            Throwable th = new StatusRuntimeException(Status.UNAVAILABLE
                    .withDescription("The ring hasn't formed yet, try again later"));

            result.onError(th);
        } else {
            // se o servidor que faz o pedido  do próximo servidor for o último da lista, retornar o primeiro da lista
            if (ServersList.getLast().equals(requestServer)) {
                String[] nextServer = ServersList.getFirst().split(":");

                ServerInfo response = ServerInfo.newBuilder()
                        .setServerInfoIP(nextServer[0])
                        .setServerInfoPort(Integer.parseInt(nextServer[1]))
                        .build();

                result.onNext(response);
                result.onCompleted();
            }else {
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
