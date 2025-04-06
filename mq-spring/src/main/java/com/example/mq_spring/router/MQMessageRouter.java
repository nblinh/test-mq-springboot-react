package com.example.mq_spring.router;

import com.example.mq_spring.dto.NewMessageDto;
import com.example.mq_spring.entity.MessageTypeEnum;

public interface MQMessageRouter {
    boolean accept(MessageTypeEnum type);

    void execute(NewMessageDto newMessageDto);
}
