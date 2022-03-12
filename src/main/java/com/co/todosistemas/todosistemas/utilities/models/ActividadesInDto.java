package com.co.todosistemas.todosistemas.utilities.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
public class ActividadesInDto {

    @JsonProperty("nombreActividad")
    @ApiModelProperty(example = "Prueba actividad")
    String nombreActividad;

    @JsonProperty("estado")
    @ApiModelProperty(example = "1")
    Long estado;

    @JsonProperty("fecha")
    @JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss", timezone = "America/Bogota")
    @ApiModelProperty(example = "05-03-2022 12:00:00")
    Date fecha;

    @JsonProperty("fechaIngreso")
    @ApiModelProperty(example = "05-03-2022 12:00:00")
    Date fechaIngreso;

    @ApiModelProperty(example = "2")
    @JsonProperty("empleadoAsignado")
    Long empleadoAsignado;

}
