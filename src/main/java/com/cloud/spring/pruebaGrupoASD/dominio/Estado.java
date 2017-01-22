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
public enum Estado {
    
//    (activo,	dado	de	baja,	en	reparación,	disponible,	asignado)

    ACTIVO("ACTIVO"), DISPONIBLE("DISPONIBLE"),REPARACION("EN REPARCION"), ASIGNADO("ASIGNADO"), BAJA("DADO DE BAJA");

    private String valor;

    private Estado(String valor) {
        this.valor = valor;
    }

    private Estado() {
    }

}
