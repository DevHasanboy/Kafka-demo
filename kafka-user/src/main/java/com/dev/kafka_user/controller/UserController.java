package com.dev.kafka_user.controller;

import com.dev.kafka_user.dto.UserDto;
import com.dev.kafka_user.repository.UserRepository;
import com.dev.kafka_user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Locale;

@RestController
@RequestMapping("/api/v1/user")

public class UserController {
    private final UserService userService;
    private final UserRepository userRepository;

    public UserController(UserService userService, UserRepository userRepository) {
        this.userService = userService;
        this.userRepository = userRepository;
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody UserDto dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(
                this.userService.createUser(dto));
    }

    @GetMapping("/{id}/get")
    public ResponseEntity<?> byId(@PathVariable("id") Integer id) {
        return ResponseEntity.status(HttpStatus.OK).body(
                this.userService.findUserById(id)
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody UserDto dto, @PathVariable("id") Integer id) {
        return ResponseEntity.status(HttpStatus.OK).body(
                this.userService.updateUser(id, dto)
        );
    }

    @DeleteMapping("/{id}/delete")
    public ResponseEntity<?> delete(@PathVariable("id") Integer id) {
        return ResponseEntity.status(HttpStatus.OK).body(
                this.userService.deleteUser(id)
        );
    }

    @GetMapping("/get-all")
    public List<Integer> findAll() {
        return this.userRepository.getAllIds();
    }

}
