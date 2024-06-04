package org.example.pharmashop.mapper;

import org.example.pharmashop.Model.Pharma;
import org.example.pharmashop.dto.PharmaDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PharmaMapper {
    PharmaDto toDto (Pharma pharma);
    Pharma toEntity (PharmaDto pharmaDto);
    List<PharmaDto> toDtoList(List<Pharma> pharms);
}
