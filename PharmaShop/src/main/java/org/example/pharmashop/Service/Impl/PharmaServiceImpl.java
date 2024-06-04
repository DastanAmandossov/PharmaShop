package org.example.pharmashop.Service.Impl;

import lombok.RequiredArgsConstructor;
import org.example.pharmashop.Model.Pharma;
import org.example.pharmashop.Repository.PharmaRepo;
import org.example.pharmashop.Service.PharmaServiceDto;

import org.example.pharmashop.dto.PharmaAdminDto;
import org.example.pharmashop.dto.PharmaDto;
import org.example.pharmashop.mapper.PharmaAdminMapper;
import org.example.pharmashop.mapper.PharmaMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;



@Service
@RequiredArgsConstructor
public class PharmaServiceImpl implements PharmaServiceDto {
    private final PharmaRepo pharmaRepo;
    private final PharmaMapper pharmaMapper;
    private final PharmaAdminMapper pharmaAdminMapper;

    @Override
    public List<PharmaDto> getAllPharma() {
        return pharmaRepo.findAll().stream().map(pharmaMapper::toDto).collect(Collectors.toList());
    }


    @Override
    public PharmaDto getPharmaByName(String name) {
        return pharmaRepo.findFirstByName(name)
                .map(pharmaMapper::toDto)
                .orElse(null);
    }
    @Override
    public PharmaDto getPharmaByDescription(String description) {
        return pharmaRepo.findPharmaByDescription(description)
                .map(pharmaMapper::toDto)
                .orElse(null);
    }

    @Override
    public PharmaDto getPharmaByPrice(Integer price) {
        return pharmaRepo.findPharmaByPrice(price).map(pharmaMapper::toDto).orElse(null);
    }

    @Override
    public PharmaAdminDto addPharma(PharmaAdminDto pharmaAdminDto) {
        Pharma pharma= pharmaAdminMapper.toEntity(pharmaAdminDto);
        Pharma savedPharma=pharmaRepo.save(pharma);
        return pharmaAdminMapper.toDto(savedPharma);
    }

    @Override
    public PharmaAdminDto updatePharma(PharmaAdminDto pharmaAdminDto) {
        return pharmaRepo.findById(pharmaAdminDto.getId()).
                map(existingPharma->{
                    existingPharma.setName(pharmaAdminDto.getName());
                    existingPharma.setDescription(pharmaAdminDto.getDescription());
                    existingPharma.setPrice(pharmaAdminDto.getPrice());
                    existingPharma.setPicture(pharmaAdminDto.getPicture());
                    existingPharma.setWholesalePrice(pharmaAdminDto.getWholesalePrice());
                    existingPharma.setBalanceInStock(pharmaAdminDto.getBalanceInStock());
                    Pharma updatePharma=pharmaRepo.save(existingPharma);
                    return pharmaAdminMapper.toDto(updatePharma);
                }).orElseThrow();
    }

    @Override
    public void deletePharmaById(Long id) {
        pharmaRepo.deleteById(id);
    }
}
