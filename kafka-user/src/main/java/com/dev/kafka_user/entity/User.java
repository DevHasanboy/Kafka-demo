package com.dev.kafka_user.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "kafka_user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "first_name")
    private String firstname;
    @Column(name = "last_name")
    private String lastname;
    @Column(name = "age")
    private String age;
}
