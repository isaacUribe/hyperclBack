package com.example.hyperclBack.servicios;

import java.util.List;

public interface ServicioBase<E, DTO> {
    public List<DTO> buscarTodos() throws Exception;
    public DTO buscarPorId(Integer id) throws Exception;
    public DTO registrar (E datosARegistrar) throws Exception;
    public DTO actualizar (Integer id, E datosActualizar) throws Exception;
    public boolean eleminar(Integer id) throws Exception;
}
