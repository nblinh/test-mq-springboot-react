package com.example.mq_spring.mapper;

import com.example.mq_spring.dto.PartnerDto;
import com.example.mq_spring.dto.NewPartnerDto;
import com.example.mq_spring.entity.Partner;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PartnerMapper {

    PartnerMapper INSTANCE = Mappers.getMapper(PartnerMapper.class);

    PartnerDto toPartnerDto(Partner partner);

    Partner toPartner(PartnerDto partnerDto);

    Partner toPartner(NewPartnerDto newPartnerDto);
}
