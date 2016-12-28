package test.rabbitmq;


import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class SendTest {

  private final static String QUEUE_NAME = "hello";

  public static void main(String[] argv) throws Exception {

	  /*
	ConnectionFactory factory = new ConnectionFactory();
    factory.setHost("localhost");
    Connection connection = factory.newConnection();
    */
	  String url = "amqp://cjkdizmi:yA1AUhMtGpmp9HHkp5e0o2OqikO3_0qk@zebra.rmq.cloudamqp.com/cjkdizmi";
	  ConnectionFactory factory = new ConnectionFactory();
	  factory.setUri(url);
	  Connection conn = factory.newConnection();


    
    
    
    Channel channel = conn.createChannel();

    channel.queueDeclare(QUEUE_NAME, false, false, false, null);
    String message = "Hello World!";
    channel.basicPublish("", QUEUE_NAME, null, message.getBytes("UTF-8"));
    System.out.println(" [x] Sent '" + message + "'");

    channel.close();
    conn.close();
  }
}