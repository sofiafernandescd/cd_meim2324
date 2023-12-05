package mqproducer;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import org.slf4j.Logger;
import org.slf4j.simple.SimpleLoggerFactory;

import java.util.Objects;
import java.util.Scanner;
import java.util.Date;
import java.util.UUID;

public class PointOfSale {

    private static final String EXCHANGE_NAME = "ExgSales";  // Nome do exchange global bem conhecido
    private static final String CASA_ROUTING_KEY = "CASA.#";
    private static final String ALIMENTAR_ROUTING_KEY = "ALIMENTAR.#";

    private static String BROKER_IP = "localhost";
    private static final int BROKER_PORT = 5672;

    static Logger logger = new SimpleLoggerFactory().getLogger("RabbitMQ-PointOfSale");

    public static void main(String[] args) {
        BROKER_IP = args[0];
        try {
            ConnectionFactory factory = new ConnectionFactory();
            factory.setHost(BROKER_IP);
            factory.setPort(BROKER_PORT);

            Connection connection = factory.newConnection();
            Channel channel = connection.createChannel();
            //channel.addReturnListener(new ReturnedMessage());

            // Gerar mensagens de venda
            for (int i = 0; i < 10; i++) {
                Date data = new Date();
                UUID uuid = UUID.randomUUID();
                String codigoProduto = uuid.toString().substring(0, 8);
                String categoria = readline("Product categoria (ALIMENTAR or CASA)?");
                String nomeProduto = readline("Product name?");
                int quantidade = Integer.parseInt(readline("Quantity?"));
                double precoUnitario = Double.parseDouble(readline("Unit price?"));
                double iva;
                if (Objects.equals(categoria, ALIMENTAR_ROUTING_KEY)) {
                   iva = 0.06;
                } else {
                    iva = 0.23;
                }
                double total = quantidade * (precoUnitario * (1+iva));


                // Construir a mensagem de venda
                String message = createSaleMessage(data, codigoProduto, categoria, nomeProduto, quantidade, precoUnitario, total, iva);

                // Enviar a mensagem para o RabbitMQ com base na categoria
                String routingKey = getCategoryRoutingKey(categoria);
                channel.basicPublish(EXCHANGE_NAME, routingKey, true, null, message.getBytes());
                System.out.println("Sale Message Sent: " + message);
            }

            readline("Press enter to finish");
            channel.close();
            connection.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private static String readline(String msg) {
        Scanner scaninput = new Scanner(System.in);
        System.out.println(msg);
        return scaninput.nextLine();
    }

    private static String createSaleMessage(Date data, String codigoProduto, String categoria, String nomeProduto, int quantidade, double precoUnitario, double total, double iva) {
        // Aqui, você pode formatar a mensagem de venda conforme necessário
        return String.format("Sale: data=%s, codigoProduto=%s, categoria=%s, nomeProduto=%s, quantidade=%d, precoUnitario=%.2f, total=%.2f, iva=%.2f",
                data, codigoProduto, categoria, nomeProduto, quantidade, precoUnitario, total, iva);
    }

    private static String getCategoryRoutingKey(String categoria) {
        // Determine a routing key com base na categoria do produto
        return categoria.equals("ALIMENTAR") ? ALIMENTAR_ROUTING_KEY : CASA_ROUTING_KEY;
    }
}
