package com.slandshow.kafkaconsumer.repository;

import com.slandshow.kafkaconsumer.Message;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface MessageRepository extends CrudRepository<Message, UUID> {
}
