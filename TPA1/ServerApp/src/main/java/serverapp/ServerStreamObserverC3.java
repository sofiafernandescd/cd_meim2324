package serverapp;

import com.google.protobuf.ByteString;
import registerserverstubs.*;
import clientserverstubs.*;
import io.grpc.stub.StreamObserver;

import java.awt.*;

public class ServerStreamObserverC3 implements StreamObserver<ImageBlock> {
    StreamObserver<ImageBlock> sFinalResult;
    ImageBlock finalResult;

    public ServerStreamObserverC3(StreamObserver<ImageBlock> sresults) {
        this.sFinalResult = sresults;
    }


    @Override
    public void onNext(ImageBlock number) {
        finalResult = number;
    }

    @Override
    public void onError(Throwable throwable) {
        System.out.println("Error on call:"+ throwable.getMessage());
    }

    @Override
    public void onCompleted() {
        ImageBlock result = ImageBlock.newBuilder().setData(finalResult.getData()).build();
        sFinalResult.onNext(result);
        sFinalResult.onCompleted();
    }
}
