package com.kafka.producer.kafkaProducer.config;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;

import com.kafka.producer.kafkaProducer.model.User;

@Configuration
public class KafkaConfiguration {

	@Value("${spring.kafka.bootstrap-servers}")
	private String BOOTSTRAP_SERVER;
	@Bean
	public ProducerFactory<String, User> producerFactory() {
		Map<String, Object> configs = new HashMap<>();
		configs.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, BOOTSTRAP_SERVER);
		configs.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
		configs.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
		return new DefaultKafkaProducerFactory<>(configs);
	}
	
	@Bean 
	public KafkaTemplate<String, User> kafkaTemplate() {
		return new KafkaTemplate<String, User>(producerFactory());
	}
	
}
