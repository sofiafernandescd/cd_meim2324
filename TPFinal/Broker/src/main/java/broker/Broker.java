package broker;

public class Broker {

    private static String BROKER_IP = "localhost";
    private static final int BROKER_PORT = 5672;

    public static void main(String[] args) {
        BROKER_IP = args[0];
        BROKER_PORT = args[1];
    }
}