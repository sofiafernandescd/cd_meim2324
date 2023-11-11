package ringmanager;

import io.grpc.Status;
import io.grpc.StatusException;
import io.grpc.StatusRuntimeException;
import io.grpc.stub.StreamObserver;
import kvServerToManager.KvServerInfo;
import kvServerToManager.NextServer;
import kvServerToManager.RegisterServiceGrpc;
import kvServerToManager.Reply;

import java.util.LinkedList;

public class RegisterServiceImpl extends RegisterServiceGrpc.RegisterServiceImplBase {

    private final RingInfo ringInfo;

    public RegisterServiceImpl(RingInfo ringInfo) {
        this.ringInfo = ringInfo;
    }

    public synchronized void registerServer(KvServerInfo serverInfo, StreamObserver<Reply> resSO) {
        // se o número de servidores  for igual a N, retornar erro
        if (ringInfo.getNumberOfServers() >= ringInfo.getNkvServers()) {
            Throwable th = new StatusException(Status.RESOURCE_EXHAUSTED
                    .withDescription("Max number of servers reached"));

            resSO.onError(th);
        } else {
            // apenas adicionar à lista de servidores
            String newServer = serverInfo.getServerIP() + ':' + serverInfo.getServerPort();
            ringInfo.addServerToList(newServer); //Formato: IP:PORT

            Reply reply = Reply.newBuilder().setReply("You have been registered!").build();
            resSO.onNext(reply);
            resSO.onCompleted();

            System.out.println("> kvServer " + newServer + " has been registered");
        }
    }

    public synchronized void getNextServer(KvServerInfo serverInfo, StreamObserver<NextServer> resSO) {
        String requestingServer = serverInfo.getServerIP() + ':' + serverInfo.getServerPort();
        LinkedList<String> kvServersList = ringInfo.getListOfServers();

        // se o servidor que faz o pedido não estiver registado, retornar erro
        if (!kvServersList.contains(requestingServer)) {
            Throwable th = new StatusException(Status.PERMISSION_DENIED
                    .withDescription("Can't get next server because you are not registered"));

            resSO.onError(th);
        }
        // se faltarem servidores por se registar, informar para fazer um novo pedido
        else if (ringInfo.getNumberOfServers() < ringInfo.getNkvServers()) {
            Throwable th = new StatusRuntimeException(Status.UNAVAILABLE
                    .withDescription("The ring hasn't formed yet, try again later"));

            resSO.onError(th);
        } else {
            // se o servidor que faz o pedido  do próximo servidor for o último da lista, retornar o primeiro da lista
            if (kvServersList.getLast().equals(requestingServer)) {
                String[] nextServer = kvServersList.getFirst().split(":");

                NextServer reply = NextServer.newBuilder()
                        .setNextServerIP(nextServer[0])
                        .setNextServerPort(Integer.parseInt(nextServer[1]))
                        .build();

                resSO.onNext(reply);
                resSO.onCompleted();
            }else {
                // apenas retornar o próximo elemento da lista
                int index = kvServersList.indexOf(requestingServer);
                String[] nextServer = kvServersList.get(++index).split(":");

                NextServer reply = NextServer.newBuilder()
                        .setNextServerIP(nextServer[0])
                        .setNextServerPort(Integer.parseInt(nextServer[1]))
                        .build();

                resSO.onNext(reply);
                resSO.onCompleted();
            }
        }
    }

    public synchronized void failInform(KvServerInfo serverInfo, StreamObserver<NextServer> resSO) {
        // o servidor que chama este serviço informa no pedido o servidor sucessor que falhou
        String offlineServer = serverInfo.getServerIP() + ':' + serverInfo.getServerPort();

        LinkedList<String> kvServersList = ringInfo.getListOfServers();

        // se apenas existir um servidor online e outro offline na lista
        // retornar erro visto que não haverá um próximo para retornar (apenas aplicável a esta implementação)
        if (kvServersList.size() == 2) {
            Throwable th = new StatusException(
                    Status.PERMISSION_DENIED.withDescription("There are no more servers on the ring")
            );

            resSO.onError(th);
        } else {
            // se o servidor que falhar for o último da lista
            if (kvServersList.getLast().equals(offlineServer)) {
                String[] nextServer = kvServersList.getFirst().split(":");

                NextServer reply = NextServer.newBuilder()
                        .setNextServerIP(nextServer[0])
                        .setNextServerPort(Integer.parseInt(nextServer[1]))
                        .build();

                resSO.onNext(reply);
                resSO.onCompleted();

                kvServersList.removeLast();
                ringInfo.decrementNkvServer();
                System.out.println("> updated KvServer list: " + kvServersList);
            } else {
                int index = kvServersList.indexOf(offlineServer);
                String[] nextServer = kvServersList.get(++index).split(":");

                NextServer reply = NextServer.newBuilder()
                        .setNextServerIP(nextServer[0])
                        .setNextServerPort(Integer.parseInt(nextServer[1]))
                        .build();

                resSO.onNext(reply);
                resSO.onCompleted();

                kvServersList.remove(--index);
                ringInfo.decrementNkvServer();
                System.out.println("> updated KvServer list: " + kvServersList);
            }
        }
    }

}
