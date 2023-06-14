package com.example.hyperclBack.servicios;

import com.example.hyperclBack.Repositorios.ZonaRepositorio;
import com.example.hyperclBack.entidades.Zona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.ExecutorService;

@Service
public class ServicioZona implements ServicioBase<Zona>{
    @Autowired
    ZonaRepositorio zonaRepositorio;
    @Override
    public List<Zona> buscarTodos() throws Exception {
        try{
            return zonaRepositorio.findAll();
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Zona buscarPorId(Integer id) throws Exception {
        try{
            Optional<Zona> zonaOptional = zonaRepositorio.findById(id);
            if (zonaOptional.isPresent()){
                return zonaOptional.get();
            }else {
                throw new Exception("Zona no encontrada");
            }
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Zona registrar(Zona datosARegistrar) throws Exception {
        try{
            return zonaRepositorio.save(datosARegistrar);
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Zona actualizar(Integer id, Zona datosActualizar) throws Exception {
        try {
            Optional<Zona> zonaOptional = zonaRepositorio.findById(id);
            if (zonaOptional.isPresent()){
                Zona zonaExistente = zonaOptional.get();
                zonaExistente.setNombre(datosActualizar.getNombre());
                zonaExistente.setVolumenMaximo(datosActualizar.getVolumenMaximo());
                Zona zonaActualizado = zonaRepositorio.save(zonaExistente);
                return zonaActualizado;
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
