package com.example.mq_spring;

import com.example.mq_spring.dto.MessageDto;
import com.example.mq_spring.entity.Message;
import com.example.mq_spring.entity.MessageTypeEnum;
import com.example.mq_spring.repository.MessageRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

@SpringBootTest
@AutoConfigureMockMvc
class MqSpringApplicationTests {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private MessageRepository messageRepository;

    @Autowired
    private ObjectMapper objectMapper;

    MessageDto messageDto;
    Message message;

    @BeforeEach
    public void init() {
        messageDto = MessageDto.builder().id(1L).type(MessageTypeEnum.BANKING).content("test Banking").build();
        message = Message.builder().id(1L).type(MessageTypeEnum.BANKING).content("test Banking").build();
    }

    @Test
    void contextLoads() {
    }

    @Test
    public void findAllMessagesTest() throws Exception {
        // precondition
        messageRepository.save(message);


        // Action and Verify
        var result = mockMvc.perform(get("/messages"))
                .andExpect(status().isOk())
                .andDo(print()).andReturn();
        String json = result.getResponse().getContentAsString();
        CollectionType collectionType = objectMapper.getTypeFactory().constructCollectionType(List.class, MessageDto.class);
        List<MessageDto> messageDtos = objectMapper.readValue(json, collectionType);

        //then
        Assertions.assertTrue(messageDtos.size() > 0);
    }

}
