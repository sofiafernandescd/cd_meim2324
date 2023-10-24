package clientapp;

import clientregisterstubs.Result;
import io.grpc.stub.StreamObserver;

import java.util.ArrayList;
import java.util.List;

public class ClientStreamObserver implements StreamObserver<Result> {
    private boolean isCompleted=false;
    private boolean success=false;

    public boolean OnSuccess() { return success; }
    public boolean isCompleted() { return isCompleted; }
    List<Result> results = new ArrayList<Result>();
    public List<Result> getResults() { return results; }

    @Override
    public void onNext(Result result) {
        System.out.println("Result ("+ result.getId() +"):"+ result.getRes());
        results.add(result);
    }

    @Override
    public void onError(Throwable throwable) {
        System.out.println("Error on call:"+ throwable.getMessage());
        isCompleted=true; success=false;
    }

    @Override
    public void onCompleted() {
        System.out.println("Stream completed");
        isCompleted=true; success=true;
    }
}
