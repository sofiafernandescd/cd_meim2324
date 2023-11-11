package registerapp;

import clientToManager.GetServerServiceGrpc;
import clientToManager.ServerInfo;
import clientToManager.Void;
import io.grpc.Status;
import io.grpc.StatusException;
import io.grpc.stub.StreamObserver;

public class GetServerServiceImpl extends GetServerServiceGrpc.GetServerServiceImplBase {

    private final RingInfo ringInfo;
    private int counter;

    public GetServerServiceImpl(RingInfo ringInfo) {
        this.ringInfo = ringInfo;
    }

    public synchronized void getKvServer(Void request, StreamObserver<ServerInfo> resSO) {
        // se o anel ainda não estiver formado
        if (ringInfo.getNumberOfServers() < ringInfo.getNkvServers()) {
            Throwable th = new StatusException(Status.UNAVAILABLE);
            resSO.onError(th);
        }
        else {
            //Dar a volta à lista
            if (counter == ringInfo.getNkvServers()) counter = 0;

            String[] server = ringInfo.getListOfServers().get(counter).split(":");

            ServerInfo reply = ServerInfo.newBuilder()
                    .setServerIP(server[0])
                    .setServerPort(Integer.parseInt(server[1]))
                    .build();

            counter++;
            resSO.onNext(reply);
            resSO.onCompleted();
        }
    }

}
