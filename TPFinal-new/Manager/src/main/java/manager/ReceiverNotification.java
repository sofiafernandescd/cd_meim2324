package manager;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.concurrent.Semaphore;

public class ReceiverNotification implements DeliverCallback, CancelCallback {
    Channel channel;
    String exchName;
    String queueName;

    String fileResume;
    Semaphore sync;

    public ReceiverNotification(Channel channel, String exchName) throws Exception {
        this.channel=channel; this.exchName=exchName; this.queueName=exchName+"-queue";

        /* channel.exchangeDeclare(exchName, BuiltinExchangeType.FANOUT, true);
        System.out.println("Exchange " + exchName);
        channel.queueDeclare(queueName, true, false, false, null);
        System.out.println("Queue " + queueName);
        channel.queueBind(queueName, exchName,""); */

        sync=new Semaphore(0);  // semáforo com valor inicial 0
    }

    @Override
    public void handle(String consumerTag, Delivery delivery) throws IOException {
        fileResume = new String(delivery.getBody(), "UTF-8");
        long deliverTag=delivery.getEnvelope().getDeliveryTag();
        channel.basicAck(deliverTag,false);
        sync.release(); // coloca semáforo a 1
    }

    public String waitNotification() throws Exception {
        channel.basicConsume("fila_resumo", false, this, this);
        System.out.println("registou consumer");
        sync.acquire();  // Thread bloqueada por semáforo estar a 0 até receber sync.release no handle
        return fileResume;
    }

    @Override
    public void handle(String consumerTag) throws IOException {
        System.out.println("CANCEL Received! "+consumerTag);
    }
}
