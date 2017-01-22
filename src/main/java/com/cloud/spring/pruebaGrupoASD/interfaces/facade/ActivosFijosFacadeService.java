/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cloud.spring.pruebaGrupoASD.interfaces.facade;

import com.cloud.spring.pruebaGrupoASD.util.comun.ResponseUtil;
import com.cloud.spring.pruebaGrupoASD.interfaces.facade.dto.ActivosFijosDTO;

/**
 *
 * @author Gabriel Calvo
 */
public interface ActivosFijosFacadeService {

   ResponseUtil listarTodosActivosFijos();

   ResponseUtil buscarActivosFijosById(Long Id);

   ResponseUtil guardarActivosFijos(ActivosFijosDTO activosFijosDTO);

   ResponseUtil actulizarActivosFijos(ActivosFijosDTO activosFijosDTO);

}
