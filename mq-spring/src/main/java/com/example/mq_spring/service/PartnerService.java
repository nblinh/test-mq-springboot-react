package com.example.mq_spring.service;


import com.example.mq_spring.dto.PartnerDto;
import com.example.mq_spring.dto.NewPartnerDto;
import com.example.mq_spring.entity.Partner;
import com.example.mq_spring.exception.NotFoundException;
import com.example.mq_spring.mapper.PartnerMapper;
import com.example.mq_spring.repository.PartnerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PartnerService {

    private final PartnerRepository partnerRepository;
    private final PartnerMapper mapper = PartnerMapper.INSTANCE;

    public PartnerService(PartnerRepository partnerRepository) {
        this.partnerRepository = partnerRepository;
    }

    public List<PartnerDto> findAll() {
        return partnerRepository.findAll()
                .stream()
                .map(mapper::toPartnerDto)
                .toList();
    }

    public PartnerDto findById(Long id) {
        Optional<Partner> partner = partnerRepository.findById(id);
        if (partner.isEmpty()) {
            throw new NotFoundException("Partner not found with id: " + id);
        }
        return mapper.toPartnerDto(partner.get());
    }

    public PartnerDto save(NewPartnerDto newPartnerDto) {
        Partner partner = mapper.toPartner(newPartnerDto);
        return mapper.toPartnerDto(partnerRepository.save(partner));
    }

    public void deleteById(Long id) {
        if (!partnerRepository.existsById(id)) {
            throw new NotFoundException("Partner not found with id: " + id);
        }
        partnerRepository.deleteById(id);
    }

}