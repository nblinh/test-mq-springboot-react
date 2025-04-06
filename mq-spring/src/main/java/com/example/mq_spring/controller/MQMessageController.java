package com.example.mq_spring.controller;

import com.example.mq_spring.dto.NewMessageDto;
import com.example.mq_spring.service.MQMessageService;
import org.springframework.web.bind.annotation.*;

@RestController
public class MQMessageController {
    private final MQMessageService MQMessageService;

    public MQMessageController(MQMessageService MQMessageService) {
        this.MQMessageService = MQMessageService;
    }

    @PostMapping("send")
    public NewMessageDto send(@RequestBody NewMessageDto newMessageDto) {
        return MQMessageService.send(newMessageDto);
    }

}
