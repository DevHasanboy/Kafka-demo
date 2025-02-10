package com.dev.kafka_demo.service;

import com.dev.kafka_demo.consumer.KafkaConsumer;
import com.dev.kafka_demo.dto.CardDto;
import com.dev.kafka_demo.entity.Card;
import com.dev.kafka_demo.repository.CardRepository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CopyOnWriteArrayList;

@Service
@RequiredArgsConstructor
public class CardService {
    private final CardRepository cardRepository;

    private final KafkaConsumer kafkaConsumer;
    private final ObjectMapper objectMapper;
    // Thread-safe list ishlatamiz
    private final List<Integer> ids = new CopyOnWriteArrayList<>();

/*
    @KafkaListener(topics = "vali", groupId = "my-groups")
    public void createCardForUser(String str) {
        System.err.println("All Ids from Kafka: " + str);
        Card card = new Card();
        card.setText(str);
        cardRepository.save(card);
        try {
            synchronized (this) {  // IDs ro‘yxatini xavfsiz yangilaymiz
                ids.clear(); // Eski ma'lumotlarni tozalash
                ids.addAll(objectMapper.readValue(str, new TypeReference<List<Integer>>() {
                }));
            }
            System.err.println("Updated Ids: " + ids);
        } catch (Exception e) {
            System.err.println("Error parsing JSON: " + e.getMessage());
        }
    }*/

    @Transactional
    @KafkaListener(topics = "vali", groupId = "my-groups")
    public void createCardForUser(String str) {
        System.out.println("Received from Kafka: " + str);
        try {
            List<Integer> ids = objectMapper.readValue(str, new TypeReference<>() {});
            System.out.println("Parsed IDs: " + ids);

            // ID lar bo'yicha kartalar yaratamiz
            for (Integer userId : ids) {
                Card card = new Card();
                card.setUserId(userId);
                card.setCardCode("CARD_" + userId);
                card.setNumber("1234-5678-" + userId); // Random yoki specific logic qo'shing
                cardRepository.save(card);
            }
            System.out.println("All cards saved successfully!");

        } catch (Exception e) {
            System.err.println("Error parsing JSON: " + e.getMessage());
        }
    }

    public String addCard(CardDto dto) {
        synchronized (this) { // Parallel muammolarni oldini olamiz
            if (ids.contains(dto.getUserId())) {
                Card card = new Card();
                card.setCardCode(dto.getCardCode());
                card.setNumber(dto.getCardNumber());
                card.setUserId(dto.getUserId());
                cardRepository.save(card);
                return "Card created successfully";
            }
            return "User Id Not Found";
        }
    }

    public CardDto getById(Integer id) {
        Optional<Card> card = this.cardRepository.findById(id);
        CardDto dto = new CardDto();
        dto.setId(card.get().getId());
        dto.setCardCode(card.get().getCardCode());
        dto.setCardNumber(card.get().getNumber());
        return dto;
    }

    public String getUserIds(String str) {
        return str;

    }
}
