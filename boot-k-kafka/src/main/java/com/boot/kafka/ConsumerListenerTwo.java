package com.boot.kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class ConsumerListenerTwo {

	@KafkaListener(topics = "my_topic", groupId = "test123")
	public void listen(String message) {
		System.out.println("--------Consumer---------");
		System.out.println("Received Messasge: " + message);
		System.out.println("--------Consumer---------");
	}

}