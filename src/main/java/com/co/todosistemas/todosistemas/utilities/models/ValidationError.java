package com.co.todosistemas.todosistemas.utilities.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ValidationError {

    private String campo;

    private String mensaje;
}
