package com.gl.kafka.producer.config;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;

@Configuration
@EnableKafka
@EnableConfigurationProperties
public class AppConfig {

	@Value("${spring.kafka.bootstrap-servers}")
	public String kafkaServers;

	/*
	 * @Bean(name ="pat-kafka") public KafkaTemplate<String, Object>
	 * kafkaTemplateConfig() {
	 * 
	 * DefaultKafkaProducerFactory<String, Object> producerFactory = new
	 * DefaultKafkaProducerFactory<>(producerProps());
	 * producerFactory.setTransactionIdPrefix("patidentifier-0");
	 * KafkaTemplate<String, Object> kt= new KafkaTemplate<>(producerFactory);
	 * return kt; }
	 * 
	 * 
	 * private Map<String, Object> producerProps() { Map<String, Object> props = new
	 * HashMap<>(); props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,
	 * kafkaServers); props.put(ProducerConfig.LINGER_MS_CONFIG, 500);
	 * props.put(ProducerConfig.RETRIES_CONFIG, 1);
	 * props.put(ProducerConfig.BATCH_SIZE_CONFIG, 16384);
	 * props.put(ProducerConfig.BUFFER_MEMORY_CONFIG, 33554432);
	 * props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,
	 * StringSerializer.class);
	 * props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,
	 * StringSerializer.class); return props; }
	 * 
	 */
	
	  @PostConstruct public void setup() { //Setting up exception handler
	  
		  System.out.println("config set"+ kafkaServers);
	  
	  }
	 
	
	

}
