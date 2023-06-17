package com.example.hyperclBack.controladores;

import com.example.hyperclBack.dto.MercanciaDto;
import com.example.hyperclBack.dto.MercanciaDtoError;
import com.example.hyperclBack.entidades.Mercancia;
import com.example.hyperclBack.servicios.ServicioMercanciaDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("api/v1/mercanciaDto")
public class MercanciaControladorError {
    @Autowired
    ServicioMercanciaDto servicioMercanciaDto;
    @PostMapping
    public ResponseEntity<MercanciaDto> registrar(@RequestBody Mercancia mercancia){
        try {
            MercanciaDto mercanciaDto = servicioMercanciaDto.registrar(mercancia);
            return ResponseEntity.status(HttpStatus.CREATED).body(mercanciaDto);
        }catch (Exception e){
            String mensaje = "Tenemos un error al momento de ingresar los datos " + e.getMessage();
            MercanciaDtoError mercanciaError = new MercanciaDtoError();
            mercanciaError.setMensaje(mensaje);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(mercanciaError);
        }
    }
}
