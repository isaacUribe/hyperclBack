package com.example.hyperclBack.controladores;

import com.example.hyperclBack.entidades.Mercancia;
import com.example.hyperclBack.servicios.ServicioMercancia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class MercanciaControlador {
    @Autowired
    ServicioMercancia servicioMercancia;
    @PostMapping
    public ResponseEntity<Mercancia> registrar(@RequestBody Mercancia mercancia){
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(servicioMercancia.registrar(mercancia));
        }catch (Exception e){
            String mensaje = "Tenemos un error al momento de ingresar los datos" + e.getMessage();
            Mercancia mercanciaError = new Mercancia();
            mercanciaError.setMensaje(mensaje);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(mercanciaError);
        }
    }

    @GetMapping
    public ResponseEntity<List<Mercancia>> buscarTodos(){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(servicioMercancia.buscarTodos());
        }catch (Exception e){
            String mensaje = "Tenemos un error al momento de traer los datos" + e.getMessage();
            Mercancia mercanciaError = new Mercancia();
            mercanciaError.setMensaje(mensaje);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Arrays.asList(mercanciaError));
        }
    }
}
