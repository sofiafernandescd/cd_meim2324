package manager;

import com.google.protobuf.ByteString;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DeliverCallback;
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

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.concurrent.TimeoutException;


public class Manager extends ContractManagerUserGrpc.ContractManagerUserImplBase {

    public final String ipInterno;
    private static final int BROKER_PORT = 5672;
    private static final String resumeQueue = "fila_resumo";

    //static Logger logger = new SimpleLoggerFactory().getLogger("RabbitMQ-Manager");

    public Manager(String ipInterno, String ipRabbitMQ) {
        this.ipInterno = ipInterno;
        initializeRabbitMQ(ipRabbitMQ);
    }

    public static void main(String[] args) throws Exception {
        String ipRabbitMQ = args[0];
        String ipInterno = args[1];
        Manager manager = new Manager(ipInterno, ipRabbitMQ);
        // Configuração e inicialização do serviço gRPC
        Server server = ServerBuilder.forPort(8080)
                .addService(manager)
                .build();

        try {
            server.start();
            System.out.println("gRPC Server started on port 8080");
            server.awaitTermination();


            //server.shutdown();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private void initializeRabbitMQ(String ipRabbitMQ) {
        try {
            ConnectionFactory factory = new ConnectionFactory();
            factory.setHost(ipRabbitMQ);
            factory.setPort(BROKER_PORT);

            try (Connection connection = factory.newConnection();
                 Channel channel = connection.createChannel()) {

                // Consumer handler to receive messages
                DeliverCallback deliverCallback = (consumerTag, delivery) -> {
                    String recMessage = new String(delivery.getBody(), "UTF-8");
                    System.out.println("Message Received:" +consumerTag+":"+recMessage);
                };
                channel.basicConsume("fila_resumo", true, deliverCallback, consumerTag -> {
                });
            }

        } catch (IOException | TimeoutException e) {
            e.printStackTrace();
        }
    }

    private void sendMulticastSpread(String category) {
        // Lógica para enviar mensagens multicast usando Spread
        try {
            SpreadConnection spreadConnection = new SpreadConnection();
            spreadConnection.connect(InetAddress.getByName(ipInterno), 4803, "manager", false, true);
            // Junta-se ao grupo da categoria do resumo

            SpreadGroup spreadGroup = new SpreadGroup();
            spreadGroup.join(spreadConnection, "SpreadGroup"+category);
            // Criar SpreadMessage
            SpreadMessage spreadMessage = new SpreadMessage();
            spreadMessage.setSafe();
            String message = "Pedido de resumo";
            spreadMessage.setData(message.getBytes());
            spreadConnection.multicast(spreadMessage);
            spreadGroup.leave();
            spreadConnection.disconnect();

        } catch (SpreadException | UnknownHostException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void getResume(Category request, StreamObserver<Resume> responseObserver) {
        // Mensagem multicast para os workers da categoria
        String category = request.getCategory();
        sendMulticastSpread(category);

        // Recebe notificação RabbitMQ com o nome do ficheiro
        String fileName = "asdf.txt";


        // Aqui você geraria o resumo com base no UserRequest
        String summaryText = "Este é um resumo para a categoria " + request.getCategory();
        byte[] resumeByte = summaryText.getBytes();

        // Envie o resumo de volta para o usuário
        Resume response = Resume.newBuilder()
                .setCategory(request.getCategory())
                .setData(ByteString.copyFrom(resumeByte))
                .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }



}
