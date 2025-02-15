package com.dev.kafka_user.dto;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    private Integer id;
    private String firstname;
    private String lastname;
    private String age;
}
