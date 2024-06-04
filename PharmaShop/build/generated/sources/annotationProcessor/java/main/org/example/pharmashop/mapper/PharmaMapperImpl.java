package org.example.pharmashop.mapper;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.example.pharmashop.Model.Pharma;
import org.example.pharmashop.dto.PharmaDto;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-05-30T12:42:23+0500",
    comments = "version: 1.5.5.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.7.jar, environment: Java 21.0.2 (Oracle Corporation)"
)
@Component
public class PharmaMapperImpl implements PharmaMapper {

    @Override
    public PharmaDto toDto(Pharma pharma) {
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

    @Override
    public Pharma toEntity(PharmaDto pharmaDto) {
        if ( pharmaDto == null ) {
            return null;
        }

        Pharma pharma = new Pharma();

        pharma.setName( pharmaDto.getName() );
        pharma.setDescription( pharmaDto.getDescription() );
        pharma.setPrice( pharmaDto.getPrice() );
        pharma.setPicture( pharmaDto.getPicture() );

        return pharma;
    }

    @Override
    public List<PharmaDto> toDtoList(List<Pharma> pharms) {
        if ( pharms == null ) {
            return null;
        }

        List<PharmaDto> list = new ArrayList<PharmaDto>( pharms.size() );
        for ( Pharma pharma : pharms ) {
            list.add( toDto( pharma ) );
        }

        return list;
    }
}
