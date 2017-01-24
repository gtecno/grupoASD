/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cloud.spring.pruebaGrupoASD.interfaces.facade.impl;

import com.cloud.spring.pruebaGrupoASD.aplicacion.ActivosFijosService;
import com.cloud.spring.pruebaGrupoASD.dominio.ActivosFijos;
import com.cloud.spring.pruebaGrupoASD.dominio.Tipo;
import com.cloud.spring.pruebaGrupoASD.util.comun.ResponseUtil;
import com.cloud.spring.pruebaGrupoASD.interfaces.facade.ActivosFijosFacadeService;
import com.cloud.spring.pruebaGrupoASD.interfaces.facade.dto.ActivosFijosDTO;
import com.cloud.spring.pruebaGrupoASD.util.ObjectMapperUtil;
import com.cloud.spring.pruebaGrupoASD.util.comun.ConstanteUtil;
import com.cloud.spring.pruebaGrupoASD.util.comun.FechaConverUtil;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
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
    private final ObjectMapper objectMapper = ObjectMapperUtil.getInstanceObjectMapper();
    ResponseUtil responseUtil;

    @Autowired
    private ActivosFijosService activosFijosService;

    @Override
    public ResponseUtil listarTodosActivosFijos() {
        List<ActivosFijos> listaActivoFijos = activosFijosService.listarTodosActivosFijos();
        return validarListaDeConsulta(listaActivoFijos);
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
                ActivosFijos activosFijosGuardado = activosFijosService.actulizarActivosFijos(assemble(activosFijosDTO, fechaCompra, fechaBaja));
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
        LOGGER.info("Update: ");
        responseUtil = new ResponseUtil();
        try {
            Calendar fechaCompra = FechaConverUtil.convertStringToCalendar(activosFijosDTO.getFechaCompra());
            Calendar fechaBaja = FechaConverUtil.convertStringToCalendar(activosFijosDTO.getFechaBaja());
            if (FechaConverUtil.compararFechasBajaMayor(fechaBaja, fechaCompra)) {
                ActivosFijos activosFijosGuardado = activosFijosService.guardarActivosFijos(assemble(activosFijosDTO, fechaCompra, fechaBaja));
                if (activosFijosGuardado != null) {
                    responseUtil.setMessage(ConstanteUtil.MSG_UPDATE_EXITOSO);
                    responseUtil.setTipo(ConstanteUtil.CODE_OK);
                    LOGGER.info("ActivoFijo Actulizado : ");
                } else {
                    responseUtil.setMessage(ConstanteUtil.MSG_ERROR_INTERNO);
                    responseUtil.setTipo(ConstanteUtil.CODE_INTERNAL_ERROR);
                    LOGGER.warn("ActivoFijo Presenta un error : ");
                }
            } else {
                responseUtil.setMessage(ConstanteUtil.MSG_ERROR_FECHAS_MAYOR);
                responseUtil.setTipo(ConstanteUtil.CODE_ERROR);
                LOGGER.warn("Fechas de baja no pueden ser mayores que las fechas de compra : ");
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
    public ResponseUtil buscarActivosFijosByParametro(Integer columna, String parametro) {
        LOGGER.info("Consultar por parametro: ");
        responseUtil = new ResponseUtil();
        if (columna != null) {
            //tipo enumeracion
            if (columna.equals(ConstanteUtil.CERO)) {
                return validarListaDeConsulta(activosFijosService.findByTipo(Tipo.valueOf(parametro)));
                //fecha de compra
            } else if (columna.equals(ConstanteUtil.UNO)) {
                return validarListaDeConsulta(activosFijosService.findByFechaCompra(FechaConverUtil.convertStringToCalendar(parametro)));
                //serial
            } else if (columna.equals(ConstanteUtil.DOS)) {
                return validarListaDeConsulta(activosFijosService.findBySerial(parametro));
            } else {
                LOGGER.warn(" ¡ Parametro Invalido !");
                responseUtil.setMessage(ConstanteUtil.COLUMNA_INVALIDAD);
                responseUtil.setTipo(ConstanteUtil.CODE_ERROR);
                return responseUtil;
            }
        } else {
            LOGGER.warn(" ¡ busqueda sin paramatero de  consulta !");
            responseUtil.setMessage(ConstanteUtil.COLUMNA_VACIA);
            responseUtil.setTipo(ConstanteUtil.CODE_ERROR);
            return responseUtil;

        }
    }

    private ActivosFijos assemble(ActivosFijosDTO activosFijosDTO, Calendar fechaCompra, Calendar fechaBaja) {
        ActivosFijos activosFijos = objectMapper.convertValue(activosFijosDTO, ActivosFijos.class);
        activosFijos.setFechaCompra(fechaCompra);
        activosFijos.setFechaBaja(fechaBaja);
        return activosFijos;
    }

    private List<JsonNode> assembleActivosFijosDTO(List<ActivosFijos> activosFijoses) {
        List<JsonNode> activosFijosDTOJsonNode = new ArrayList<>();
        ActivosFijosDTO activosFijosDTOAssemble;
        for (ActivosFijos activosFijos : activosFijoses) {
            activosFijosDTOAssemble = new ActivosFijosDTO(activosFijos.id(),
                    activosFijos.tipo() != null ? activosFijos.tipo().toString() : null,
                    activosFijos.nombre(),
                    activosFijos.descripcion(),
                    activosFijos.serial(),
                    activosFijos.serialInventario(),
                    activosFijos.peso(),
                    activosFijos.alto(),
                    activosFijos.largo(),
                    activosFijos.valorCompra(),
                    FechaConverUtil.convertirCalendarToString(activosFijos.fechaCompra()),
                    FechaConverUtil.convertirCalendarToString(activosFijos.fechaBaja()),
                    activosFijos.estado().toString(),
                    activosFijos.color());
            activosFijosDTOJsonNode.add(objectMapper.convertValue(activosFijosDTOAssemble, JsonNode.class));
        }
        return activosFijosDTOJsonNode;
    }

    private ResponseUtil validarListaDeConsulta(List<ActivosFijos> listaActivoFijos) {
        responseUtil = new ResponseUtil();
        if (listaActivoFijos.isEmpty()) {
            responseUtil.setMessage(ConstanteUtil.MSG_BUSQUEDA_SIN_COINCIDENCIAS);
            responseUtil.setTipo(ConstanteUtil.CODE_ERROR);
        } else {
            responseUtil.setResponseList(assembleActivosFijosDTO(listaActivoFijos));
            responseUtil.setMessage(ConstanteUtil.MSG_RESULTADOS);
            responseUtil.setTipo(ConstanteUtil.CODE_OK);
        }
        return responseUtil;
    }
}
