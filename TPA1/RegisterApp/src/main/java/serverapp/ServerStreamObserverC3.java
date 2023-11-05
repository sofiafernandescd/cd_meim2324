package serverapp;

import registerserverstubs.*;
import io.grpc.stub.StreamObserver;

public class ServerStreamObserverC3 implements StreamObserver<ServerInfo> {
    StreamObserver<Result> sFinalResult;
    int finalResult;

    public ServerStreamObserverC3(StreamObserver<Result> sresults) {
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
        Result result = Result.newBuilder().setResult("Port").build();
        sFinalResult.onNext(result);
        sFinalResult.onCompleted();
    }
}
