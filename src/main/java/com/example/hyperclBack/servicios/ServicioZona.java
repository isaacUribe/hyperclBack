package com.example.hyperclBack.servicios;

import com.example.hyperclBack.Repositorios.ZonaRepositorio;
import com.example.hyperclBack.dto.ZonaDto;
import com.example.hyperclBack.entidades.Zona;
import com.example.hyperclBack.mappers.ZonaMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.ExecutorService;

@Service
public class ServicioZona implements ServicioBase<Zona, ZonaDto> {
    @Autowired
    ZonaRepositorio zonaRepositorio;

    @Autowired
    ZonaMapper zonaMapper;
    @Override
    public List<ZonaDto> buscarTodos() throws Exception {
        try{
            return zonaMapper.toZonasDto(zonaRepositorio.findAll());
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public ZonaDto buscarPorId(Integer id) throws Exception {
        try{
            Optional<Zona> zonaOptional = zonaRepositorio.findById(id);
            if (zonaOptional.isPresent()){
                return zonaMapper.toZonaDto(zonaOptional.get());
            }else {
                throw new Exception("Zona no encontrada");
            }
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public ZonaDto registrar(Zona datosARegistrar) throws Exception {
        try{
            return zonaMapper.toZonaDto(zonaRepositorio.save(datosARegistrar));
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public ZonaDto actualizar(Integer id, Zona datosActualizar) throws Exception {
        try {
            Optional<Zona> zonaOptional = zonaRepositorio.findById(id);
            if (zonaOptional.isPresent()){
                Zona zonaExistente = zonaOptional.get();
                zonaExistente.setNombre(datosActualizar.getNombre());
                zonaExistente.setVolumenMaximo(datosActualizar.getVolumenMaximo());
                Zona zonaActualizado = zonaRepositorio.save(zonaExistente);
                return zonaMapper.toZonaDto(zonaActualizado);
            }else {
                throw new Exception("zona no encontrada");
            }
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public boolean eleminar(Integer id) throws Exception {
        try {
            Optional<Zona> zonaOptional = zonaRepositorio.findById(id);
            if (zonaOptional.isPresent()){
                zonaRepositorio.deleteById(id);
                return true;
            }else {
                throw new Exception("zona no encontrada");
            }
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
}
