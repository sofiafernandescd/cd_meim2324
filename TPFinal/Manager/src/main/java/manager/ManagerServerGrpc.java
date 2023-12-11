package manager;

import com.google.protobuf.ByteString;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;
import manageruserstubs.Category;
import manageruserstubs.ContractManagerUserGrpc;
import manageruserstubs.Resume;

import com.google.protobuf.Timestamp;

import java.net.InetAddress;
import java.util.Date;


public class ManagerServerGrpc extends ContractManagerUserGrpc.ContractManagerUserImplBase {

    public static void main(String[] args) throws Exception {
        Server server = ServerBuilder.forPort(9090)
                .addService(new ManagerServerGrpc())
                .build();

        System.out.println("Iniciando servidor gRPC na porta 9090");
        server.start();
        server.awaitTermination();
    }

    @Override
    public void getResume(Category request, StreamObserver<Resume> responseObserver) {
        // Lógica para processar o pedido de resumo e enviar várias vendas
        String categoria = request.getCategory();

        // Implemente a lógica para obter e enviar várias vendas aqui
        for (int i = 0; i < 5; i++) {
            Date data = new Date();
            /*Timestamp timestamp = Timestamp.newBuilder()
                    .setSeconds(data.getTime() / 1000)  // segundos desde o epoch
                    .setNanos((int) ((data.getTime() % 1000) * 1000000))  // nanos
                    .build();*/


            // Sample data as a string (you should replace this with your actual data)
            String resumeDataString = "This is a sample resume data.";

            // Convert the string to bytes
            byte[] resumeBlockFromExchange = resumeDataString.getBytes();

            // Now you can proceed with the rest of your code
            byte[] resumeBlock = resumeBlockFromExchange;

            Resume resume = Resume.newBuilder()
                                  .setCategory(request.getCategory())
                                  .setData(ByteString.copyFrom(resumeBlock))
                                  .build();

            // Envie cada venda para o cliente
            responseObserver.onNext(resume);
        }

        // Sinalize o término do fluxo
        responseObserver.onCompleted();
    }
}
