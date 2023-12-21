package mqproducer;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import org.slf4j.Logger;
import org.slf4j.simple.SimpleLoggerFactory;

import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.Objects;
import java.util.Scanner;
import java.util.UUID;

public class PointOfSale {

    private static final String EXCHANGE_NAME = "ExgSales";  // Nome do exchange global bem conhecido
    private static final String CASA_ROUTING_KEY = "CASA.#";
    private static final String ALIMENTAR_ROUTING_KEY = "ALIMENTAR.#";
    private static final int BROKER_PORT = 5672;

    static Logger logger = new SimpleLoggerFactory().getLogger("RabbitMQ-PointOfSale");

    public static void main(String[] args) {
        String BROKER_IP = args[0];
        try {
            // Conexão ao RabbitMQ
            ConnectionFactory factory = new ConnectionFactory();
            factory.setHost(BROKER_IP); // from args
            factory.setPort(BROKER_PORT);

            Connection connection = factory.newConnection();
            Channel channel = connection.createChannel();

            for (int i = 0; i < 10; i++) {
                // Gerar mensagens de venda
                int nSales = Integer.parseInt(readline("Número de Sales?"));
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
                double total = quantidade * (precoUnitario * (1 + iva));

                // Enviar o número pedido de sales
                for (int j = 0; j < nSales; j++) {
                    // Manter datas e IDs diferentes em cada uma
                    Date data = new Date();
                    UUID uuid = UUID.randomUUID();
                    String codigoProduto = uuid.toString().substring(0, 8);
                    // Construir a mensagem de venda
                    byte[] message = createSaleMessage(data, codigoProduto, categoria, nomeProduto, quantidade, precoUnitario, total, iva);
                    // Enviar a mensagem para o RabbitMQ com base na categoria
                    String routingKey = getCategoryRoutingKey(categoria);
                    channel.basicPublish(EXCHANGE_NAME, routingKey, true, null, message);
                    System.out.println("Sale Message Sent: " + message.toString());
                }
            }

            //readline("Press enter to finish");
            //channel.close();
            //connection.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private static String readline(String msg) {
        Scanner scaninput = new Scanner(System.in);
        System.out.println(msg);
        return scaninput.nextLine();
    }

    private static byte[] createSaleMessage(Date data, String codigoProduto, String categoria, String nomeProduto, int quantidade, double precoUnitario, double total, double iva) {
        
        // ANTES:
        //return String.format("Sale: data=%s, codigoProduto=%s, categoria=%s, nomeProduto=%s, quantidade=%d, precoUnitario=%.2f, total=%.2f, iva=%.2f",
        //data, codigoProduto, categoria, nomeProduto, quantidade, precoUnitario, total, iva);

        // AGORA - converte para JSON e byte, para ser depois enviado na exchange (em vez da string):
        Sale sale = new Sale(data, codigoProduto, categoria, nomeProduto, quantidade, precoUnitario, total, iva);
        // converter objeto em string JSON
        Gson js = new GsonBuilder().create();
        String jsonString = js.toJson(sale);
        System.out.println(jsonString);
        // converter string em byte[]
        byte[] binData = jsonString.getBytes(StandardCharsets.UTF_8);
        for (byte b : binData) System.out.print(b + " ");
        System.out.println();

        return binData;
    }

    private static String getCategoryRoutingKey(String categoria) {
        // Determine a routing key com base na categoria do produto
        return categoria.equals("ALIMENTAR") ? ALIMENTAR_ROUTING_KEY : CASA_ROUTING_KEY;
    }
}
