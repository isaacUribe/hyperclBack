package com.example.hyperclBack.controladores;

import com.example.hyperclBack.entidades.Zona;
import com.example.hyperclBack.servicios.ServicioZona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("api/v1/zona")
public class ZonaControlador {
    @Autowired
    ServicioZona servicioZona;

    @PostMapping
    public ResponseEntity<Zona> registrar(@RequestBody Zona zona){
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(servicioZona.registrar(zona));

        }catch (Exception e){
            String mensaje = "Tenemos un error al ingresar los datos" + e.getMessage();
            Zona zonaError = new Zona();
            zonaError.setMensajeError(mensaje);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(zonaError);
        }
    }

    @GetMapping
    public ResponseEntity<List<Zona>> buscarTodos (){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(servicioZona.buscarTodos());
        }catch (Exception e){
            String mensaje = "Tenemos un error al momento de traer los datos" + e.getMessage();
            Zona zonaError = new Zona();
            zonaError.setMensajeError(mensaje);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Arrays.asList(zonaError));
        }
    }

}
