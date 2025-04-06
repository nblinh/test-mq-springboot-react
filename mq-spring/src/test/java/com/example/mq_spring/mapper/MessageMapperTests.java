package com.example.mq_spring.mapper;

import com.example.mq_spring.dto.MessageDto;
import com.example.mq_spring.entity.Message;
import com.example.mq_spring.entity.MessageTypeEnum;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MessageMapperTests {
    private final MessageMapper messageMapper = MessageMapper.INSTANCE;

    @Test
    public void toMessageDtoTest() {
        //given
        Message message = Message.builder().id(1L).type(MessageTypeEnum.BANKING).content("test Banking").build();

        //when
        MessageDto messageDto = messageMapper.toMessageDto(message);

        //then
        Assertions.assertEquals(message.getId(), messageDto.id());
        Assertions.assertEquals(message.getType(), messageDto.type());
        Assertions.assertEquals(message.getContent(), messageDto.content());
    }

    @Test
    public void toMessageTest() {
        //given
        MessageDto messageDto = MessageDto.builder().id(1L).type(MessageTypeEnum.BANKING).content("test Banking").build();

        //when
        Message message = messageMapper.toMessage(messageDto);

        //then
        Assertions.assertEquals(messageDto.id(), message.getId());
        Assertions.assertEquals(messageDto.type(), message.getType());
        Assertions.assertEquals(messageDto.content(), message.getContent());
    }
}
