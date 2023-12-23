package worker;

import com.rabbitmq.client.*;
import spread.SpreadConnection;
import spread.SpreadException;
import spread.SpreadGroup;
import spread.SpreadMessage;

import java.io.*;
import java.net.InetAddress;
import java.util.concurrent.TimeoutException;

public class WorkerSpread {

    private static final String EXCHANGE_NAME = "ExgSales";
    private static final String EXCHANGE_RESUME = "ExgResume";
    private static final String QUEUE_ALIMENTAR = "fila_alimentar";
    private static final String QUEUE_CASA = "fila_casa";

    private final int workerId;
    private final String queueName;
    String glusterFsPath;
    private final SpreadConnection spreadConnection;
    private final SpreadGroup spreadGroup;
    // Adicione estas variáveis para controlar o estado da eleição
    private boolean electionInProgress = false;
    private boolean electedLeader = false;
    private String leaderSpreadGroupName = "";
    private String SpreadGroupName = "";
    private boolean free = true;

    private String ipRabbitMQ = "localhost";

    private ConnectionFactory factory;

    private Connection connection;

    private Channel channel;

    public WorkerSpread(String queueName, int workerId, String spreadGroupName, String ipRabbitMQ, String ipInterno) throws SpreadException, IOException, TimeoutException {
        this.queueName = queueName;
        this.workerId = workerId;
        // Conexão ao RabbitMQ (sem definição de exchanges)
        this.ipRabbitMQ = ipRabbitMQ;
        iniciarRabbitMQ(ipRabbitMQ);
        // Path to file in GlusterFS
        this.glusterFsPath = "/var/sharedfiles/worker_" + workerId + "_" + queueName + "_sales_data.txt";
        // Spread connection to the right group
        this.SpreadGroupName = spreadGroupName;
        this.spreadConnection = new SpreadConnection();
        this.spreadGroup = new SpreadGroup();
        spreadConnection.connect(InetAddress.getByName(ipInterno), 4803, Integer.toString(workerId), false, true);
        this.spreadGroup.join(spreadConnection, spreadGroupName);
        iniciarSpreadConnection();

    }

    public static void main(String[] args) throws SpreadException, IOException, TimeoutException {
        if (args.length != 4) {
            System.out.println("Uso: Worker <ipRabbitMQ> <workerId> <categoria> <IPinternoVM>");
            System.exit(1);
        }

        String ipRabbitMQ = args[0];
        int workerID = Integer.parseInt(args[1]);
        String categoria = args[2];
        String ipInterno = args[3];
        String spreadGroupName = "SpreadGroup" + categoria;
        WorkerSpread worker = new WorkerSpread(categoria, workerID, spreadGroupName, ipRabbitMQ, ipInterno);
        worker.iniciarExchanges(ipRabbitMQ);
    }

    private void iniciarRabbitMQ(String ipRabbitMQ) throws IOException, TimeoutException {
        factory = new ConnectionFactory();
        factory.setHost(ipRabbitMQ); factory.setPort(5672);
        connection = factory.newConnection();
        channel = connection.createChannel();
    }

