package com.dev.kafka_demo.config;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.common.serialization.Deserializer;

import java.util.List;
import java.util.Map;

public class ListDeserializer implements Deserializer<List<Integer>> {
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public void configure(Map<String, ?> configs, boolean isKey) {
    }

    @Override
    public List<Integer> deserialize(String topic, byte[] data) {
        try {
            return objectMapper.readValue(data, new TypeReference<List<Integer>>() {});
        } catch (Exception e) {
            throw new RuntimeException("Failed to deserialize List<Integer>", e);
        }
    }

    @Override
    public void close() {
    }
}

