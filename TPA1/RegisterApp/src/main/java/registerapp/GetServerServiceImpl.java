package registerapp;

import ContractClientRegister.GetServerServiceGrpc;
import ContractClientRegister.ServerInfo;
import ContractClientRegister.Empty;
import io.grpc.Status;
import io.grpc.StatusException;
import io.grpc.stub.StreamObserver;

public class GetServerServiceImpl extends GetServerServiceGrpc.GetServerServiceImplBase {

    private final RegisterInfo registerInfo;
    private int counter;

    public GetServerServiceImpl(RegisterInfo registerInfo) {
        this.registerInfo = registerInfo;
    }

    public synchronized void getServerEndpoint(Empty request, StreamObserver<ServerInfo> result) {
        // se o anel ainda não estiver formado
        if (registerInfo.getNumberOfServers() < registerInfo.getNkvServers()) {
            Throwable th = new StatusException(Status.UNAVAILABLE);
            result.onError(th);
        }
        else {
            //Dar a volta à lista
            if (counter == registerInfo.getNkvServers()) counter = 0;

            String[] server = registerInfo.getListOfServers().get(counter).split(":");

            ServerInfo reply = ServerInfo.newBuilder()
                    .setServerIP(server[0])
                    .setServerPort(Integer.parseInt(server[1]))
                    .build();

            counter++;
            result.onNext(reply);
            result.onCompleted();
        }
    }

    // TODO
    public synchronized void failInform(ServerInfo serverInfo, StreamObserver<ServerInfo> result) {
        // o servidor que chama este serviço informa no pedido o servidor sucessor que falhou
        String offlineServer = serverInfo.getServerIP() + ':' + serverInfo.getServerPort();

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
                        .setServerInfoIP(nextServer[0])
                        .setServerInfoPort(Integer.parseInt(nextServer[1]))
                        .build();

                result.onNext(response);
                result.onCompleted();

                ServersList.removeLast();
                registerInfo.decrementNkvServer();
                System.out.println("> updated KvServer list: " + ServersList);
            } else {
                int index = ServersList.indexOf(offlineServer);
                String[] nextServer = ServersList.get(++index).split(":");

                ServerInfo response = ServerInfo.newBuilder()
                        .setServerInfoIP(nextServer[0])
                        .setServerInfoPort(Integer.parseInt(nextServer[1]))
                        .build();

                result.onNext(response);
                result.onCompleted();

                ServersList.remove(--index);
                registerInfo.decrementNServer();
                System.out.println("> updated KvServer list: " + ServersList);
            }
        }
    }

}
