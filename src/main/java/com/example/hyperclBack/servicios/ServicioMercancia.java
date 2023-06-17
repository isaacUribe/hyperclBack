package com.example.hyperclBack.servicios;

import com.example.hyperclBack.Repositorios.MercanciaRepositorio;
import com.example.hyperclBack.Repositorios.ZonaRepositorio;
import com.example.hyperclBack.dto.MercanciaDto;
import com.example.hyperclBack.entidades.Mercancia;
import com.example.hyperclBack.entidades.Zona;
import com.example.hyperclBack.mappers.MercanciaMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServicioMercancia implements ServicioBase<Mercancia, MercanciaDto>{
    @Autowired
    MercanciaRepositorio mercanciaRepositorio;

    @Autowired
    ZonaRepositorio zonaRepositorio;

    @Autowired
    MercanciaMapper mercanciaMapper;

    @Override
    public List<MercanciaDto> buscarTodos() throws Exception {
        try{
            return mercanciaMapper.toMercanciaDto(mercanciaRepositorio.findAll());
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public MercanciaDto buscarPorId(Integer id) throws Exception {
        try {
            Optional<Mercancia> mercanciaOptional = mercanciaRepositorio.findById(id);
            if (mercanciaOptional.isPresent()){
                return mercanciaMapper.toMercanciaDto(mercanciaOptional.get());
            }else {
                throw new Exception("Mercancia no encontrada");
            }
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
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


    @Override
    public MercanciaDto actualizar(Integer id, Mercancia datosActualizar) throws Exception {
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
                return mercanciaMapper.toMercanciaDto(mercanciaActualizada);
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
