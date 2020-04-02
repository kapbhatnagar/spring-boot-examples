package com.boot.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProducerController {

	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;

	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	public String hello() {
		System.out.println("--------Sending msg by kafka producer---------");
		String topicName = "my_topic";
		String key = "key1";
		String value = "hello";
		kafkaTemplate.send(topicName, key, value);
		System.out.println("--------Msg Send by kakfa producer---------");
		return "Hello!";
	}

}