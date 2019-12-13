package com.gl.kafka.producer.sender;

import java.util.List;

import org.springframework.kafka.support.SendResult;
import org.springframework.util.concurrent.ListenableFuture;

public interface MessageProducer {

	public List<ListenableFuture<SendResult<String, String>>> produce(List<String> message);
}
