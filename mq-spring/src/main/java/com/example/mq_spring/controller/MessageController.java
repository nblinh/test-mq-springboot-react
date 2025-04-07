package com.example.mq_spring.controller;

import com.example.mq_spring.dto.MessageDto;
import com.example.mq_spring.service.MessageService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


@RestController("")
public class MessageController {
    private final MessageService messageService;

    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

    @GetMapping("/messages")
    public Page<MessageDto> findAllMessages(Pageable pageable) {
        return messageService.findAll(pageable);
    }

    @GetMapping("/messages/{messageId}")
    public MessageDto getMessage(@PathVariable Long messageId) {
        return messageService.findById(messageId);
    }


}
