/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cloud.spring.pruebaGrupoASD.dominio;

import java.util.Calendar;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Gabriel Calvo
 */
@Entity
public class ActivosFijos {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nombre;
    private String descripcion;
    private String serial;
    private String serialInventario;
    private Float peso;
    private Float alto;
    private Float largo;
    private Double valorCompra;
    @Temporal(TemporalType.DATE)
    private Calendar fechaCompra;
    @Temporal(TemporalType.DATE)
    private Calendar fechaBaja;
    @Enumerated(EnumType.STRING)
    private Estado estado;
    private String color;

    public ActivosFijos() {
    }

    public ActivosFijos(Long id, String nombre, String descripcion, String serial, String serialInventario, Float peso, Float alto, Float largo, Double valorCompra, Calendar fechaCompra, Calendar fechaBaja, Estado estado, String color) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.serial = serial;
        this.serialInventario = serialInventario;
        this.peso = peso;
        this.alto = alto;
        this.largo = largo;
        this.valorCompra = valorCompra;
        this.fechaCompra = fechaCompra;
        this.fechaBaja = fechaBaja;
        this.estado = estado;
        this.color = color;
    }

    public Long id() {
        return id;
    }

    public String nombre() {
        return nombre;
    }

    public String descripcion() {
        return descripcion;
    }

    public String serial() {
        return serial;
    }

    public String serialInventario() {
        return serialInventario;
    }

    public Float peso() {
        return peso;
    }

    public Float alto() {
        return alto;
    }

    public Float largo() {
        return largo;
    }

    public Double valorCompra() {
        return valorCompra;
    }

    public Calendar fechaCompra() {
        return fechaCompra;
    }

    public Calendar fechaBaja() {
        return fechaBaja;
    }

    public Estado estado() {
        return estado;
    }

    public String color() {
        return color;
    }
}
