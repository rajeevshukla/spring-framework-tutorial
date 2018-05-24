package com.rabitmq.consumer.config.queue;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.QueueBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQQueueConfig {

	
	@Bean
	Queue queue() { 
		return QueueBuilder.durable("SpringBootQueue2").autoDelete().exclusive().build();
	}
	
}
