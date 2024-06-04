package org.example.pharmashop.mapper;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.example.pharmashop.Model.Pharma;
import org.example.pharmashop.dto.PharmaAdminDto;
import org.example.pharmashop.dto.PharmaDto;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-05-30T15:32:02+0500",
    comments = "version: 1.5.5.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.7.jar, environment: Java 21.0.2 (Oracle Corporation)"
)
@Component
public class PharmaAdminMapperImpl implements PharmaAdminMapper {

    @Override
    public PharmaAdminDto toDto(Pharma pharma) {
        if ( pharma == null ) {
            return null;
        }

        PharmaAdminDto.PharmaAdminDtoBuilder pharmaAdminDto = PharmaAdminDto.builder();

        pharmaAdminDto.id( pharma.getId() );
        pharmaAdminDto.name( pharma.getName() );
        pharmaAdminDto.description( pharma.getDescription() );
        pharmaAdminDto.price( pharma.getPrice() );
        pharmaAdminDto.picture( pharma.getPicture() );
        pharmaAdminDto.wholesalePrice( pharma.getWholesalePrice() );
        pharmaAdminDto.balanceInStock( pharma.getBalanceInStock() );

        return pharmaAdminDto.build();
    }

    @Override
    public Pharma toEntity(PharmaAdminDto pharmaAdminDto) {
        if ( pharmaAdminDto == null ) {
            return null;
        }

        Pharma pharma = new Pharma();

        pharma.setId( pharmaAdminDto.getId() );
        pharma.setName( pharmaAdminDto.getName() );
        pharma.setDescription( pharmaAdminDto.getDescription() );
        pharma.setPrice( pharmaAdminDto.getPrice() );
        pharma.setPicture( pharmaAdminDto.getPicture() );
        pharma.setWholesalePrice( pharmaAdminDto.getWholesalePrice() );
        pharma.setBalanceInStock( pharmaAdminDto.getBalanceInStock() );

        return pharma;
    }

    @Override
    public List<PharmaDto> toDtoList(List<Pharma> pharms) {
        if ( pharms == null ) {
            return null;
        }

        List<PharmaDto> list = new ArrayList<PharmaDto>( pharms.size() );
        for ( Pharma pharma : pharms ) {
            list.add( pharmaToPharmaDto( pharma ) );
        }

        return list;
    }

    protected PharmaDto pharmaToPharmaDto(Pharma pharma) {
        if ( pharma == null ) {
            return null;
        }

        PharmaDto.PharmaDtoBuilder pharmaDto = PharmaDto.builder();

        pharmaDto.name( pharma.getName() );
        pharmaDto.description( pharma.getDescription() );
        pharmaDto.price( pharma.getPrice() );
        pharmaDto.picture( pharma.getPicture() );

        return pharmaDto.build();
    }
}
