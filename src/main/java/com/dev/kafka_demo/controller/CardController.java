package com.dev.kafka_demo.controller;

import com.dev.kafka_demo.dto.CardDto;
import com.dev.kafka_demo.service.CardService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/card")
public class CardController {
    private final CardService cardService;

    public CardController(CardService cardService) {
        this.cardService = cardService;
    }


    @GetMapping("/{id}/get_by_id")
    public CardDto getById(@PathVariable("id") Integer id) {
        return this.cardService.getById(id);
    }
}
