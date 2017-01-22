/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cloud.spring.pruebaGrupoASD.util.comun;

import com.cloud.spring.pruebaGrupoASD.interfaces.facade.impl.ActivosFijosFacadeServiceImpl;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author pc
 */
public class FechaConverUtil {

    private static final Logger LOGGER = LoggerFactory.getLogger(FechaConverUtil.class);

    public static Calendar convertStringToCalendar(String fechaString) {
        SimpleDateFormat curFormater = new SimpleDateFormat(ConstanteUtil.FORMATO_FECHA);
        Date dateObj = null;
        try {
            dateObj = curFormater.parse(fechaString);
        } catch (ParseException ex) {
            LOGGER.error(ex.toString());
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(dateObj);

        return calendar;
    }

}
