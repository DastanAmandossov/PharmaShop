package org.example.pharmashop.Api;

import lombok.RequiredArgsConstructor;
import org.example.pharmashop.Service.PharmaServiceDto;
import org.example.pharmashop.dto.PharmaAdminDto;
import org.example.pharmashop.dto.PharmaDto;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pharma")
@RequiredArgsConstructor
public class PharmaController {
    private final PharmaServiceDto pharmaServiceDto;

    @GetMapping(value = "/getAllPharma")
    public List<PharmaDto>getAllPharma(){
        return pharmaServiceDto.getAllPharma();
    }
    @PostMapping(value="/sendPharmaName")
    public PharmaDto getPharmaByName(@RequestBody PharmaDto pharmaDto){
        return pharmaServiceDto.getPharmaByName(pharmaDto.getName());
    }
    @PostMapping(value="/sendPharmaDesc")
    public PharmaDto getPharmaByDescription(@RequestBody PharmaDto pharmaDto){
        return pharmaServiceDto.getPharmaByDescription(pharmaDto.getDescription());
    }
    @PostMapping(value="/sendPharmaPrice")
    public PharmaDto getPharmaByPrice(@RequestBody PharmaDto pharmaDto){
        return pharmaServiceDto.getPharmaByPrice(pharmaDto.getPrice());
    }
    @PostMapping(value="/addPharma")
    public PharmaAdminDto addPharma(@RequestBody PharmaAdminDto pharmaAdminDto){
        return pharmaServiceDto.addPharma(pharmaAdminDto);
    }
    @PutMapping(value="/updatePharma")
    public PharmaAdminDto updatePharma(@RequestBody PharmaAdminDto pharmaAdminDto){
        return pharmaServiceDto.updatePharma(pharmaAdminDto);
    }
    @DeleteMapping(value = "/deletePharma/{id}")
    public void deletePharmaById(@PathVariable Long id){
        pharmaServiceDto.deletePharmaById(id);
    }

}
