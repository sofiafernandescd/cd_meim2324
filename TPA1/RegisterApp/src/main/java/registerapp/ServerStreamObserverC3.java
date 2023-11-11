package registerapp;

import registerserverstubs.*;
import io.grpc.stub.StreamObserver;

public class ServerStreamObserverC3 implements StreamObserver<ServerInfo> {
    StreamObserver<ServerInfo> sFinalResult;
    int finalResult;

    public ServerStreamObserverC3(StreamObserver<ServerInfo> sresults) {
        this.sFinalResult = sresults;
    }


    @Override
        public void onNext(ServerInfo number) {
        finalResult += number.getPort();
    }

    @Override
    public void onError(Throwable throwable) {
        System.out.println("Error on call:"+ throwable.getMessage());
    }

    @Override
    public void onCompleted() {
        ServerInfo result = ServerInfo.newBuilder().setIp("Port").setPort().build();
        sFinalResult.onNext(result);
        sFinalResult.onCompleted();
    }
}
