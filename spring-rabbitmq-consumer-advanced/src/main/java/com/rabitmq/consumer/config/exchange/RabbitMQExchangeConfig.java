package com.rabitmq.consumer.config.exchange;

import org.springframework.amqp.core.Exchange;
import org.springframework.amqp.core.ExchangeBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQExchangeConfig {

	
	/** 
	 * Creating fanout exchange programmatically
	 * 
	 * */
	@Bean
	Exchange fanoutExchange() { 
	  return	ExchangeBuilder.directExchange("Spring.fanout").autoDelete().internal().build();
	}
	

	/** 
	 * Creating topic exchange programmatically
	 * 
	 * */
	@Bean
	Exchange topicExchange() { 
	  return	ExchangeBuilder.directExchange("Spring.topic").autoDelete().internal().build();
	}
	

	/** 
	 * Creating header exchange programmatically
	 * 
	 * */
	@Bean
	Exchange headerExchange() { 
	  return	ExchangeBuilder.directExchange("Spring.header").autoDelete().internal().build();
	}
	
	

	/** 
	 * Creating fanout exchange programmatically
	 * 
	 * */
	@Bean
	Exchange directExchange() { 
	  return	ExchangeBuilder.directExchange("Spring.direct").autoDelete().internal().build();
	}
	
}
