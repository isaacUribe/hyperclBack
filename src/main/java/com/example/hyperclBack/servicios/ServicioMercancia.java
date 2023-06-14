package com.example.hyperclBack.servicios;

import com.example.hyperclBack.Repositorios.MercanciaRepositorio;
import com.example.hyperclBack.entidades.Mercancia;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.event.MouseWheelEvent;
import java.util.List;
import java.util.Optional;

@Service
public class ServicioMercancia implements ServicioBase<Mercancia>{
    @Autowired
    MercanciaRepositorio mercanciaRepositorio;

    @Override
    public List<Mercancia> buscarTodos() throws Exception {
        try{
            return mercanciaRepositorio.findAll();
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Mercancia buscarPorId(Integer id) throws Exception {
        try {
            Optional<Mercancia> mercanciaOptional = mercanciaRepositorio.findById(id);
            if (mercanciaOptional.isPresent()){
                return mercanciaOptional.get();
            }else {
                throw new Exception("Mercancia no encontrada");
            }
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Mercancia registrar(Mercancia datosARegistrar) throws Exception {
        try {
            return  mercanciaRepositorio.save(datosARegistrar);
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }}

    @Override
    public Mercancia actualizar(Integer id, Mercancia datosActualizar) throws Exception {
        try{
            Optional<Mercancia>mercanciaOptional =mercanciaRepositorio.findById(id);
            if(mercanciaOptional.isPresent()){
                Mercancia mercanciaPresente=mercanciaOptional.get();
                mercanciaPresente.setNombre(datosActualizar.getNombre());
                mercanciaPresente.setDescripcion(datosActualizar.getDescripcion());
                mercanciaPresente.setFecha(datosActualizar.getFecha());
                mercanciaPresente.setMotivoDevolucion(datosActualizar.getMotivoDevolucion());
                mercanciaPresente.setVolumenOcupa(datosActualizar.getVolumenOcupa());

                Mercancia mercanciaActualizada=mercanciaRepositorio.save(mercanciaPresente);
                return mercanciaActualizada;
            }else{
                throw new Exception("Usuario no encontrado");
            }
        }catch(Exception error){
            throw new Exception(error.getMessage());
        }
    }


    @Override
    public boolean eleminar(Integer id) throws Exception {
        try {
            Optional<Mercancia> mercanciaOptional = mercanciaRepositorio.findById(id);
            if (mercanciaOptional.isPresent()){
                mercanciaRepositorio.deleteById(id);
                return true;
            }else {
                throw new Exception("Mercancia no encontrada");
            }
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }

    }
}
