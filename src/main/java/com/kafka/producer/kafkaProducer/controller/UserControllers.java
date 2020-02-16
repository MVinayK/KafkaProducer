package com.kafka.producer.kafkaProducer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kafka.producer.kafkaProducer.model.User;

@RestController
@RequestMapping(value = "/user")
public class UserControllers {
	
	@Value("${kafka.topic_1}")
	private String TOPIC_1;

	@Autowired
	private KafkaTemplate<String, User> kafkaTemplate;
	
	@GetMapping
	public String produce(@RequestParam(value = "name") String name) {
		kafkaTemplate.send(TOPIC_1, new User(name, "JPMC", "Lead"));
		return "produced";
	}
}
