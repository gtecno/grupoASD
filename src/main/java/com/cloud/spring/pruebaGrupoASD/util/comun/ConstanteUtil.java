/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cloud.spring.pruebaGrupoASD.util.comun;

import java.util.Calendar;

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
    public static final int CODE_FALTANTES = 400;
    public static final int CODE_ERROR = 404;
    public static final int CODE_INTERNAL_ERROR = 500;

    /*
     * MENSAJES DE PROCESOS EXITOS RESPUESTA 200 CODE_OK
     */
    public static final String MSG_REGISTRO_EXITOSO = "Tu registro ha sido agregado.";
    public static final String MSG_UPDATE_EXITOSO = " Tu registro ha sido modificado.";

    /*
     *
     * MENSAJE DE ERROR INTERNO DEL SISTEMA  CODE_INTERNAL_ERROR 
     */
    public static String MSG_ERROR_INTERNO = "Se ha producido un error en el sistema  a acontinuación se detalle el error:  ";
    /*
     *
     * MENSAJE DE ERROR DE FECHAS 
     */
    public static String MSG_ERROR_FECHAS_MAYOR = "La fecha de baja no puede ser mayor que la fecha de compra  ";

    public static final String FORMATO_FECHA = "yyyy-MM-dd";
    public static final String FORMATO_FECHA_CON_HORA = "dd/MM/yyyy hh:mm:ss a";

    public static final Calendar FECHA_ACTUAL = Calendar.getInstance();
    public static final int CERO = 0;

    /*
     *
     * MENSAJE DE BUSQUEDA SIN COINCIDENCIAS
     */
     public static String MSG_BUSQUEDA_SIN_COINCIDENCIAS= "La búsqueda no arrojó resultados";
     public static String MSG_RESULTADOS = "La búsqueda arrojó el siguiente resultado";
}
