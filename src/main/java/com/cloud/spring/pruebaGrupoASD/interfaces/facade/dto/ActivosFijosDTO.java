/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cloud.spring.pruebaGrupoASD.interfaces.facade.dto;


/**
 *
 * @author Gabriel Calvo
 */
public class ActivosFijosDTO {

    private Long id;
    private String tipo;
    private String nombre;
    private String descripcion;
    private String serial;
    private String serialInventario;
    private Float peso;
    private Float alto;
    private Float largo;
    private Double valorCompra;
    private String  fechaCompra;
    private String fechaBaja;
    private String estado;
    private String color;

    public ActivosFijosDTO() {
    }

    public ActivosFijosDTO(Long id, String tipo, String nombre, String descripcion, String serial, String serialInventario, Float peso, Float alto, Float largo, Double valorCompra, String fechaCompra, String fechaBaja, String estado, String color) {
        this.id = id;
        this.tipo = tipo;
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

   

  

    public Long getId() {
        return id;
    }

    public String getTipo() {
        return tipo;
    }
    
    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getSerial() {
        return serial;
    }

    public String getSerialInventario() {
        return serialInventario;
    }

    public Float getPeso() {
        return peso;
    }

    public Float getAlto() {
        return alto;
    }

    public Float getLargo() {
        return largo;
    }

    public Double getValorCompra() {
        return valorCompra;
    }

    public String getFechaCompra() {
        return fechaCompra;
    }

    public String getFechaBaja() {
        return fechaBaja;
    }

    public String getEstado() {
        return estado;
    }

    public String getColor() {
        return color;
    }

}
