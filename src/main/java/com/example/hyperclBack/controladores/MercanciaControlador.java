package com.example.hyperclBack.controladores;

import com.example.hyperclBack.entidades.Mercancia;
import com.example.hyperclBack.servicios.ServicioMercancia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/v1/mercancia")
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
    @GetMapping("/{id}")
    public ResponseEntity<Mercancia> buscarPorId(@PathVariable Integer id){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(servicioMercancia.buscarPorId(id));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }
    @PutMapping("/{id}")
    public ResponseEntity<Mercancia> actualizar(@PathVariable Integer id, @RequestBody Mercancia mercancia){
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(servicioMercancia.actualizar(id, mercancia));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> eliminar(@PathVariable Integer id){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(servicioMercancia.eleminar(id));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }
}
