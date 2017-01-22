/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.cloud.spring.pruebaGrupoASD.util;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

/**
 *
 * @author Gabriel Calvo
 */
public class ObjectMapperUtil {
    
    private static ObjectMapper mapperObject;

    public static ObjectMapper getInstanceObjectMapper() {
        if (mapperObject == null) {
            mapperObject = new ObjectMapper();
            mapperObject.setSerializationInclusion(Include.ALWAYS);
            mapperObject.disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);
            mapperObject.setVisibilityChecker(mapperObject.getSerializationConfig().getDefaultVisibilityChecker()
                .withFieldVisibility(JsonAutoDetect.Visibility.ANY)
                .withGetterVisibility(JsonAutoDetect.Visibility.NONE)
                .withSetterVisibility(JsonAutoDetect.Visibility.NONE)
                .withCreatorVisibility(JsonAutoDetect.Visibility.DEFAULT));
        }
        return mapperObject;
    }
}