    private void iniciarSpreadConnection() {
        // Establish the spread connection.
        try {
            SpreadMessage spreadMessage = new SpreadMessage();
            spreadMessage.setSafe();
            spreadMessage.addGroup(spreadGroup);
            System.out.println("Conexão de Spread iniciada");
            String txtMessage = "Connection Started";
            spreadMessage.setData(txtMessage.getBytes());
            spreadConnection.multicast(spreadMessage);

            // Listen for Spread messages
            new Thread(() -> {
                while (true) {
                    try {
                        SpreadMessage receivedMessage = spreadConnection.receive();
                        byte[] data = receivedMessage.getData();
                        String receivedText = new String(data);
                        System.out.println("Received Spread message: " + receivedText);

                        // Verifica se a mensagem é uma solicitação de resumo
                        if (receivedText.startsWith("RESUME_REQUEST")) {
                            // Extrai o nome do Exchange e do arquivo do qual o resumo deve ser enviado
                            String[] parts = receivedText.split("\\s");
                            if (parts.length == 3) {
                                String exchangeName = parts[1];
                                String summaryFileName = parts[2];
                                // Processa o resumo
                                processarResumo(exchangeName, summaryFileName);
                            }
                        }
                    } catch (SpreadException | IOException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        } catch (SpreadException e) {
            throw new RuntimeException(e);
        }
    }

    private void iniciarExchanges(String ipRabbitMQ) {
        try {

/*          ConnectionFactory factory = new ConnectionFactory();
            factory.setHost(ipRabbitMQ);
            factory.setPort(5672);*/

            try (Connection connection = factory.newConnection();
                Channel channel = connection.createChannel()) {
                String queue = getQueueFromCategoria(queueName);

                // Processamento da venda
                DeliverCallback deliverCallback = (consumerTag, delivery) -> {
                    String mensagem = new String(delivery.getBody(), "UTF-8");
                    long deliverTag=delivery.getEnvelope().getDeliveryTag();
                    // se não estiver ocupado com resumo
                    if (free){
                        channel.basicAck(deliverTag,false);
                        processarVenda(mensagem);

                    } else {
                        channel.basicNack(deliverTag, false, true);
                    }

                };

                System.out.println("Hello cheguei aqui");
                channel.basicConsume(queue, true, deliverCallback, consumerTag -> {
                });

                System.out.println(" [*] Aguardando mensagens para categoria " + queueName + ". Para sair, pressione CTRL+C");

                // Manter a execução do worker...
                Thread.currentThread().join();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private String getQueueFromCategoria(String categoria) {
        if ("ALIMENTAR".equalsIgnoreCase(categoria)) {
            return QUEUE_ALIMENTAR;
        } else if ("CASA".equalsIgnoreCase(categoria)) {
            return QUEUE_CASA;
        } else {
            System.out.println("Categoria desconhecida: " + categoria);
            System.exit(1);
            return null;
        }
    }

    private void escreverEmArquivo(String mensagem) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(glusterFsPath, true))) {
            writer.println(mensagem);
            System.out.println(mensagem);
            System.out.println(" [x] Venda registada no ficheiro: " + glusterFsPath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void publishToResumeExchange(String message, String ipRabbitMQ) {
        try {
            ConnectionFactory factory = new ConnectionFactory();
            factory.setHost(ipRabbitMQ);
            factory.setPort(5672);

            try (Connection connection = factory.newConnection();
                 Channel channel = connection.createChannel()) {
                // Publica a mensagem na exchange
                channel.basicPublish(EXCHANGE_RESUME, "", null, message.getBytes());
            }
        } catch (IOException | TimeoutException e) {
            e.printStackTrace();
        }
    }


    private void processarResumo(String exchangeName, String summaryFileName) {
        free = false;
        // Inicia o processo de eleição
        electionInProgress = true;

        // Envia mensagem de eleição para o grupo
        SpreadMessage electionMessage = new SpreadMessage();
        electionMessage.addGroup(spreadGroup);
        electionMessage.setData(("ELECTION_REQUEST " + workerId).getBytes());
        try {
            spreadConnection.multicast(electionMessage);
        } catch (SpreadException e) {
            e.printStackTrace();
        }

        // Após ser eleito líder, realiza o processamento do resumo
        // Lógica para processar o resumo das vendas e escrever no arquivo
        // Notifica o Manager que o resumo está pronto
        SpreadMessage spreadMessage = new SpreadMessage();
        spreadMessage.addGroup(spreadGroup);

        String fileName = "/var/sharedfiles/RESUMO_" + queueName + ".txt";
        mergeFiles("/var/sharedfiles/", fileName, queueName);
        spreadMessage.setData(("RESUME_COMPLETED " + exchangeName + " " + summaryFileName).getBytes());
        try {
            spreadConnection.multicast(spreadMessage);
        } catch (SpreadException e) {
            e.printStackTrace();
        }

        // Reinicia o processamento de mensagens
        electionInProgress = false;
        electedLeader = false;

        // Restaura o grupo Spread original
        try {
            spreadGroup.leave();
            spreadGroup.join(spreadConnection, SpreadGroupName);
        } catch (SpreadException e) {
            e.printStackTrace();
        }
        // Enviar notificação com o nome do ficheiro
        publishToResumeExchange(fileName, ipRabbitMQ);

        // Voltar a ficar disponivel
        free = true;
    }

    private void processarEleicao(String mensagem) throws InterruptedException {
        String[] parts = mensagem.split("\\s");
        if (parts.length == 2) {
            int candidatoId = Integer.parseInt(parts[1]);
            if (candidatoId < workerId) {
                // Se há um candidato com ID menor, renuncia à liderança
                electedLeader = false;
            } else if (candidatoId > workerId) {
                // Se há um candidato com ID maior, torna-se líder
                electedLeader = true;
                leaderSpreadGroupName = spreadGroup.toString();
            }
            // Se o ID for igual, mantém a liderança
            // Se houver empate, o Worker com o ID mais alto vence
        }
        // Libera o CountDownLatch quando a eleição for processada
        Thread.sleep(10000);
    }

    // Modifique o método processarVenda para verificar se está em andamento uma eleição
    private void processarVenda(String mensagem) {
        if (electionInProgress) {
            System.out.println(" [x] Eleição em andamento. Venda não processada: " + mensagem);
        } else {
            System.out.println(" [x] Recebida venda da categoria " + queueName + ": " + mensagem);
            escreverEmArquivo(mensagem);
        }
    }

    // Adicione este método para tratar a mensagem de eleição
    private void tratarMensagem(String receivedText) throws InterruptedException {
        if (receivedText.startsWith("ELECTION_REQUEST")) {
            processarEleicao(receivedText);
        }
    }




    // Juntar os arquivos num
    public static void mergeFiles(String directoryPath, String outputFileName, String queueName) {
        try {
            File directory = new File(directoryPath);
            File[] files = directory.listFiles();
            System.out.println(files);

            if (files != null) {
                try (PrintWriter writer = new PrintWriter(new FileWriter(outputFileName))) {
                    for (File file : files) {
                        if (file.isFile() && file.getName().contains(queueName)) {
                            System.out.println("Processing file: " + file.getName());
                            appendFileContents(file, writer);
                        }
                    }
                }

                System.out.println("Merge completed. Merged content saved to: " + outputFileName);
            } else {
                System.out.println("Invalid directory path.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void appendFileContents(File file, PrintWriter writer) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                writer.println(line);
            }
        }
    }
}
