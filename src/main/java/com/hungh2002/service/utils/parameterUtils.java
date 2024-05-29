package com.hungh2002.service.utils;

/**
 * ParameterUtils
 */
public class parameterUtils {

    public static String getParam(String param) {
        String urlParamString = "";
        if (param == null) {
            urlParamString = "";
        } else {
            urlParamString = param;
        }
        return urlParamString;
    }
}
