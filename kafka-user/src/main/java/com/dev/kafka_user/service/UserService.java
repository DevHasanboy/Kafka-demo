package com.dev.kafka_user.service;

import com.dev.kafka_user.dto.UserDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UserService {
    ResponseEntity<?> createUser(UserDto dto);
    ResponseEntity<?> findUserById(Integer id);
    ResponseEntity<?> updateUser(Integer id, UserDto dto);
    ResponseEntity<?> deleteUser(Integer id);
    ResponseEntity<?> findAllUsers();
}
