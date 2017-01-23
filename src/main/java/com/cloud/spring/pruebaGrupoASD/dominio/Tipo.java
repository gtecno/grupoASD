/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cloud.spring.pruebaGrupoASD.dominio;

/**
 *
 * @author Gabriel Calvo
 */
public enum Tipo {

    INMUEBLE("INMUEBLE"), MAQUINARIA("MAQUINARIA"), OFICINA("OFICINA");
    
    private String valor;

    private Tipo(String valor) {
        this.valor = valor;
    }

    private Tipo() {
    }

    public String getValor() {
        return valor;
    }
}
