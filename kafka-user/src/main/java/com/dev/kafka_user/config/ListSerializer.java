package com.dev.kafka_user.config;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.common.serialization.Serializer;

import java.util.List;
import java.util.Map;

public class ListSerializer implements Serializer<List<Integer>> {
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public void configure(Map<String, ?> configs, boolean isKey) {
    }

    @Override
    public byte[] serialize(String topic, List<Integer> data) {
        try {
            return objectMapper.writeValueAsBytes(data);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Failed to serialize List<Integer>", e);
        }
    }

    @Override
    public void close() {
    }
}

