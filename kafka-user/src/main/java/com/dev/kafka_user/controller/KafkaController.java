package com.dev.kafka_user.controller;

import com.dev.kafka_user.producer.KafkaProducer;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController

public class KafkaController {
    private final KafkaProducer kafkaProducer;
    private final UserController userService;

    public KafkaController(KafkaProducer kafkaProducer, UserController userService) {
        this.kafkaProducer = kafkaProducer;
        this.userService = userService;
    }

    @PostMapping("/kafka/send")
    public String send(@RequestParam String message) {
        kafkaProducer.send(message);
        return "success";
    }

    @PostMapping("/list/ids")
    public List<Integer> senAllUserIds() throws JsonProcessingException {
        List<Integer> all = userService.findAll();
        kafkaProducer.sendUserIdsToCard(all);
        return all;
    }
}
