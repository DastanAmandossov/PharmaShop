package org.example.pharmashop.mapper;

import org.example.pharmashop.Model.Pharma;
import org.example.pharmashop.dto.PharmaAdminDto;
import org.example.pharmashop.dto.PharmaDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PharmaAdminMapper {
    PharmaAdminDto toDto (Pharma pharma);
    Pharma toEntity(PharmaAdminDto pharmaAdminDto);
    List<PharmaDto> toDtoList(List<Pharma> pharms);
}
