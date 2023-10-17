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
        Result response = Result.newBuilder().setId(request.getId()).setRes(result).build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public void generatePowers(NumberAndMaxExponent request, StreamObserver<Result> responseObserver) {
        int baseNumber = request.getBaseNumber();
        int maxExponent = request.getMaxExponent();

        Result.Builder resultBuilder = Result.newBuilder().setId(request.getId());
        for (int exponent = 1; exponent <= maxExponent; exponent++) {
            int value = (int) Math.pow(baseNumber, exponent);
            resultBuilder.setRes(value);

            Result response = resultBuilder.build();
            responseObserver.onNext(response);
        
        }
        responseObserver.onCompleted();

        
    }



    @Override
    public StreamObserver<Number> addSeqOfNumbers(StreamObserver<Result> responseObserver) {
        return new StreamObserver<Number>() {
            int sum = 0;

            @Override
            public void onNext(Number value) {
                sum += value.getNum();
            }

            @Override
            public void onError(Throwable t) {
                // Tratamento de erro, se necessário
            }

            @Override
            public void onCompleted() {
                Result response = Result.newBuilder().setRes(sum).build();
                responseObserver.onNext(response);
                responseObserver.onCompleted();
            }
        };

    }

    @Override
    public StreamObserver<AddOperands> multipleAdd(StreamObserver<Result> responseObserver) {
       return new StreamObserver<AddOperands>() {
        int result = 0;

        @Override
        public void onNext(AddOperands value) {
            result += value.getOp1() + value.getOp2();
        }

        @Override
        public void onError(Throwable t) {
            // Tratamento de erro, se necessário
        }

        @Override
        public void onCompleted() {
            Result response = Result.newBuilder().setRes(result).build();
            responseObserver.onNext(response);
            responseObserver.onCompleted();
        }
    };

    }
}
