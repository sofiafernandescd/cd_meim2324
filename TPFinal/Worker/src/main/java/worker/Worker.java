package worker;

import com.rabbitmq.client.*;

public class Worker {
    private static final String QUEUE_ALIMENTAR = "fila_alimentar";
    private static final String QUEUE_CASA = "fila_casa";
    // ... outras constantes e configurações ...

    private final String queueName;

    public Worker(String queueName) {
        this.queueName = queueName;
    }

    public static void main(String[] args) {
        if (args.length != 3) {
            System.out.println("Uso: Worker <categoria>");
            System.exit(1);
        }

        String ipRabbitMQ = args[0];
        int portRabbitMQ = Integer.parseInt(args[1]);
        String categoria = args[2];
        Worker worker = new Worker(categoria);
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

    private void processarVenda(String mensagem) {
        System.out.println(" [x] Recebida venda da categoria " + queueName + ": " + mensagem);
        // Lógica de processamento específica para a categoria
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
}
