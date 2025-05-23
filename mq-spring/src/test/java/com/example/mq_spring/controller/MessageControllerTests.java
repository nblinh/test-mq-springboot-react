package com.example.mq_spring.controller;

import com.example.mq_spring.dto.MessageDto;
import com.example.mq_spring.entity.MessageTypeEnum;
import com.example.mq_spring.service.MessageService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

@WebMvcTest(MessageController.class)
public class MessageControllerTests {
    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    MessageService messageService;

    @Autowired
    private ObjectMapper objectMapper;

    MessageDto messageDto;

    @BeforeEach
    public void init() {
        messageDto = MessageDto.builder().id(1L).type(MessageTypeEnum.BANKING).content("test Banking").build();
    }

    @Test
    public void findAllMessagesTest() throws Exception {
        //given
        Pageable pageable = PageRequest.of(0, 2);
        Page<MessageDto> messageDtoPage=new PageImpl<>(List.of(messageDto));
        Mockito.when(messageService.findAll(pageable)).thenReturn(messageDtoPage);

        //when
        mockMvc.perform(get("/messages?page=0&size=2"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.content",hasSize(1)));;

    }

    @Test
    public void getMessageTest() throws Exception {
        //given
        Mockito.when(messageService.findById(messageDto.id())).thenReturn(messageDto);

        //when
        var result = mockMvc.perform(get("/messages/{messageId}", messageDto.id())).andDo(print()).andExpect(status().isOk()).andReturn();
        String json = result.getResponse().getContentAsString();
        MessageDto responseObject = objectMapper.readValue(json, MessageDto.class);

        //then
        Assertions.assertEquals(responseObject, messageDto);
    }
}
