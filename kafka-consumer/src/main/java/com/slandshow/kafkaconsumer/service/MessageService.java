package com.slandshow.kafkaconsumer.service;

import com.slandshow.kafkaconsumer.Message;
import com.slandshow.kafkaconsumer.repository.MessageRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@Slf4j
@AllArgsConstructor
@NoArgsConstructor
public class MessageService {

    @Autowired
    private MessageRepository messageRepository;

    public List<Message> getAll() {
        List<Message> messages = new ArrayList<>();
        messageRepository.findAll().forEach(messages::add);
        return messages;
    }

    public Message getById(UUID id) {
        return messageRepository.findById(id).orElse(null);
    }

    public Message saveOrUpdate(Message message) {
        messageRepository.save(message);
        return message;
    }
}
