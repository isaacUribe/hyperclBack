package com.example.hyperclBack.controladores;

import com.example.hyperclBack.dto.MercanciaDto;
import com.example.hyperclBack.dto.MercanciaDtoError;
import com.example.hyperclBack.entidades.Mercancia;
import com.example.hyperclBack.servicios.ServicioMercancia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/api/v1/mercancia")
public class MercanciaControlador {
    @Autowired
    ServicioMercancia servicioMercancia;
    @PostMapping
    public ResponseEntity<MercanciaDto> registrar(@RequestBody Mercancia mercancia){
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(servicioMercancia.registrar(mercancia));
        }catch (Exception e){
            MercanciaDtoError mercanciaError = new MercanciaDtoError();
            mercanciaError.setMensaje(e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(mercanciaError);
        }
    }

    @GetMapping
    public ResponseEntity<List<MercanciaDto>> buscarTodos(){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(servicioMercancia.buscarTodos());
        }catch (Exception e){
            String mensaje = "Tenemos un error al momento de traer los datos" + e.getMessage();
            MercanciaDtoError mercanciaError = new MercanciaDtoError();
            mercanciaError.setMensaje(mensaje);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Arrays.asList(mercanciaError));
        }
    }
    @GetMapping("/{id}")
    public ResponseEntity<MercanciaDto> buscarPorId(@PathVariable Integer id){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(servicioMercancia.buscarPorId(id));
        } catch (Exception e) {
            MercanciaDtoError mercanciaError = new MercanciaDtoError();
            mercanciaError.setMensaje(e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(mercanciaError);
        }
    }
    @PutMapping("/{id}")
    public ResponseEntity<MercanciaDto> actualizar(@PathVariable Integer id, @RequestBody Mercancia mercancia){
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(servicioMercancia.actualizar(id, mercancia));
        }catch (Exception e){
            MercanciaDtoError mercanciaDtoError = new MercanciaDtoError();
            mercanciaDtoError.setMensaje(e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(mercanciaDtoError);
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> eliminar(@PathVariable Integer id){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(servicioMercancia.eleminar(id));
        }catch (Exception e){
            MercanciaDtoError mercanciaDtoError = new MercanciaDtoError();
            mercanciaDtoError.setMensaje(e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(false);
        }
    }
}
