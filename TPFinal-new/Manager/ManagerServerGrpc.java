package manager;

import com.google.protobuf.ByteString;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;
import manageruserstubs.Category;
import manageruserstubs.ContractManagerUserGrpc;
import manageruserstubs.Resume;
import org.slf4j.Logger;
import spread.SpreadConnection;
import spread.SpreadException;
import spread.SpreadGroup;
import spread.SpreadMessage;


public class ManagerServiceImpl extends ContractManagerUserGrpc.ContractManagerUserImplBase {
    public final String ipInterno;
    public final SpreadConnection spreadConnection;
    public final SpreadGroup spreadGroup;

    private static String BROKER_IP = "localhost";
    private static final int BROKER_PORT = 5672;

    static Logger logger = new SimpleLoggerFactory().getLogger("RabbitMQ-Manager");

    public ManagerServerGrpc(String ipInterno, SpreadConnection spreadConnection, SpreadGroup spreadGroup) throws Exception {
        this.ipInterno = ipInterno;
        this.spreadConnection = spreadConnection;
        this.spreadGroup = spreadGroup;
        initializeGRPC();
        initializeSpread(spreadGroup);
        //spreadConnection.connect(InetAddress.getByName(ipInterno), 4803, "Manager", false, true);
    }

    private void initializeGRPC() {
        // Configuração e inicialização do serviço gRPC
        Server server = ServerBuilder.forPort(8080)
                .addService(new Contrac())
                .build();

        try {
            server.start();
            System.out.println("gRPC Server started on port 8080");
            server.awaitTermination();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void initializeSpread(SpreadGroup spreadGroup) {
        // Configuração e inicialização da conexão Spread
        try {
            spreadConnection = new SpreadConnection();
            spreadConnection.connect(null, 0, "user", false, true);

            // Cria um grupo Spread (pode representar um canal)
            spreadGroup = new SpreadGroup();
            spreadGroup.join(spreadConnection, spreadGroup);

        } catch (SpreadException e) {
            e.printStackTrace();
        }
    }

    private void initializeRabbitMQ() {
        // Configuração e inicialização do serviço RabbitMQ sem consumir mensagens
        try {
            ConnectionFactory factory = new ConnectionFactory();
            factory.setHost(BROKER_IP);
            factory.setPort(BROKER_PORT);

            Connection connection = factory.newConnection();
            Channel channel = connection.createChannel();

            // Cria uma exchange do tipo topic
            channel.exchangeDeclare(EXCHANGE_NAME, BuiltinExchangeType.TOPIC);

            // Cria uma fila temporária e exclusiva para este consumidor
            String queueName = channel.queueDeclare().getQueue();

            // Faz o binding da fila com a exchange
            channel.queueBind(queueName, EXCHANGE_NAME, "#");

            // Cria um consumidor para a fila
            Consumer consumer = new DefaultConsumer(channel) {
                @Override
                public void handleDelivery(String consumerTag, Envelope envelope,
                                           AMQP.BasicProperties properties, byte[] body)
                        throws IOException {

                    String message = new String(body, "UTF-8");
                    System.out.println("Received: " + message);
                }
            };

            // Registra o consumidor na fila
            channel.basicConsume(queueName, true, consumer);

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        

        
    }


    public static void main(String[] args) throws Exception {
        String ipInterno = args[0];
        SpreadConnection spreadConnection1 = new SpreadConnection();
        SpreadGroup spreadGroup = new SpreadGroup();
        Server server = ServerBuilder.forPort(9090)
                .addService(new ManagerServerGrpc(ipInterno, spreadConnection1, spreadGroup))
                .build();

        System.out.println("Iniciando servidor gRPC na porta 9090");
        server.start();
        server.awaitTermination();
    }

    @Override
    public void getResume(Category request, StreamObserver<Resume> responseObserver) {
        try {
            spreadGroup.join(spreadConnection, "SpreadGroup" + request.getCategory());
        } catch (Exception e) {
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
        spreadMessage.setData(("RESUME_REQUEST " + categoria + " summary.txt").getBytes());
        try {
            spreadConnection.multicast(spreadMessage);
            spreadGroup.leave();
        } catch (SpreadException e) {
            e.printStackTrace();
        }
    }
}
