/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cloud.spring.pruebaGrupoASD.aplicacion.impl;

import com.cloud.spring.pruebaGrupoASD.aplicacion.ActivosFijosService;
import com.cloud.spring.pruebaGrupoASD.dominio.ActivosFijos;
import com.cloud.spring.pruebaGrupoASD.dominio.ActivosFijosRepository;
import com.cloud.spring.pruebaGrupoASD.dominio.Tipo;
import java.util.Calendar;
import java.util.List;
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

    @Override
    public List<ActivosFijos> listarTodosActivosFijos() {
        return (List<ActivosFijos>) activosFijosRepository.findAll();
    }

    @Override
    public List<ActivosFijos> findByTipo(Tipo tipo) {
        return activosFijosRepository.findByTipo(tipo);
    }

    @Override
    public List<ActivosFijos> findByFechaCompra(Calendar fechaCompra) {
        return activosFijosRepository.findByFechaCompra(fechaCompra);
    }

    @Override
    public List<ActivosFijos> findBySerial(String serial) {
        return activosFijosRepository.findBySerialEndingWith(serial);
    }

}
