package com.example.hyperclBack.servicios;

import com.example.hyperclBack.Repositorios.MercanciaRepositorio;
import com.example.hyperclBack.Repositorios.ZonaRepositorio;
import com.example.hyperclBack.dto.MercanciaDto;
import com.example.hyperclBack.entidades.Mercancia;
import com.example.hyperclBack.entidades.Zona;
import com.example.hyperclBack.mappers.MercanciaMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class ServicioMercanciaDto {
    @Autowired
    MercanciaRepositorio mercanciaRepositorio;

    @Autowired
    ZonaRepositorio zonaRepositorio;

    @Autowired
    MercanciaMapper mercanciaMapper;

    public MercanciaDto registrar(Mercancia datosARegistrar) throws Exception {
        try {
            int idZona = datosARegistrar.getZona().getIdZona();
            Optional<Zona> zonaOptional = zonaRepositorio.findById(idZona);
            Zona zona = zonaOptional.get();
            if (zona.getVolumenMaximo()>datosARegistrar.getVolumenOcupa()){
                zona.setVolumenMaximo(zona.getVolumenMaximo()-datosARegistrar.getVolumenOcupa());
                zonaRepositorio.save(zona);
            }else {
                throw new Exception("No hay espacio en la zona");
            }
            mercanciaRepositorio.save(datosARegistrar);
            MercanciaDto mercanciaDto = mercanciaMapper.toMercanciaDto(datosARegistrar);
            return  mercanciaDto;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }}
}
