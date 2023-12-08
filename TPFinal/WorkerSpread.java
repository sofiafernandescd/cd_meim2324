package worker;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DeliverCallback;

import java.net.InetAddress;

public class WorkerSpread {
    private static final String QUEUE_ALIMENTAR = "fila_alimentar";
    private static final String QUEUE_CASA = "fila_casa";
    // ... outras constantes e configurações ...

    private final String queueName;
    private final SpreadConnection spreadConnection;
    private final SpreadGroup spreadGroup;

    public WorkerSpread(String queueName, String spreadGroupName) {
        this.queueName = queueName;
        this.spreadConnection = new SpreadConnection();
        this.spreadGroup = new SpreadGroup();
        this.spreadGroup.join(spreadConnection, spreadGroupName);
    }

    public static void main(String[] args) {
        if (args.length != 3) {
            System.out.println("Uso: Worker <ipRabbitMQ> <portRabbitMQ> <categoria>");
            System.exit(1);
        }

        String ipRabbitMQ = args[0];
        int portRabbitMQ = Integer.parseInt(args[1]);
        String categoria = args[2];
        String spreadGroupName = "SpreadGroup" + categoria;
        WorkerSpread worker = new WorkerSpread(categoria, spreadGroupName);
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

    // Inicia a conexão Spread Toolkit
    private void iniciarSpreadConnection(String ipRabbitMQ, int portRabbit) {
        try {
            spreadConnection.connect(InetAddress.getByName(ipRabbitMQ), portRabbit, "worker", false, true);

            SpreadMessage spreadMessage = new SpreadMessage();
            spreadMessage.addGroup(spreadGroup);
            spreadConnection.multicast(spreadMessage);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void processarVenda(String mensagem) {
        System.out.println(" [x] Recebida venda da categoria " + queueName + ": " + mensagem);
        // Lógica de processamento específica para a categoria
        // Adicionar ao TXT TODO
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

    private void fazerResumo(String categoria) {
        System.out.println(" [x] Resumo da categoria " + categoria);
        // Lógica de processamento específica para a categoria
    }

    // Método para solicitar arquivos de uma categoria específica
    private void requestCategoryFiles(String categoria) {
        try {
            // Envia mensagem de solicitação ao grupo específico da categoria usando Spread Toolkit
            spreadConnection.multicast(spreadGroup, SpreadMessage.PRIORITY_NORMAL,
                    false, new MessagePayload("REQUEST_FILES " + categoria));
        } catch (SpreadException e) {
            e.printStackTrace();
        }
    }

    // Adiciona lógica para eleição Bully usando Spread Toolkit
    private void startElection() {
        try {
            // Envia mensagem de eleição ao grupo específico da categoria usando Spread Toolkit
            spreadConnection.multicast(spreadGroup, SpreadMessage.PRIORITY_NORMAL,
                    false, new MessagePayload("ELECTION " + queueName));
        } catch (SpreadException e) {
            e.printStackTrace();
        }
    }

}
