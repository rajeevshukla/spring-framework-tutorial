package com.gl.kafka.producer.sender.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;

import com.gl.kafka.producer.sender.MessageProducer;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class KafkaMessageProducer implements MessageProducer {

	@Value("${spring.kafka.topic.name}")
	private String topicName;
	
	@Autowired(required = true)
	KafkaTemplate<String, String> kafkaTemplate;
	
	@Override
	public List<ListenableFuture<SendResult<String, String>>> produce(List<String> messages) {
		List<ListenableFuture<SendResult<String, String>>> futures =  messages.stream()
				.map(pr-> kafkaTemplate.send(new ProducerRecord<String, String>(topicName, pr)))
				.collect(Collectors.toList());
		System.out.println("Total message Sent Over Kafka:"+messages.size());
		return futures;
		
	}
	
}
