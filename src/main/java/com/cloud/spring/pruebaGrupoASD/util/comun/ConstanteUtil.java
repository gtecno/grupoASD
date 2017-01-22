/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cloud.spring.pruebaGrupoASD.aplicacion.comun;

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
    public static final int CODE_OK = HttpStatus.OK.value();
    public static final int CODE_ERROR = HttpStatus.CONFLICT.value();
    public static final int CODE_INTERNAL_ERROR = HttpStatus.INTERNAL_SERVER_ERROR.value();

    public static final String MSG_REGISTRO_EXITOSO = "Tu registro ha sido agregado.";
    public static final String MSG_UPDATE_EXITOSO = " Tu registro ha sido modificado.";

  
    public static final String FORMATO_FECHA_CON_HORA = "dd/MM/yyyy hh:mm:ss a";
}
