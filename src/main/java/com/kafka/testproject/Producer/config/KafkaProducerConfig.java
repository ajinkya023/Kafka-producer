package com.kafka.testproject.Producer.config;

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

@Configuration
public class KafkaProducerConfig {
	
	@Value("${spring.kafka.bootstrap-servers}")
	private String serverInfo;
	
	public Map<String, Object> getProducerConfig() {
		Map<String, Object> props = new HashMap<>();
		props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, serverInfo);
		props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
		props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);

		return props;
	}
	
	@Bean
	public ProducerFactory<String, String> produceFactory() {
		return new DefaultKafkaProducerFactory<String, String>(getProducerConfig());
	}
	
	@Bean
	public KafkaTemplate<String, String> getKafkaTemplate(ProducerFactory<String, String> produceFactory) {
		return new KafkaTemplate<>(produceFactory);
	}
	

}
