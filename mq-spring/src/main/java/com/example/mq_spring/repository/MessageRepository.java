package com.example.mq_spring.repository;

import com.example.mq_spring.entity.Message;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepository extends JpaRepository<Message, Long> {

}
