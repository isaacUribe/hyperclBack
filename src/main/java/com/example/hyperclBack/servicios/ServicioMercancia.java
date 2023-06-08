package com.example.hyperclBack.servicios;

import com.example.hyperclBack.Repositorios.MercanciaRepositorio;
import com.example.hyperclBack.entidades.Mercancia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
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
        return null;
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
        return null;
    }

    @Override
    public boolean eleminar(Integer id) throws Exception {
        return false;
    }
}
