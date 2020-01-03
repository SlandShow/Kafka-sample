package com.slandshow.kafkaconsumer.service;

import com.slandshow.kafkaconsumer.Message;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;

import java.util.UUID;
import java.util.concurrent.CountDownLatch;

@Slf4j
@AllArgsConstructor
@NoArgsConstructor
public class ReceiverService {

    private CountDownLatch latch = new CountDownLatch(1);

    @Autowired
    private MessageService messageService;

    public CountDownLatch getLatch() {
        return latch;
    }

    @KafkaListener(topics = "${kafka-consumer.topic}")
    public void receiveAndSave(String payload) {
        log.info("Receive message='{}'", payload);
        messageService.saveOrUpdate(new Message(UUID.randomUUID(), payload));
        latch.countDown();
    }
}
