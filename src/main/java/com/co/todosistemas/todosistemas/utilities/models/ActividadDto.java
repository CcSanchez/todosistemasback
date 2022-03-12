package com.co.todosistemas.todosistemas.utilities.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class ActividadDto {

    Long id;

    String nombreActividad;

    Long idEstado;

    String estado;

    @JsonFormat(pattern = "dd-MM-yyyy HH:mm", timezone = "America/Bogota")
    Date fecha;

    Long idEmpleado;

    String EmpleadoAsignado;

    Long diasDeRetrazo;

}
