package com.example.mq_spring.controller;

import com.example.mq_spring.dto.MessageDto;
import com.example.mq_spring.service.MessageService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MessageController {
    private final MessageService messageService;

    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

    @GetMapping("/messages")
    public List<MessageDto> findAllMessages() {
        return messageService.findAll();
    }

    @GetMapping("/messages/{messageId}")
    public MessageDto getMessage(@PathVariable Long messageId) {
        return messageService.findById(messageId);
    }


}
