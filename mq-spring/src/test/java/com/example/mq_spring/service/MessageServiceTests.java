package com.example.mq_spring.service;

import com.example.mq_spring.dto.MessageDto;
import com.example.mq_spring.dto.NewMessageDto;
import com.example.mq_spring.entity.Message;
import com.example.mq_spring.entity.MessageTypeEnum;
import com.example.mq_spring.repository.MessageRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.Mockito.*;

import java.util.List;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class MessageServiceTests {
    @Mock
    private MessageRepository messageRepository;

    @InjectMocks
    private MessageService messageService;

    MessageDto messageDto;
    Message message;

    @BeforeEach
    public void init() {
        messageDto = MessageDto.builder().id(1L).type(MessageTypeEnum.BANKING).content("test Banking").build();
        message = Message.builder().id(1L).type(MessageTypeEnum.BANKING).content("test Banking").build();
    }

    @Test
    public void findAllTest(){
        //given
        Mockito.when(messageRepository.findAll()).thenReturn(List.of(message));

        //when
        var result = messageService.findAll();

        //then
        verify(messageRepository).findAll();
        Assertions.assertEquals(result, List.of(messageDto));
    }

    @Test
    public void findByIdTest(){
        //given
        Mockito.when(messageRepository.findById(message.getId())).thenReturn(Optional.of(message));

        //when
        var result = messageService.findById(message.getId());

        //then
        verify(messageRepository).findById(message.getId());
        Assertions.assertEquals(result, messageDto);
    }

    @Test
    public void saveTest(){
        //given
        NewMessageDto newMessageDto = NewMessageDto.builder().type(MessageTypeEnum.BANKING).content("test Banking").build();
        when(messageRepository.save(any())).thenReturn(message);

        //when
        var result = messageService.save(newMessageDto);

        //then
        verify(messageRepository).save(any());
        Assertions.assertEquals(result, messageDto);
    }

}
