package com.dev.kafka_demo.controller;

import com.dev.kafka_demo.dto.CardDto;
import com.dev.kafka_demo.service.CardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/card")
@RequiredArgsConstructor
public class CardController {
    private final CardService cardService;

    @PostMapping("/create")
    public String addCard(@RequestBody CardDto dto) {
        return this.cardService.addCard(dto);
    }

    @GetMapping("/{id}/get_by_id")
    public CardDto getById(@PathVariable("id") Integer id) {
        return this.cardService.getById(id);
    }
}
