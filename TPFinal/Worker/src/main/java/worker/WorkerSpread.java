package worker;

import com.rabbitmq.client.*;
import spread.*;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
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

    public WorkerSpread(String queueName, int workerId, String spreadGroupName, String ipRabbitMQ, int portRabbitMQ, String ipInterno) throws SpreadException, UnknownHostException {
        this.queueName = queueName;
        this.workerId = workerId;
        this.glusterFsPath = "/var/sharedfiles/worker_" + workerId + "_sales_data.txt";
        this.spreadConnection = new SpreadConnection();
        this.spreadGroup = new SpreadGroup();
        spreadConnection.connect(InetAddress.getByName(ipInterno), 4803, "Worker_id_" + workerId, false, true);
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
        int workerID= Integer.parseInt(args[2]);
        String categoria = args[3];
        String ipInterno = args[4];
        String spreadGroupName = "SpreadGroup" + categoria;
        WorkerSpread worker = new WorkerSpread(categoria, workerID, spreadGroupName, ipRabbitMQ, portRabbitMQ, ipInterno);
        worker.iniciar(ipRabbitMQ, portRabbitMQ);
    }

    private void iniciar(String ipRabbitMQ, int portRabbit) {
        try {
            ConnectionFactory factory = new ConnectionFactory();
            factory.setHost(ipRabbitMQ);
            factory.setPort(portRabbit);

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


    public void iniciarSpreadConnection(String user, String address, int port) {
        // Establish the spread connection.
        try {
            SpreadMessage spreadMessage = new SpreadMessage();
            spreadMessage.setSafe();
            spreadMessage.addGroup(spreadGroup);
            System.out.println("Conexão de Spread iniciada");
            String txtMessage = "Connection Started";
            spreadMessage.setData(txtMessage.getBytes());
            spreadConnection.multicast(spreadMessage);

            //advancedMsgHandling=new AdvancedMessageHandling(connection); connection.add(advancedMsgHandling);
        }
        catch(SpreadException e)  {
            System.err.println("There was an error connecting to the daemon.");
            e.printStackTrace();
            System.exit(1);
        }
    }

    // Inicia a conexão Spread Toolkit
//    private void iniciarSpreadConnection(String ipRabbitMQ, int portRabbit) {
//        try {
//            spreadConnection.connect(InetAddress.getByName(ipRabbitMQ), portRabbit, "worker", false, true);
//
//            SpreadMessage spreadMessage = new SpreadMessage();
//            spreadMessage.addGroup(spreadGroup);
//            spreadConnection.multicast(spreadMessage);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }

    private void processarVenda(String mensagem) {
        System.out.println(" [x] Recebida venda da categoria " + queueName + ": " + mensagem);
        escreverEmArquivo(mensagem);
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

    private void fazerResumo(String categoria) {
        System.out.println(" [x] Resumo da categoria " + categoria);
        // Lógica de processamento específica para a categoria
    }

//    // Método para solicitar arquivos de uma categoria específica
//    private void requestCategoryFiles(String categoria) {
//        try {
//            // Envia mensagem de solicitação ao grupo específico da categoria usando Spread Toolkit
//            spreadConnection.multicast(spreadGroup, SpreadMessage.PRIORITY_NORMAL,
//                    false, new MessagePayload("REQUEST_FILES " + categoria));
//        } catch (SpreadException e) {
//            e.printStackTrace();
//        }
//    }
//
//    // Adiciona lógica para eleição Bully usando Spread Toolkit
//    private void startElection() {
//        try {
//            // Envia mensagem de eleição ao grupo específico da categoria usando Spread Toolkit
//            spreadConnection.multicast(spreadGroup, SpreadMessage.PRIORITY_NORMAL,
//                    false, new MessagePayload("ELECTION " + queueName));
//        } catch (SpreadException e) {
//            e.printStackTrace();
//        }
//    }

}
