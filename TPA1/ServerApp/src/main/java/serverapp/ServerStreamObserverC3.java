package serverapp;

import com.google.protobuf.ByteString;
import registerserverstubs.*;
import clientserverstubs.*;
import io.grpc.stub.StreamObserver;

import java.awt.*;

public class ServerStreamObserverC3 implements StreamObserver<ImageBlock> {
    StreamObserver<ImageBlock> sFinalResult;
    ImageBlock finalResult;

    @Override
public StreamObserver<ImagemChunk> uploadImagem(StreamObserver<Resposta> responseObserver) {
    return new StreamObserver<ImagemChunk>() {
        @Override
        public void onNext(ImagemChunk imagemChunk) {
            // Processar e armazenar os blocos de imagem conforme necessário.
        }

        @Override
        public void onError(Throwable t) {
            // Trate erros.
        }

        @Override
        public void onCompleted() {
            // Realize alguma ação quando o cliente terminar o streaming.
            responseObserver.onNext(Resposta.newBuilder().setMessage("Imagem recebida com sucesso!").build());
            responseObserver.onCompleted();
        }
    };
}

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
