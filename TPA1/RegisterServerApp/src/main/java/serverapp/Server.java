package serverapp;

import calcstubs.*;
import calcstubs.Number;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;


public class Server extends CalcServiceGrpc.CalcServiceImplBase {

    private static int svcPort = 8500;

    public static void main(String[] args) {
        try {
            if (args.length > 0) svcPort = Integer.parseInt(args[0]);
            io.grpc.Server svc = ServerBuilder
                .forPort(svcPort)
                .addService(new Server())
                .build();
            svc.start();
            System.out.println("Server started, listening on " + svcPort);
            //Scanner scan = new Scanner(System.in);
            //scan.nextLine();
            svc.awaitTermination();
            svc.shutdown();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void add(AddOperands request, StreamObserver<Result> responseObserver) {
        int result = request.getOp1() + request.getOp2();
        Result r = Result.newBuilder().setId(request.getId()).setRes(result).build();
        responseObserver.onNext(r);
        responseObserver.onCompleted();
    }

    @Override
    public void generatePowers(NumberAndMaxExponent request, StreamObserver<Result> responseObserver) {
        for(int i= 1; i <= request.getMaxExponent(); i++){
            int result = (int) Math.pow(request.getBaseNumber(), i);
            Result r = Result.newBuilder().setId(request.getBaseNumber() + "^"+ i).setRes(result).build();
            responseObserver.onNext(r);
        }

        responseObserver.onCompleted();
    }

    @Override
    public StreamObserver<Number> addSeqOfNumbers(StreamObserver<Result> responseObserver) {
        ServerStreamObserverC3 reqs = new ServerStreamObserverC3(responseObserver);
        return reqs;
    }

    @Override
    public StreamObserver<AddOperands> multipleAdd(StreamObserver<Result> responseObserver) {
        return new StreamObserver<AddOperands>() {
            int result = 0;

            @Override
            public void onNext(AddOperands value) {
                result += value.getOp1() + value.getOp2();
                Result response = Result.newBuilder().setRes(result).build();
                responseObserver.onNext(response);
            }

            @Override
            public void onError(Throwable t) {

            }

            @Override
            public void onCompleted() {
                responseObserver.onCompleted();
            }
        };
    }
}
