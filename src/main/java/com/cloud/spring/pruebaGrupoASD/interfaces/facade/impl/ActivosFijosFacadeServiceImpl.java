/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.cloud.spring.pruebaGrupoASD.interfaces.facade.impl;

import com.cloud.spring.pruebaGrupoASD.aplicacion.comun.ResponseUtil;
import com.cloud.spring.pruebaGrupoASD.interfaces.facade.ActivosFijosFacadeService;
import com.cloud.spring.pruebaGrupoASD.interfaces.facade.dto.ActivosFijosDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 *
 * @author Gabriel Calvo
 */
@Service
public class ActivosFijosFacadeServiceImpl implements ActivosFijosFacadeService{

    private final  Logger  LOGGER = LoggerFactory.getLogger(ActivosFijosFacadeServiceImpl.class);
    

    @Override
    public ResponseUtil listarTodosActivosFijos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ResponseUtil buscarActivosFijosById(Long Id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ResponseUtil guardarActivosFijos( ActivosFijosDTO activosFijosDTO) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ResponseUtil actulizarActivosFijos( ActivosFijosDTO activosFijosDTO) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

  
    
}
