package registerapp;

import registerserverstubs.*;
import clientserverstubs.*;
import io.grpc.stub.StreamObserver;

public class ServerStreamObserverC3 implements StreamObserver<ImageBlock> {
    StreamObserver<ImageBlock> sFinalResult;
    int finalResult;

    public ServerStreamObserverC3(StreamObserver<ImageBlock> sresults) {
        this.sFinalResult = sresults;
    }


    @Override
    public void onNext(ImageBlock number) {
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
