package com.stackroute.service;

import com.stackroute.domain.Employee;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class RabbitMqSender {

    /*
     * Add code to define RabbitTemplate
     */
	private RabbitTemplate  rabbitTemplate;

    /*
     * Add code to autowire RabbitTemplate object using contructor autowiring
     *
     */
     public RabbitMqSender(RabbitTemplate  rabbitTemplate){
    	 this.rabbitTemplate = rabbitTemplate;
     }

    @Value("${spring.rabbitmq.exchange}")
    private String exchange;

    @Value("${spring.rabbitmq.routingkey}")
    private String routingkey;

    public void send(Employee employee) {
        /*
         * Add code to publish the method to the exchange
         * with specified routingKey using the RabbitTemplate object.
         */
    	rabbitTemplate.convertSendAndReceive(exchange, routingkey, employee);
    }
}
