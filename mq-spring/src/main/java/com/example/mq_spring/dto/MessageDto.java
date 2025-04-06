package com.example.mq_spring.dto;

import com.example.mq_spring.entity.MessageTypeEnum;
import lombok.Builder;

import java.io.Serializable;

@Builder
public record MessageDto(Long id, MessageTypeEnum type, String content) implements Serializable {
}
