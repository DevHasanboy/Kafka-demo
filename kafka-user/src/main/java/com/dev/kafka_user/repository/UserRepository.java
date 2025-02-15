package com.dev.kafka_user.repository;

import com.dev.kafka_user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    @Query(value = "select id from kafka_user",nativeQuery = true)
    List<Integer> getAllIds();
}
