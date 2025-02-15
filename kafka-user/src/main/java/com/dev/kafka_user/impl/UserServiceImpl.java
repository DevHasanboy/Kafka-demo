package com.dev.kafka_user.impl;

import com.dev.kafka_user.dto.UserDto;
import com.dev.kafka_user.entity.User;
import com.dev.kafka_user.mapper.UserMapper;
import com.dev.kafka_user.producer.KafkaProducer;
import com.dev.kafka_user.repository.UserRepository;
import com.dev.kafka_user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final KafkaProducer producer;

    public UserServiceImpl(UserRepository userRepository, UserMapper userMapper, KafkaProducer producer) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
        this.producer = producer;
    }

    @Override
    public ResponseEntity<?> createUser(UserDto dto) {
        User entity = this.userMapper.toEntity(dto);
        this.userRepository.save(entity);
        // this.producer.sendUserCreatedEvent(this.userMapper.toDto(entity));
        return ResponseEntity.ok("User created successfully");
    }

    @Override
    public ResponseEntity<?> findUserById(Integer id) {
        User user = this.userRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        return ResponseEntity.status(HttpStatus.OK).body(this.userMapper.toDto(user));
    }

    @Override
    public ResponseEntity<?> updateUser(Integer id, UserDto dto) {
        User user = this.userRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        this.userMapper.toUpdate(user, dto);
        this.userRepository.save(user);
        return ResponseEntity.ok("User updated successfully");
    }

    @Override
    public ResponseEntity<?> deleteUser(Integer id) {
        User user = this.userRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        this.userRepository.delete(user);
        return ResponseEntity.ok("User deleted successfully");
    }

    @Override
    public ResponseEntity<?> findAllUsers() {
        List<User> list = this.userRepository.findAll();
        List<UserDto> dtoList = new ArrayList<>();
        if (!list.isEmpty())
            for (User user : list) {
                dtoList.add(this.userMapper.toDto(user));
            }
        return ResponseEntity.status(HttpStatus.OK).body(dtoList);
    }
}
