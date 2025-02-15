package com.dev.kafka_user.producer;

import com.dev.kafka_user.dto.UserDto;
import com.dev.kafka_user.repository.UserRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class KafkaProducer {

    @Value("${KAFKA_TOPIC_NAME:kafka-topic}")
    private String topicName;
    private final KafkaTemplate<String, String> kafkaTemplate;
    private final KafkaTemplate<String, List<Integer>> kafkaTemplateUser;

    public KafkaProducer(KafkaTemplate<String, String> kafkaTemplate, KafkaTemplate<String, List<Integer>> kafkaTemplateUser) {
        this.kafkaTemplate = kafkaTemplate;
        this.kafkaTemplateUser = kafkaTemplateUser;
    }

    public void send(String message) {
        kafkaTemplate.send(topicName, message);
    }

    public void sendUserIdsToCard(List<Integer> ids){
        kafkaTemplateUser.send("vali", ids);
    }

}
