package com.example.mq_spring.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Partner {
    @Id
    private @GeneratedValue Long id;

    private String alias;

    private String type;

    @Enumerated(EnumType.STRING)
    private DirectionEnum direction;

    private String application;

    @Enumerated(EnumType.STRING)
    private ProcessedFlowTypeEnum processedFlowType;

    private String description;

}
