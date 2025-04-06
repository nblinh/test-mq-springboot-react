package com.example.mq_spring.service;


import com.example.mq_spring.dto.MessageDto;
import com.example.mq_spring.mapper.MessageMapper;
import com.example.mq_spring.dto.NewMessageDto;
import com.example.mq_spring.entity.Message;
import com.example.mq_spring.exception.NotFoundException;
import com.example.mq_spring.repository.MessageRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MessageService {

    private final MessageRepository messageRepository;
    private final MessageMapper mapper = MessageMapper.INSTANCE;

    public MessageService(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    public List<MessageDto> findAll() {
        return messageRepository.findAll()
                .stream()
                .map(mapper::toMessageDto)
                .toList();
    }

    public MessageDto findById(Long id) {
        Optional<Message> message = messageRepository.findById(id);
        if (message.isEmpty()) {
            throw new NotFoundException("Message not found with id: " + id);
        }
        return mapper.toMessageDto(message.get());
    }

    public MessageDto save(NewMessageDto newMessageDto) {
        Message message = mapper.toMessage(newMessageDto);
        return mapper.toMessageDto(messageRepository.save(message));
    }

}