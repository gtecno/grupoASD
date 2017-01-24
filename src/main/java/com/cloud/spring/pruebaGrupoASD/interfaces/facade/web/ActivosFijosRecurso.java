/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cloud.spring.pruebaGrupoASD.interfaces.facade.web;

import com.cloud.spring.pruebaGrupoASD.util.comun.ResponseUtil;
import com.cloud.spring.pruebaGrupoASD.interfaces.facade.ActivosFijosFacadeService;
import com.cloud.spring.pruebaGrupoASD.interfaces.facade.dto.ActivosFijosDTO;
import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import static javax.ws.rs.core.MediaType.APPLICATION_JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Gabriel Calvo
 * 
 */
@RestController
@Produces(APPLICATION_JSON)
@Consumes(APPLICATION_JSON)
@RequestMapping("/ActivoFijo")
public class ActivosFijosRecurso {

    @Autowired
    private ActivosFijosFacadeService escanerFacadeService;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseUtil listarTodosActivosFijos() {
        return escanerFacadeService.listarTodosActivosFijos();
    }

    @RequestMapping(value = "findBy/{id}", method = RequestMethod.GET)
    public ResponseUtil buscarActivosFijosById(@PathVariable Long id) {
        return escanerFacadeService.buscarActivosFijosById(id);
    }
    
     @RequestMapping(value = "findByParametro/{columan}/{parametro}", method = RequestMethod.GET)
    public ResponseUtil buscarActivosFijosByParametro(@PathVariable Integer columna, @PathVariable String parametro) {
        return escanerFacadeService.buscarActivosFijosByParametro(columna,parametro);
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseUtil guardarActivosFijos(@RequestBody @Valid ActivosFijosDTO activosFijosDTO) {
        return escanerFacadeService.guardarActivosFijos(activosFijosDTO);
    }

    @RequestMapping(method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseUtil actulizarActivosFijos(@RequestBody @Valid ActivosFijosDTO activosFijosDTO) {
        return escanerFacadeService.actulizarActivosFijos(activosFijosDTO);
    }

}
