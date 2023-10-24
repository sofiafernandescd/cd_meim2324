package serverapp;

import calcstubs.Number;
import calcstubs.Result;
import io.grpc.stub.StreamObserver;

public class ServerStreamObserverC3 implements StreamObserver<Number> {
    StreamObserver<Result> sFinalResult;
    int finalResult;

    public ServerStreamObserverC3(StreamObserver<Result> sresults) {
        this.sFinalResult = sresults;
    }


    @Override
    public void onNext(Number number) {
        finalResult += number.getNum();
    }

    @Override
    public void onError(Throwable throwable) {
        System.out.println("Error on call:"+ throwable.getMessage());
    }

    @Override
    public void onCompleted() {
        Result result = Result.newBuilder().setId("Soma").setRes(finalResult).build();
        sFinalResult.onNext(result);
        sFinalResult.onCompleted();
    }
}
