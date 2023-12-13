package worker;

import com.rabbitmq.client.*;
import spread.*;

import java.io.*;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class WorkerSpread {

    private static final String EXCHANGE_NAME = "ExgSales";
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


    public WorkerSpread(String queueName, int workerId, String spreadGroupName, String ipRabbitMQ, int portRabbitMQ, String ipInterno) throws SpreadException, UnknownHostException {
        this.queueName = queueName;
        this.workerId = workerId;
        this.SpreadGroupName = spreadGroupName;
        this.glusterFsPath = "/var/sharedfiles/worker_" + workerId + "_" + queueName + "_sales_data.txt";
        this.spreadConnection = new SpreadConnection();
        this.spreadGroup = new SpreadGroup();
        spreadConnection.connect(InetAddress.getByName(ipInterno), 4803, Integer.toString(workerId), false, true);
        this.spreadGroup.join(spreadConnection, spreadGroupName);
        iniciarSpreadConnection("Worker_id_" + workerId, ipRabbitMQ, portRabbitMQ);
    }

    public static void main(String[] args) throws SpreadException, UnknownHostException {
        if (args.length != 5) {
            System.out.println("Uso: Worker <ipRabbitMQ> <portRabbitMQ> <workerId> <categoria> <IPinternoVM>");
            System.exit(1);
        }

        String ipRabbitMQ = args[0];
        int portRabbitMQ = Integer.parseInt(args[1]);
        int workerID = Integer.parseInt(args[2]);
        String categoria = args[3];
        String ipInterno = args[4];
        String spreadGroupName = "SpreadGroup" + categoria;
        WorkerSpread worker = new WorkerSpread(categoria, workerID, spreadGroupName, ipRabbitMQ, portRabbitMQ, ipInterno);
        worker.iniciar(ipRabbitMQ, portRabbitMQ);
    }

    private void iniciarSpreadConnection(String user, String address, int port) {
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


    private void processarResumo(String exchangeName, String summaryFileName) {
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
        mergeFiles("/var/sharedfiles/", "/var/sharedfiles/RESUMO_" + queueName + ".txt", queueName);
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
    }

    // Adicione este método para processar mensagens de eleição
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

    private void iniciar(String ipRabbitMQ, int portRabbitMQ) {
        try {
            ConnectionFactory factory = new ConnectionFactory();
            factory.setHost(ipRabbitMQ);
            factory.setPort(portRabbitMQ);

            try (Connection connection = factory.newConnection();
                 Channel channel = connection.createChannel()) {
                String queue = getQueueFromCategoria(queueName);

                // Declaração da exchange de vendas
                channel.exchangeDeclare(EXCHANGE_NAME, BuiltinExchangeType.TOPIC, true);
                // Processamento da venda
                DeliverCallback deliverCallback = (consumerTag, delivery) -> {
                    String mensagem = new String(delivery.getBody(), "UTF-8");
                    processarVenda(mensagem);
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
            System.out.println(" [x] Venda registada no ficheiro: " + glusterFsPath);
        } catch (IOException e) {
            e.printStackTrace();
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
