package com.example.hyperclBack.entidades;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Mercancia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_mercancia")
    private Integer idMercancia;

    private String nombre;

    private String descripcion;
    private LocalDate fecha;
    @Column(name = "motivo_devolucion")
    private String motivoDevolucion;
    @Column(name = "volumen_ocupa")
    private double volumenOcupa;
    @ManyToOne
    @JoinColumn(name = "id_zona")
    @JsonManagedReference
    private Zona zona;
    @Transient
    private String mensaje;

    public Integer getIdMercancia() {
        return idMercancia;
    }

    public void setIdMercancia(Integer idMercancia) {
        this.idMercancia = idMercancia;
    }

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

    public Zona getZona() {
        return zona;
    }

    public void setZona(Zona zona) {
        this.zona = zona;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
}
