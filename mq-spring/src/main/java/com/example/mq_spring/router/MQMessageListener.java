package com.example.mq_spring.router;

import com.example.mq_spring.dto.NewMessageDto;
import com.example.mq_spring.entity.MessageTypeEnum;
import com.example.mq_spring.service.MQMessageService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Component
public class MQMessageListener {

    @Autowired
    private MQMessageService MQMessageService;

    @Autowired
    private List<MQMessageRouter> mqMessageRouter;

    @JmsListener(destination = "${ibm.mq.queue}")
    public void receiveMessage(NewMessageDto newMessageDto) {
        mqMessageRouter.stream().filter(item -> item.accept(newMessageDto.type())).findFirst().ifPresent(router -> router.execute(newMessageDto));

        System.out.println();
        System.out.println("=================================queue=======");
        System.out.println("Received message is: " + newMessageDto.toString());
        System.out.println("========================================");

    }

    /*
     * for demo message sent purpose
     * */
    @PostConstruct
    public void init() {
        NewMessageDto newMessageDto = new NewMessageDto(MessageTypeEnum.BANKING, "Hello from IBM MQ at " + new Date());
        MQMessageService.send(newMessageDto);
        NewMessageDto newMessageDto2 = new NewMessageDto(MessageTypeEnum.BANKING, "Hello recruiters");
        MQMessageService.send(newMessageDto2);
        NewMessageDto newMessageDto3 = new NewMessageDto(MessageTypeEnum.BANKING, "Hello everybody");
        MQMessageService.send(newMessageDto3);
    }
}