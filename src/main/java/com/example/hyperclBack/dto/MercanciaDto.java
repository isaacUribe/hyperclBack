package com.example.hyperclBack.dto;

import java.time.LocalDate;

public class MercanciaDto {

    private String nombre;
    private String descripcion;
    private LocalDate fecha;
    private String motivoDevolucion;
    private double volumenOcupa;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getMotivoDevolucion() {
        return motivoDevolucion;
    }

    public void setMotivoDevolucion(String motivoDevolucion) {
        this.motivoDevolucion = motivoDevolucion;
    }

    public double getVolumenOcupa() {
        return volumenOcupa;
    }

    public void setVolumenOcupa(double volumenOcupa) {
        this.volumenOcupa = volumenOcupa;
    }
}
