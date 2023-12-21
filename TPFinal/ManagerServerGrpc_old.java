package manager;

import com.google.protobuf.ByteString;
import com.rabbitmq.client.*;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;
import manageruserstubs.Category;
import manageruserstubs.ContractManagerUserGrpc;
import manageruserstubs.Resume;
import spread.SpreadConnection;
import spread.SpreadException;
import spread.SpreadGroup;
import spread.SpreadMessage;

import java.net.InetAddress;
import java.net.UnknownHostException;




public class ManagerServerGrpc_old extends ContractManagerUserGrpc.ContractManagerUserImplBase {
    public final String ipInterno;
    private static final String EXCHANGE_RESUME = "ExgResumo";

    public ManagerServerGrpc_old(String ipInterno) {
        this.ipInterno = ipInterno;
    }

    //    private SpreadGroup spreadGroup;
    public static void main(String[] args) throws Exception {
        String ipInterno = args[0];
        Server server = ServerBuilder.forPort(9090)
                .addService(new ManagerServerGrpc_old(ipInterno))
                .build();

        System.out.println("Iniciando servidor gRPC na porta 9090");
        server.start();
        server.awaitTermination();
    }

    @Override
    public void getResume(Category request, StreamObserver<Resume> responseObserver) {
        final SpreadConnection spreadConnection;
        spreadConnection = new SpreadConnection();
        SpreadGroup spreadGroup = new SpreadGroup();
        try {
            spreadConnection.connect(InetAddress.getByName(ipInterno), 4803, "Manager", false, true);
            spreadGroup.join(spreadConnection, "SpreadGroup" + request.getCategory());
        } catch (SpreadException e) {
            throw new RuntimeException(e);
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        }
        // Lógica para processar o pedido de resumo e enviar várias vendas
        String categoria = request.getCategory();

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


        // Sinalize o término do fluxo
        responseObserver.onCompleted();

        // Solicita que os Workers realizem o resumo
        SpreadMessage spreadMessage = new SpreadMessage();
        spreadMessage.setSafe();
        spreadMessage.addGroup(spreadGroup);
        spreadMessage.setData(("RESUME_REQUEST " + categoria + " " + "summary.txt").getBytes());
        try {

            spreadConnection.multicast(spreadMessage);
        } catch (SpreadException e) {
            e.printStackTrace();
        }
    }

    private void receberNotificacaoResumo(String ipRabbitMQ, int portRabbitMQ) {
        try {
            ConnectionFactory factory = new ConnectionFactory();
            factory.setHost(ipRabbitMQ);
            factory.setPort(portRabbitMQ);

            try (Connection connection = factory.newConnection();
                 Channel channel = connection.createChannel()) {
                // Declare an exclusive queue (with a generated name)
                String queue = channel.queueDeclare().getQueue();

                // Declaração da exchange de vendas
                channel.exchangeDeclare(EXCHANGE_RESUME, BuiltinExchangeType.DIRECT, true);
                // Processamento da venda
                DeliverCallback deliverCallback = (consumerTag, delivery) -> {
                    String mensagem = new String(delivery.getBody(), "UTF-8");

                };

                channel.basicConsume(queue, true, deliverCallback, consumerTag -> {
                });

                System.out.println(" [*] Aguardando mensagens para categoria " + queueName + ". Para sair, pressione CTRL+C");

                // Mantenha a execução do worker...
                Thread.currentThread().join();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
