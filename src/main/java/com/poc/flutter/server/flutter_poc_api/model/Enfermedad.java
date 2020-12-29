package com.poc.flutter.server.flutter_poc_api.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum Enfermedad {

    DIABETES(1, "Diabetes"),
    OBESIDAD(2, "Obesidad"),
    BLA(3, "Bla");

    @JsonProperty("id")
    Integer id;
    @JsonProperty("descripcion")
    String descripcion;

    Enfermedad(int id, String descripcion) {
        this.id = id;
        this.descripcion = descripcion;
    }


    @JsonCreator
    public static Enfermedad deserialize(@JsonProperty("id") Integer code,
                                     @JsonProperty("descripcion") String descripcion) {
        for (Enfermedad enfermedad : Enfermedad.values()) {
            if (enfermedad.id.equals(code) && enfermedad.descripcion.equals(descripcion)) {
                return enfermedad;
            }
        }

        return null;
    }
}
