package com.example.mq_spring.router;

import com.example.mq_spring.dto.NewMessageDto;
import com.example.mq_spring.entity.MessageTypeEnum;
import com.example.mq_spring.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BankingMessageRouter implements MQMessageRouter {

    @Autowired
    private MessageService messageService;

    @Override
    public boolean accept(MessageTypeEnum type) {
        return MessageTypeEnum.BANKING.equals(type);
    }

    @Override
    public void execute(NewMessageDto newMessageDto) {

        messageService.save(newMessageDto);
    }
}
