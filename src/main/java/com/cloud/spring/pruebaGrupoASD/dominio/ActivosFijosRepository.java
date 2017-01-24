/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.cloud.spring.pruebaGrupoASD.dominio;

import java.util.Calendar;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Gabriel Calvo
 */
public interface ActivosFijosRepository extends CrudRepository<ActivosFijos, Long> {

    public List<ActivosFijos> findByTipo(Tipo tipo);

    public List<ActivosFijos> findByFechaCompra(Calendar fechaCompra);

    public List<ActivosFijos> findBySerialEndingWith(String parametro);
    
}
