package com.example.hyperclBack.mappers;

import com.example.hyperclBack.dto.ZonaDto;
import com.example.hyperclBack.entidades.Zona;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ZonaMapper {
    @Mappings({
            @Mapping(source = "nombre", target = "nombre"),
            @Mapping(source = "volumenMaximo", target = "volumenMaximo")
    })
    ZonaDto toZonaDto (Zona zona);
    List<ZonaDto> toZonasDto (List<Zona> zonas);
}
