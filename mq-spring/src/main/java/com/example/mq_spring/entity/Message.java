package com.example.mq_spring.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "message")
public class Message {
    @Id
    private @GeneratedValue Long id;

    @Enumerated(EnumType.STRING)
    private MessageTypeEnum type;

    private String content;

}
