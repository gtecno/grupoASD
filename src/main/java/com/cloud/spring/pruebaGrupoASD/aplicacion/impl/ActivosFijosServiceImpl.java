/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cloud.spring.pruebaGrupoASD.aplicacion.impl;

import com.cloud.spring.pruebaGrupoASD.aplicacion.ActivosFijosService;
import com.cloud.spring.pruebaGrupoASD.dominio.ActivosFijos;
import com.cloud.spring.pruebaGrupoASD.dominio.ActivosFijosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Gabriel Calvo
 */
@Service
public class ActivosFijosServiceImpl implements ActivosFijosService {

    @Autowired
    private ActivosFijosRepository activosFijosRepository;

    @Override
    public ActivosFijos guardarActivosFijos(ActivosFijos activosFijos) {
        return activosFijosRepository.save(activosFijos);
    }

    @Override
    public ActivosFijos actulizarActivosFijos(ActivosFijos activosFijos) {
        return activosFijosRepository.save(activosFijos);
    }

}
