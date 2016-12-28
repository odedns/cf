package test.rabbitmq;



import com.rabbitmq.client.*;

import java.io.IOException;

public class RecvTest {

  private final static String QUEUE_NAME = "hello";

  public static void main(String[] argv) throws Exception {
    String url = "amqp://cjkdizmi:yA1AUhMtGpmp9HHkp5e0o2OqikO3_0qk@zebra.rmq.cloudamqp.com/cjkdizmi";
	  ConnectionFactory factory = new ConnectionFactory();
	  factory.setUri(url);
	  Connection connection = factory.newConnection();
    
    
    
    Channel channel = connection.createChannel();

    channel.queueDeclare(QUEUE_NAME, false, false, false, null);
    System.out.println(" [*] Waiting for messages. To exit press CTRL+C");

    Consumer consumer = new DefaultConsumer(channel) {
      @Override
      public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body)
          throws IOException {
        String message = new String(body, "UTF-8");
        System.out.println(" [x] Received '" + message + "'");
      }
    };
    channel.basicConsume(QUEUE_NAME, true, consumer);
  }
}
