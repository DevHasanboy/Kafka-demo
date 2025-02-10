package com.dev.kafka_demo.consumer;

import com.dev.kafka_demo.service.CardService;
import org.springframework.context.annotation.Lazy;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;



@Service
public class KafkaConsumer {

    private final CardService cardService;

    public KafkaConsumer(@Lazy CardService cardService) {
        this.cardService = cardService;
    }

    @KafkaListener(topics = "dev", groupId = "my-groups")
    public void consume(String message) {
        System.out.println("recieved message: " + message);
    }

}
