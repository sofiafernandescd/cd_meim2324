package broker;

import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import org.slf4j.Logger;
import org.slf4j.simple.SimpleLoggerFactory;

import java.util.Scanner;

public class Broker {

    private static String BROKER_IP = "localhost";
    private static int BROKER_PORT = 5672;

    static Connection connection = null;
    static Channel channel = null;
    static Logger logger=new SimpleLoggerFactory().getLogger("RabbitMQ-configurator");

    public static void main(String[] args) {
        BROKER_IP = args[0];
        BROKER_PORT = Integer.parseInt(args[1]);
        try {
            ConnectionFactory factory = new ConnectionFactory();
            factory.setHost(BROKER_IP);
            factory.setPort(BROKER_PORT);

            connection = factory.newConnection();
            channel = connection.createChannel();

            channel.exchangeDeclare("ExgSales", BuiltinExchangeType.TOPIC, true);

            channel.queueDeclare("fila_alimentar", true, false, false, null);
            channel.queueBind("fila_alimentar", "ExgSales", "ALIMENTAR.#");

            channel.queueDeclare("fila_casa", true, false, false, null);
            channel.queueBind("fila_casa", "ExgSales", "CASA.#");

            boolean end = false;
            while (!end)
            {
                int option;
                Scanner scan = new Scanner(System.in);
                option = scan.nextInt();
                if(option == 99){
                    end = true;
                }
            }

            channel.close();
            connection.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}