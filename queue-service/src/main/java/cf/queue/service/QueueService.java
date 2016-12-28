package cf.queue.service;

<<<<<<< HEAD
import java.util.LinkedList;

=======
>>>>>>> 26f136161129c61361d06df372319169c49b029c
import org.apache.log4j.Logger;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/queue")
public class QueueService {
	private final static Logger log = Logger.getLogger(QueueService.class);
    @Autowired AmqpTemplate amqpTemplate;

	@RequestMapping(value="/put", method=RequestMethod.POST)
	public void sendMessage(@RequestBody String msg)
	{
		log.debug("in sendMessage() msg =" + msg);
		amqpTemplate.convertAndSend(msg);
		
	}
	
	@RequestMapping(value="/get", method=RequestMethod.GET)
<<<<<<< HEAD
	public String[] getMessage()
	{
		LinkedList<String> list = new LinkedList<String>();
		
		log.debug("in getMessage");
		Message msg = amqpTemplate.receive();
		while(null != msg) {
			log.debug("got message : " + msg.toString());
			list.add(new String(msg.getBody()));
			msg = amqpTemplate.receive();
		}
		String[] strings = list.stream().toArray(String[]::new);
		return(strings);
=======
	public String getMessage()
	{
		log.debug("in getMessage");
		Message msg = amqpTemplate.receive();
		if(null == msg) {
			return(null);
		}
		log.debug("got message : " + msg.toString());
		return(new String(msg.getBody()));
>>>>>>> 26f136161129c61361d06df372319169c49b029c
	}
}
