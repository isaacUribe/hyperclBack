package com.example.hyperclBack.servicios;

import com.example.hyperclBack.Repositorios.ZonaRepositorio;
import com.example.hyperclBack.entidades.Zona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
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
        return null;
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
        return null;
    }

    @Override
    public boolean eleminar(Integer id) throws Exception {
        return false;
    }
}
