package com.example.hyperclBack.entidades;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Zona {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_zona")
    private Integer idZona;
    private String nombre;
    @Column(name = "volumen_maximo")
    private double volumenMaximo;
    @OneToMany(mappedBy = "zona", cascade = CascadeType.ALL)
    @JsonBackReference
    private List<Mercancia> mercancia;

    @Transient
    private String mensajeError;

    public Integer getIdZona() {
        return idZona;
    }

    public void setIdZona(Integer idZona) {
        this.idZona = idZona;
    }

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

    public List<Mercancia> getMercancia() {
        return mercancia;
    }

    public void setMercancia(List<Mercancia> mercancia) {
        this.mercancia = mercancia;
    }

    public String getMensajeError() {
        return mensajeError;
    }

    public void setMensajeError(String mensajeError) {
        this.mensajeError = mensajeError;
    }
}
