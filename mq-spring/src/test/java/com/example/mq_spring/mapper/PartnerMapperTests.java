package com.example.mq_spring.mapper;

import com.example.mq_spring.dto.PartnerDto;
import com.example.mq_spring.entity.DirectionEnum;
import com.example.mq_spring.entity.Partner;
import com.example.mq_spring.entity.ProcessedFlowTypeEnum;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PartnerMapperTests {
    private final PartnerMapper partnerMapper = PartnerMapper.INSTANCE;

    @Test
    public void toPartnerDtoTest() {
        //given
        Partner partner = Partner.builder().id(1L).alias("alias").type("type").direction(DirectionEnum.INBOUND)
                .application("application").processedFlowType(ProcessedFlowTypeEnum.ALERTING).description("description").build();

        //when
        PartnerDto partnerDto = partnerMapper.toPartnerDto(partner);

        //then
        Assertions.assertEquals(partner.getId(), partnerDto.id());
        Assertions.assertEquals(partner.getAlias(), partnerDto.alias());
        Assertions.assertEquals(partner.getType(), partnerDto.type());
        Assertions.assertEquals(partner.getDirection(), partnerDto.direction());
        Assertions.assertEquals(partner.getApplication(), partnerDto.application());
        Assertions.assertEquals(partner.getProcessedFlowType(), partnerDto.processedFlowType());
        Assertions.assertEquals(partner.getDescription(), partnerDto.description());
    }

    @Test
    public void toPartnerTest() {
        //given
        PartnerDto partnerDto = PartnerDto.builder().id(1L).alias("alias").type("type").direction(DirectionEnum.INBOUND)
                .application("application").processedFlowType(ProcessedFlowTypeEnum.ALERTING).description("description").build();

        //when
        Partner partner = partnerMapper.toPartner(partnerDto);

        //then
        Assertions.assertEquals(partnerDto.id(), partner.getId());
        Assertions.assertEquals(partnerDto.alias(), partner.getAlias());
        Assertions.assertEquals(partnerDto.type(), partner.getType());
        Assertions.assertEquals(partnerDto.direction(), partner.getDirection());
        Assertions.assertEquals(partnerDto.application(), partner.getApplication());
        Assertions.assertEquals(partnerDto.processedFlowType(), partner.getProcessedFlowType());
        Assertions.assertEquals(partnerDto.description(), partner.getDescription());
    }
}
