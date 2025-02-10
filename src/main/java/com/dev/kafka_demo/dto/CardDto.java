package com.dev.kafka_demo.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CardDto {
    private Integer id;
    private Integer userId;
    private String cardNumber;
    private String cardCode;
}
