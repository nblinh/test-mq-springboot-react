package com.example.mq_spring.repository;

import com.example.mq_spring.entity.Message;
import org.springframework.data.repository.ListCrudRepository;

public interface MessageRepository extends ListCrudRepository<Message, Long> {

}
