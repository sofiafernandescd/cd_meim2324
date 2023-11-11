package registerapp;

import io.grpc.Status;
import io.grpc.StatusException;
import io.grpc.StatusRuntimeException;
import io.grpc.stub.StreamObserver;
import ContractRegisterServer.ServerInfo;
import ContractRegisterServer.ServerResponse;
//import ContractRegisterServer.NextServer;
import ContractRegisterServer.RegisterServiceGrpc;

// LinkedList to keep the Servers
import java.util.LinkedList;

public class RegistServerServiceImpl extends RegisterServiceGrpc.RegisterServiceImplBase {

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

    public synchronized void getNextServer(KvServerInfo serverInfo, StreamObserver<NextServer> resSO) {
        String requestingServer = serverInfo.getServerIP() + ':' + serverInfo.getServerPort();
        LinkedList<String> ServersList = registerInfo.getListOfServers();

        // se o servidor que faz o pedido não estiver registado, retornar erro
        if (!ServersList.contains(requestingServer)) {
            Throwable th = new StatusException(Status.PERMISSION_DENIED
                    .withDescription("Can't get next server because you are not registered"));

            resSO.onError(th);
        }
        // se faltarem servidores por se registar, informar para fazer um novo pedido
        else if (registerInfo.getNumberOfServers() < registerInfo.getNServers()) {
            Throwable th = new StatusRuntimeException(Status.UNAVAILABLE
                    .withDescription("The ring hasn't formed yet, try again later"));

            resSO.onError(th);
        } else {
            // se o servidor que faz o pedido  do próximo servidor for o último da lista, retornar o primeiro da lista
            if (ServersList.getLast().equals(requestingServer)) {
                String[] nextServer = ServersList.getFirst().split(":");

                NextServer response = NextServer.newBuilder()
                        .setNextServerIP(nextServer[0])
                        .setNextServerPort(Integer.parseInt(nextServer[1]))
                        .build();

                resSO.onNext(response);
                resSO.onCompleted();
            }else {
                // apenas retornar o próximo elemento da lista
                int index = ServersList.indexOf(requestingServer);
                String[] nextServer = ServersList.get(++index).split(":");

                NextServer response = NextServer.newBuilder()
                        .setNextServerIP(nextServer[0])
                        .setNextServerPort(Integer.parseInt(nextServer[1]))
                        .build();

                resSO.onNext(response);
                resSO.onCompleted();
            }
        }
    }

    public synchronized void failInform(KvServerInfo serverInfo, StreamObserver<NextServer> resSO) {
        // o servidor que chama este serviço informa no pedido o servidor sucessor que falhou
        String offlineServer = serverInfo.getServerIP() + ':' + serverInfo.getServerPort();

        LinkedList<String> ServersList = registerInfo.getListOfServers();

        // se apenas existir um servidor online e outro offline na lista
        // retornar erro visto que não haverá um próximo para retornar (apenas aplicável a esta implementação)
        if (ServersList.size() == 2) {
            Throwable th = new StatusException(
                    Status.PERMISSION_DENIED.withDescription("There are no more servers on the ring")
            );

            resSO.onError(th);
        } else {
            // se o servidor que falhar for o último da lista
            if (ServersList.getLast().equals(offlineServer)) {
                String[] nextServer = ServersList.getFirst().split(":");

                NextServer response = NextServer.newBuilder()
                        .setNextServerIP(nextServer[0])
                        .setNextServerPort(Integer.parseInt(nextServer[1]))
                        .build();

                resSO.onNext(response);
                resSO.onCompleted();

                ServersList.removeLast();
                registerInfo.decrementNkvServer();
                System.out.println("> updated KvServer list: " + ServersList);
            } else {
                int index = ServersList.indexOf(offlineServer);
                String[] nextServer = ServersList.get(++index).split(":");

                NextServer response = NextServer.newBuilder()
                        .setNextServerIP(nextServer[0])
                        .setNextServerPort(Integer.parseInt(nextServer[1]))
                        .build();

                resSO.onNext(response);
                resSO.onCompleted();

                ServersList.remove(--index);
                registerInfo.decrementNServer();
                System.out.println("> updated KvServer list: " + ServersList);
            }
        }
    }

}
