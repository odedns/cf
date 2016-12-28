package cf.queue.config;

import java.net.URI;
import java.net.URISyntaxException;

import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("default")
public class DefConfig {
	  private final static String QUEUE_NAME = "hello";

	
	@Bean
    public ConnectionFactory connectionFactory() {
        String url = "amqp://cjkdizmi:yA1AUhMtGpmp9HHkp5e0o2OqikO3_0qk@zebra.rmq.cloudamqp.com/cjkdizmi";
        CachingConnectionFactory factory = null;
        try {
			factory = new CachingConnectionFactory(new URI(url));
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return(factory);
    }

    @Bean
    public AmqpAdmin amqpAdmin() {
        return new RabbitAdmin(connectionFactory());
    }

    @Bean
    public RabbitTemplate rabbitTemplate() {
    	RabbitTemplate template = new RabbitTemplate(connectionFactory());
    	template.setQueue(QUEUE_NAME);
    	template.setRoutingKey(QUEUE_NAME);
        return(template);
    }

    @Bean
    public Queue myQueue() {
    	Queue queue = new Queue(QUEUE_NAME,false);
       return (queue);
    }
   
}
