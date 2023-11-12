package registerapp;

import clientregisterstubs.ClientRegisterServiceGrpc;
import clientregisterstubs.ServerInfo;
import clientregisterstubs.Empty;
import clientregisterstubs.ServerResponse;
import io.grpc.Status;
import io.grpc.StatusException;
import io.grpc.stub.StreamObserver;

import java.util.LinkedList;

public class ClientRegisterServiceImpl extends ClientRegisterServiceGrpc.ClientRegisterServiceImplBase {

    private final RegisterInfo registerInfo;
    private int counter;

    public ClientRegisterServiceImpl(RegisterInfo registerInfo) {
        this.registerInfo = registerInfo;
    }

    public synchronized void getServerEndpoint(Empty request, StreamObserver<ServerInfo> result) {
        // se o anel ainda não estiver formado
        if (registerInfo.getNumberOfServers() < registerInfo.getNServers()) {
            Throwable th = new StatusException(Status.UNAVAILABLE);
            result.onError(th);
        }
        else {
            //Dar a volta à lista
            if (counter == registerInfo.getNServers()) counter = 0;

            String[] server = registerInfo.getListOfServers().get(counter).split(":");

            ServerInfo reply = ServerInfo.newBuilder()
                    .setIp(server[0])
                    .setPort(Integer.parseInt(server[1]))
                    .build();

            counter++;
            result.onNext(reply);
            result.onCompleted();
        }
    }

    // TODO
    @Override
    public synchronized void failInform(ServerInfo serverInfo, StreamObserver<ServerInfo> result) {
        // o servidor que chama este serviço informa no pedido o servidor sucessor que falhou
        String offlineServer = serverInfo.getIp() + ':' + serverInfo.getPort();

        LinkedList<String> ServersList = registerInfo.getListOfServers();

        // se apenas existir um servidor online e outro offline na lista
        // retornar erro visto que não haverá um próximo para retornar (apenas aplicável a esta implementação)
        if (ServersList.size() == 2) {
            Throwable th = new StatusException(
                    Status.PERMISSION_DENIED.withDescription("There are no more servers on the ring")
            );

            result.onError(th);
        } else {
            // se o servidor que falhar for o último da lista
            if (ServersList.getLast().equals(offlineServer)) {
                String[] nextServer = ServersList.getFirst().split(":");

                ServerInfo response = ServerInfo.newBuilder()
                        .setIp(nextServer[0])
                        .setPort(Integer.parseInt(nextServer[1]))
                        .build();

                result.onNext(response);
                result.onCompleted();

                ServersList.removeLast();
                //registerInfo.decrementServer();
                System.out.println("> updated Server list: " + ServersList);
            } else {
                int index = ServersList.indexOf(offlineServer);
                String[] nextServer = ServersList.get(++index).split(":");

                ServerInfo response = ServerInfo.newBuilder()
                        .setIp(nextServer[0])
                        .setPort(Integer.parseInt(nextServer[1]))
                        .build();

                result.onNext(response);
                result.onCompleted();

                ServersList.remove(--index);
                //registerInfo.decrementNServer();
                System.out.println("> updated KvServer list: " + ServersList);
            }
        }
    }

    public synchronized void getNextServer(ServerInfo serverInfo, StreamObserver<ServerInfo> result) {
        String requestServer = serverInfo.getIp() + ':' + serverInfo.getPort();
        LinkedList<String> ServersList = registerInfo.getListOfServers();

        // se o servidor que faz o pedido  do próximo servidor for o último da lista, retornar o primeiro da lista
        if (ServersList.getLast().equals(requestServer)) {
            String[] nextServer = ServersList.getFirst().split(":");

            ServerInfo response = ServerInfo.newBuilder()
                    .setIp(nextServer[0])
                    .setPort(Integer.parseInt(nextServer[1]))
                    .build();

            result.onNext(response);
            result.onCompleted();
        } else {
            // apenas retornar o próximo elemento da lista
            int index = ServersList.indexOf(requestServer);
            String[] nextServer = ServersList.get(++index).split(":");

            ServerInfo response = ServerInfo.newBuilder()
                    .setIp(nextServer[0])
                    .setPort(Integer.parseInt(nextServer[1]))
                    .build();

            result.onNext(response);
            result.onCompleted();
        }
    }

}
