package com.dev.kafka_demo.service;

import com.dev.kafka_demo.dto.CardDto;
import com.dev.kafka_demo.repository.CardRepository;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CardService {
    private final CardRepository cardRepository;

    public CardService(CardRepository cardRepository) {
        this.cardRepository = cardRepository;
    }

    @KafkaListener(topics = "vali", groupId = "my-groups")
    public void createCardForUser(List<Integer> ids1) {
        System.out.println("Received from Kafka: " + ids1);


    }

    public CardDto getById(Integer id) {
       /* Optional<Card> card = this.cardRepository.findById(id);
        CardDto dto = new CardDto();
        dto.setId(card.get().getId());
        dto.setCardCode(card.get().getCardCode());
        dto.setCardNumber(card.get().getNumber());
        return dto;*/
        return null;
    }

}
