/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cloud.spring.pruebaGrupoASD.interfaces.facade.impl;

import com.cloud.spring.pruebaGrupoASD.aplicacion.ActivosFijosService;
import com.cloud.spring.pruebaGrupoASD.dominio.ActivosFijos;
import com.cloud.spring.pruebaGrupoASD.util.comun.ResponseUtil;
import com.cloud.spring.pruebaGrupoASD.interfaces.facade.ActivosFijosFacadeService;
import com.cloud.spring.pruebaGrupoASD.interfaces.facade.dto.ActivosFijosDTO;
import com.cloud.spring.pruebaGrupoASD.util.ObjectMapperUtil;
import com.cloud.spring.pruebaGrupoASD.util.comun.ConstanteUtil;
import com.cloud.spring.pruebaGrupoASD.util.comun.FechaConverUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Calendar;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

/**
 *
 * @author Gabriel Calvo
 */
@Service
public class ActivosFijosFacadeServiceImpl implements ActivosFijosFacadeService {

    private final Logger LOGGER = LoggerFactory.getLogger(ActivosFijosFacadeServiceImpl.class);
    private ObjectMapper objectMapper = ObjectMapperUtil.getInstanceObjectMapper();
    ResponseUtil responseUtil;

    @Autowired
    private ActivosFijosService activosFijosService;

    @Override
    public ResponseUtil listarTodosActivosFijos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ResponseUtil buscarActivosFijosById(Long Id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ResponseUtil guardarActivosFijos(ActivosFijosDTO activosFijosDTO) {
        LOGGER.info("Save : ");
        responseUtil = new ResponseUtil();
        try {
            Calendar fechaCompra = FechaConverUtil.convertStringToCalendar(activosFijosDTO.getFechaCompra());
            Calendar fechaBaja = FechaConverUtil.convertStringToCalendar(activosFijosDTO.getFechaBaja());
            if (FechaConverUtil.compararFechasBajaMayor(fechaBaja, fechaCompra)) {
                ActivosFijos activosFijosGuardado = activosFijosService.guardarActivosFijos(assemble(activosFijosDTO, fechaCompra, fechaBaja));
                if (activosFijosGuardado != null) {
                    responseUtil.setMessage(ConstanteUtil.MSG_REGISTRO_EXITOSO);
                    responseUtil.setTipo(ConstanteUtil.CODE_OK);
                    LOGGER.info("ActivoFijo Guardado : ");
                } else {
                    responseUtil.setMessage(ConstanteUtil.MSG_ERROR_INTERNO);
                    responseUtil.setTipo(ConstanteUtil.CODE_INTERNAL_ERROR);
                    LOGGER.warn("ActivoFijo Presenta un error : ");
                }
            } else {
                responseUtil.setMessage(ConstanteUtil.MSG_ERROR_FECHAS_MAYOR);
                responseUtil.setTipo(ConstanteUtil.CODE_ERROR);
                LOGGER.warn("ActivoFijo Presenta un error : ");
            }
        } catch (DataIntegrityViolationException e) {
            LOGGER.error(ConstanteUtil.MSG_ERROR_INTERNO.concat(e.getCause().getCause().getMessage()));
            responseUtil.setMessage(ConstanteUtil.MSG_ERROR_INTERNO.concat(e.getCause().getCause().getMessage()));
            responseUtil.setTipo(ConstanteUtil.CODE_INTERNAL_ERROR);
            return responseUtil;
        }
        return responseUtil;
    }

    @Override
    public ResponseUtil actulizarActivosFijos(ActivosFijosDTO activosFijosDTO) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private ActivosFijos assemble(ActivosFijosDTO activosFijosDTO, Calendar fechaCompra, Calendar fechaBaja) {
        ActivosFijos activosFijos = objectMapper.convertValue(activosFijosDTO, ActivosFijos.class);
        activosFijos.setFechaCompra(fechaCompra);
        activosFijos.setFechaBaja(fechaBaja);
        return activosFijos;
    }

}
