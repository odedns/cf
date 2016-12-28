package cf.queue.service;

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
	public String getMessage()
	{
		log.debug("in getMessage");
		Message msg = amqpTemplate.receive();
		if(null == msg) {
			return(null);
		}
		log.debug("got message : " + msg.toString());
		return(new String(msg.getBody()));
	}
}
