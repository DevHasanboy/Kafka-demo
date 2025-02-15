package com.dev.kafka_user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

@SpringBootApplication
public class KafkaUserApplication {

	public static void main(String[] args) {
		SpringApplication.run(KafkaUserApplication.class, args);
	}

}
