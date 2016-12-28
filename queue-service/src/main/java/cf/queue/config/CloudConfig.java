package cf.queue.config;

import java.net.URI;
import java.net.URISyntaxException;

import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.cloud.config.java.AbstractCloudConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("cloud")
public class CloudConfig extends AbstractCloudConfig {

	private final static String QUEUE_NAME = "hello";

	

    @Bean
    public AmqpAdmin amqpAdmin() {
        return new RabbitAdmin(connectionFactory().rabbitConnectionFactory());
    }

    @Bean
    public RabbitTemplate rabbitTemplate() {
    	RabbitTemplate template = new RabbitTemplate(connectionFactory().rabbitConnectionFactory());
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
