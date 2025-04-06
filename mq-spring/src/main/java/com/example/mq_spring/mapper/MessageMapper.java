package com.example.mq_spring.mapper;

import com.example.mq_spring.dto.MessageDto;
import com.example.mq_spring.dto.NewMessageDto;
import com.example.mq_spring.entity.Message;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface MessageMapper {

    MessageMapper INSTANCE = Mappers.getMapper(MessageMapper.class);

    MessageDto toMessageDto(Message message);

    Message toMessage(MessageDto messageDto);

    Message toMessage(NewMessageDto newMessageDto);
}
