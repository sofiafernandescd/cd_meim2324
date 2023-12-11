package worker;

import com.rabbitmq.client.*;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Worker {
    private static final String EXCHANGE_NAME = "ExgSales";
    private static final String QUEUE_ALIMENTAR = "fila_alimentar";
    private static final String QUEUE_CASA = "fila_casa";
    private final int workerId;
    private final String queueName;

    String glusterFsPath;


    public Worker(String queueName, int workerId) {
        this.queueName = queueName;
        this.workerId = workerId;
        this.glusterFsPath = "/var/sharedfiles/worker_" + workerId + "_sales_data.txt";
    }

    public static void main(String[] args) {
        if (args.length != 4) {
            System.out.println("Uso: Worker <ipRabbitMQ> <portRabbitMQ> <categoria> <ID>");
            System.exit(1);
        }

        String ipRabbitMQ = args[0];
        int portRabbitMQ = Integer.parseInt(args[1]);
        int workerID= Integer.parseInt(args[2]);
        String categoria = args[3];
        Worker worker = new Worker(categoria, workerID);
        worker.iniciar(ipRabbitMQ, portRabbitMQ);
    }

    private void iniciar(String ipRabbitMQ, int portRabbit) {
        try {
            ConnectionFactory factory = new ConnectionFactory();
            factory.setHost(ipRabbitMQ);
            factory.setPort(portRabbit);

            try (Connection connection = factory.newConnection();
                 Channel channel = connection.createChannel()) {

                // Declaração da exchange de vendas
                channel.exchangeDeclare(EXCHANGE_NAME, BuiltinExchangeType.TOPIC, true);
                String queue = getQueueFromCategoria(queueName);
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
}
