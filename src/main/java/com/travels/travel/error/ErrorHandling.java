package com.travels.travel.error;

public class ErrorHandling {

    public static String valueNotFound(String value, Integer id) {
        return String.format("%s con id: %d no existe", value, id);
    }

    public static String valueNotFound(String value, String id) {
        return String.format("%s con valor: %s no existe", value, id);
    }

    public static String valueUpdateError(String value) {
        return String.format("No se puede actualizar una %s sin id", value);
    }

}
