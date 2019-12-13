package com.gl.kafka.producer;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.stream.IntStream;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.support.SendResult;
import org.springframework.util.concurrent.ListenableFuture;

import com.gl.kafka.producer.sender.impl.KafkaMessageProducer;

@SpringBootApplication
public class SpringKafkaProducerApplication implements ApplicationRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringKafkaProducerApplication.class, args);
	}
	
	@Autowired
	KafkaMessageProducer kafkaMsgProducer;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		System.out.println("<====== Sending Messages over Kafka ======> ");
	   List<String>  messageList = prepareMessageToSendOverKafka(200);
		 List<ListenableFuture<SendResult<String, String>>>  result =  kafkaMsgProducer.produce(messageList);
	
	 result.forEach(f->{
	 	 try {
			f.get();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 });
	
	 System.out.println("<== All messages are sent over Kafka ==>");
	}
	
	

	private List<String> prepareMessageToSendOverKafka(int noOfMessages) {
	
		List<String> list = new ArrayList<>();
		IntStream.of(1,noOfMessages).forEach(j->{
			JSONObject object = new JSONObject();
			for (int i = 0; i < 4; i++) {
				object.put("test_"+i+Math.random()+200, 20*Math.random()+2000);
			}
			list.add(object.toString());
	  });	
		
		return list;
	}
	
	
}
