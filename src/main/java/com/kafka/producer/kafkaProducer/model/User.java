package com.kafka.producer.kafkaProducer.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class User {

	private String name;
	private String company;
	private String designation;
}
