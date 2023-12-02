package manager;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;
import manageruserstubs.Category;
import manageruserstubs.ContractManagerUserGrpc;
import manageruserstubs.Sale;

import com.google.protobuf.Timestamp;

import java.util.Date;


public class ManagerServerGrpc extends ContractManagerUserGrpc.ContractManagerUserImplBase {

    public static void main(String[] args) throws Exception {
        Server server = ServerBuilder.forPort(9090)
                .addService(new ManagerGRPCServer())
                .build();

        System.out.println("Iniciando servidor gRPC na porta 9090");
        server.start();
        server.awaitTermination();
    }

    @Override
    public void getResume(Category request, StreamObserver<Sale> responseObserver) {
        // Lógica para processar o pedido de resumo e enviar várias vendas
        String categoria = request.getCategory();

        // Implemente a lógica para obter e enviar várias vendas aqui
        for (int i = 0; i < 5; i++) {
            Date data = new Date();
            Timestamp timestamp = Timestamp.newBuilder()
                    .setSeconds(data.getTime() / 1000)  // segundos desde o epoch
                    .setNanos((int) ((data.getTime() % 1000) * 1000000))  // nanos
                    .build();
            Sale sale = Sale.newBuilder()
                    .setData(timestamp)
                    .setCodigoProduto("00000")
                    .setNomeProduto("Produto" + i)
                    .setQuantidade(i + 1)
                    .setPrecoUnitario(10.0 * (i + 1))
                    .setTotal(8.88)
                    .setIva(0.23)
                    .build();

            // Envie cada venda para o cliente
            responseObserver.onNext(sale);
        }

        // Sinalize o término do fluxo
        responseObserver.onCompleted();
    }
}
