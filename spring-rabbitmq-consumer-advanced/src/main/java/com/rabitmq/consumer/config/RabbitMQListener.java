package com.rabitmq.consumer.config;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;

public class RabbitMQListener implements MessageListener{

	
	@Override
	public void onMessage(Message message) {
		 System.out.println("Consumer Queue Name: "+ message.getMessageProperties().getConsumerQueue());
		System.out.println("Payload: "+ new String(message.getBody()));
		System.out.println("Message Headers : "+message.getMessageProperties().getHeaders());
		
	}
}
