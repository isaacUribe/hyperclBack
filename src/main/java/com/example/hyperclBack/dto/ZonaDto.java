package com.example.hyperclBack.dto;

import java.util.List;

public class ZonaDto {
    private String nombre;
    private double volumenMaximo;

    private List<MercanciaDto> mercancias;
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getVolumenMaximo() {
        return volumenMaximo;
    }

    public void setVolumenMaximo(double volumenMaximo) {
        this.volumenMaximo = volumenMaximo;
    }

    public List<MercanciaDto> getMercancias() {
        return mercancias;
    }

    public void setMercancias(List<MercanciaDto> mercancias) {
        this.mercancias = mercancias;
    }
}
