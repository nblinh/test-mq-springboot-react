package com.example.mq_spring.controller;

import com.example.mq_spring.dto.NewPartnerDto;
import com.example.mq_spring.dto.PartnerDto;
import com.example.mq_spring.service.PartnerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class PartnerController {
    private final PartnerService partnerService;

    public PartnerController(PartnerService partnerService) {
        this.partnerService = partnerService;
    }

    @GetMapping("/partners")
    public List<PartnerDto> findAllPartners() {
        return partnerService.findAll();
    }

    @GetMapping("/partners/{partnerId}")
    public PartnerDto getPartner(@PathVariable Long partnerId) {
        return partnerService.findById(partnerId);
    }

    @PostMapping("/partners")
    public PartnerDto createPartner(@RequestBody NewPartnerDto newPartnerDto) {
        return partnerService.save(newPartnerDto);
    }

    @DeleteMapping("/partners/{partnerId}")
    public void deletePartner(@PathVariable Long partnerId) {
        partnerService.deleteById(partnerId);
    }

}
