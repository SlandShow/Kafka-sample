package com.example.slandshow.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SenderService {

    @Value("${kafka-provider.topic}")
    private String kafkaTopic;

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void send(String payload) {
        log.info("Sending message='{}'", payload);
        kafkaTemplate.send(kafkaTopic, payload);
    }
}
