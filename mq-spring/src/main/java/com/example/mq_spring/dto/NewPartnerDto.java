package com.example.mq_spring.dto;

import com.example.mq_spring.entity.DirectionEnum;
import com.example.mq_spring.entity.ProcessedFlowTypeEnum;
import lombok.Builder;

import java.io.Serializable;

@Builder
public record NewPartnerDto(String alias, String type, DirectionEnum direction, String application,
                            ProcessedFlowTypeEnum processedFlowType, String description) implements Serializable {
}
