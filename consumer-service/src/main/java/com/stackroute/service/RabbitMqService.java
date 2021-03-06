package com.stackroute.service;

import com.stackroute.domain.Employee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.listener.RabbitListenerEndpointRegistrar;
import org.springframework.stereotype.Component;

@Component
public class RabbitMqService {

    private static final Logger logger = LoggerFactory.getLogger(RabbitMqService.class);

    /*
     * Add annotation to read messages from a queue
     */
//    public void recievedMessage(Employee employee) {
//        logger.info("Recieved employee details" + employee);
//    }

	@RabbitListener(queues = "employeequeue")
	public void listening(Employee person) {
		System.out.println(person);
	}
}
