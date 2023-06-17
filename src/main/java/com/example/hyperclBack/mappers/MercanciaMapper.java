package com.example.hyperclBack.mappers;

import com.example.hyperclBack.dto.MercanciaDto;
import com.example.hyperclBack.dto.MercanciaDtoError;
import com.example.hyperclBack.entidades.Mercancia;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MercanciaMapper {

    @Mapping(source = "mensaje",  target = "mensaje")
    MercanciaDtoError toMercanciaDtoError (Mercancia mercancia);


    @Mappings({
            @Mapping(source = "nombre",target = "nombre"),
            @Mapping(source = "descripcion",target = "descripcion"),
            @Mapping(source = "fecha",target = "fecha"),
            @Mapping(source = "motivoDevolucion",target = "motivoDevolucion"),
            @Mapping(source = "volumenOcupa",target = "volumenOcupa")
    })
    MercanciaDto toMercanciaDto (Mercancia mercancia);
    List<MercanciaDto> toMercanciaDto(List<Mercancia> mercancias);

}
