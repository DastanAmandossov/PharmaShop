package org.example.pharmashop.Service;

import org.example.pharmashop.dto.PharmaAdminDto;
import org.example.pharmashop.dto.PharmaDto;

import java.util.List;

public interface PharmaServiceDto {


    List<PharmaDto>getAllPharma();

    PharmaDto getPharmaByName(String name);

    PharmaDto getPharmaByDescription(String description);
    PharmaDto getPharmaByPrice(Integer price);

    PharmaAdminDto addPharma(PharmaAdminDto pharmaAdminDto);
    PharmaAdminDto updatePharma(PharmaAdminDto pharmaAdminDto);
    void deletePharmaById(Long id);
}
