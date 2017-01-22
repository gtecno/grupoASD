/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cloud.spring.pruebaGrupoASD.aplicacion;

import com.cloud.spring.pruebaGrupoASD.dominio.ActivosFijos;
import java.util.List;

/**
 *
 * @author Gabriel Calvo
 */
public interface ActivosFijosService {

    ActivosFijos guardarActivosFijos(ActivosFijos activosFijos);

    ActivosFijos actulizarActivosFijos(ActivosFijos activosFijos);

    List<ActivosFijos> listarTodosActivosFijos();
}
