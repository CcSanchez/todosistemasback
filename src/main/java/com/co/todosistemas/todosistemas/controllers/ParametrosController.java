package com.co.todosistemas.todosistemas.controllers;

import com.co.todosistemas.todosistemas.services.IParametrosService;
import com.co.todosistemas.todosistemas.utilities.Constantes;
import com.co.todosistemas.todosistemas.utilities.exceptions.BussinessException;
import com.co.todosistemas.todosistemas.utilities.models.ParametrosDto;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.WebApplicationContext;

import java.util.List;

@RestController
@RequestMapping(Constantes.PARAMETROS)
@Scope(value = WebApplicationContext.SCOPE_REQUEST)
@Slf4j
public class ParametrosController {

    @Autowired
    IParametrosService parametrosService;

    @ApiOperation(value = "Servicio que retorna los posibles estados de la actividad")
    @GetMapping(value = Constantes.ESTADOS)
    public List<ParametrosDto> getEstados() throws BussinessException {
        log.info("Obteniendo estados");
        return parametrosService.getEstados();
    }

    @ApiOperation(value = "Servicio que retorna los empleados")
    @GetMapping(value = Constantes.EMPLEADOS)
    public List<ParametrosDto> getEmpleados() throws BussinessException {
        log.info("Obteniendo empleados");
        return parametrosService.getEmpleados();
    }
}
