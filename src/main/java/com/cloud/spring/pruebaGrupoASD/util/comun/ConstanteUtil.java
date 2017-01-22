/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cloud.spring.pruebaGrupoASD.util.comun;

import org.springframework.http.HttpStatus;

/**
 *
 * @author Gabriel Calvo
 */
public class ConstanteUtil {

    /**
     *
     * CODIGOS DE RESPUESTA
     */
    
    public static final int CODE_OK = 200;
    public static final int CODE_FALTANTES= 400;
    public static final int CODE_ERROR = 404;
    public static final int CODE_INTERNAL_ERROR = 500;

    public static final String MSG_REGISTRO_EXITOSO = "Tu registro ha sido agregado.";
    public static final String MSG_UPDATE_EXITOSO = " Tu registro ha sido modificado.";

  
    public static final String FORMATO_FECHA = "dd/MM/yyyy";
    public static final String FORMATO_FECHA_CON_HORA = "dd/MM/yyyy hh:mm:ss a";
}
