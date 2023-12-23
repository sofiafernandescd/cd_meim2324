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
import java.io.InputStream;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.TimeoutException;

import static com.google.protobuf.ByteString.copyFrom;


public class Manager extends ContractManagerUserGrpc.ContractManagerUserImplBase {

    public final String ipInterno;
    private static final int BROKER_PORT = 5672;

    private Channel channel;

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

            Connection connection = factory.newConnection();
            channel = connection.createChannel();

            // Consumer handler to receive messages
            DeliverCallback deliverCallback = (consumerTag, delivery) -> {
                String recMessage = new String(delivery.getBody(), "UTF-8");
                System.out.println("Message Received:" + consumerTag + ":" + recMessage);
            };
            channel.basicConsume("fila_resumo", true, deliverCallback, consumerTag -> {
            });


        } catch (IOException | TimeoutException e) {
            e.printStackTrace();
        }
    }

    private void sendMulticastSpread(String category) {
        //Enviar mensagens multicast usando Spread
        try {
            SpreadConnection spreadConnection = new SpreadConnection();
            spreadConnection.connect(InetAddress.getByName(ipInterno), 4803, "manager", false, true);
            //O manager Server junta-se ao grupo da categoria do resumo
            SpreadGroup spreadGroup = new SpreadGroup();
            spreadGroup.join(spreadConnection, "SpreadGroup" + category);
            //Criar SpreadMessage
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
        //Envio de mensagem multicast para os workers da categoria
        String category = request.getCategory();
        sendMulticastSpread(category);

        try {
            String exchName = "ExgResumeOf-" + request.getUserID();
            ReceiverNotification recMsg = new ReceiverNotification(channel, exchName);

            String fileResume = recMsg.waitNotification();

            // envio do ficheiro do Gluster para o cliente
            Path downloadFrom = Paths.get(fileResume);
            byte[] buffer = new byte[2 * 1024];  // blocos de 2kbyte
            try (InputStream input = Files.newInputStream(downloadFrom)) {
                while (input.read(buffer) >= 0) {
                    Resume resumeBlock = Resume.newBuilder()
                            .setData(copyFrom(buffer)).build();
                    responseObserver.onNext(resumeBlock);
                }
                responseObserver.onCompleted();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

/*        //Receber notificação RabbitMQ com o nome do ficheiro
        String fileName = "asdf.txt";

        //Criar o resumo com base no pedido do User
        String summaryText = "Este é um resumo para a categoria " + request.getCategory();
        byte[] resumeByte = summaryText.getBytes();

        //Enviar o resumo de volta para o User
        Resume response = Resume.newBuilder()
                .setCategory(request.getCategory())
                .setData(copyFrom(resumeByte))
                .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();*/
    }
}
