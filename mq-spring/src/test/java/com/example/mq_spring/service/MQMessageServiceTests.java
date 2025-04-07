package com.example.mq_spring.service;

import com.example.mq_spring.dto.NewMessageDto;
import com.example.mq_spring.entity.MessageTypeEnum;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jms.core.JmsTemplate;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class MQMessageServiceTests {
    @Autowired
    private JmsTemplate jmsTemplate;

    @Autowired
    MQMessageService mqMessageService;

    NewMessageDto newMessageDto;

    @Value("${ibm.mq.queue}")
    private String queue;

    @BeforeEach
    public void init() {
        newMessageDto = NewMessageDto.builder().type(MessageTypeEnum.BANKING).content("test Banking").build();
    }

    @Test
    public void sendTest(){
        var result = mqMessageService.send(newMessageDto);

        Assertions.assertEquals(result, newMessageDto);
    }

}
