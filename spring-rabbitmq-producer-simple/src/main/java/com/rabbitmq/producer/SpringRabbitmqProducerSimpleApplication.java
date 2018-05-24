package com.rabbitmq.producer;

import java.util.stream.IntStream;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringRabbitmqProducerSimpleApplication implements CommandLineRunner {
 
	@Autowired
	RabbitTemplate rabbitTemplate;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringRabbitmqProducerSimpleApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
	
		IntStream.range(0, 150000000).parallel().forEach(i -> 
		rabbitTemplate.convertAndSend("test.fanout", null, "Message from code : "+i));
		System.out.println("=== Message Sent successfully... ====== ");
	}
}
