package com.co.todosistemas.todosistemas.utilities.models;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Mensaje {

    private String codigoResultado;

    private String descripcionRespuesta;

    private Object result;

    private List<ValidationError> validaciones;

}
