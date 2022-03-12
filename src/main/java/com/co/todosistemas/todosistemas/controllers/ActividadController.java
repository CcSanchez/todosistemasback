package com.co.todosistemas.todosistemas.controllers;

import com.co.todosistemas.todosistemas.jpa.entity.ActividadesEntity;
import com.co.todosistemas.todosistemas.services.IActividadService;
import com.co.todosistemas.todosistemas.utilities.Constantes;
import com.co.todosistemas.todosistemas.utilities.exceptions.BussinessException;
import com.co.todosistemas.todosistemas.utilities.models.ActividadDto;
import com.co.todosistemas.todosistemas.utilities.models.ActividadesInDto;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.WebApplicationContext;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(Constantes.ACTIVIDADES)
@Scope(value = WebApplicationContext.SCOPE_REQUEST)
@Slf4j
public class ActividadController {

    @Autowired
    IActividadService actividadService;

    @ApiOperation(value = "Servicio que retorna las actividades.")
    @GetMapping
    public List<ActividadDto> getActividades() throws BussinessException {
        return actividadService.getActividades();
    }

    @ApiOperation(value = "Servicio que retorna las actividades.")
    @PostMapping(consumes = "application/json", produces = "application/json")
    public ActividadesEntity postActividades(@RequestBody ActividadesInDto actividadDto) throws BussinessException {
        log.info(actividadDto.toString());
        return actividadService.insertActividad(actividadDto);
    }

    @ApiOperation(value = "Servicio que actualiza la actividad.")
    @PutMapping("/{id}")
    public ActividadesEntity putActividades(@PathVariable Long id, @RequestBody ActividadesInDto actividades) throws BussinessException {
        return actividadService.updateActividad(id, actividades);
    }

    @ApiOperation(value = "Servicio que elimna la actividad.")
    @DeleteMapping(value = "{id}")
    public ResponseEntity<Map<String, String>> deletePost(@PathVariable Long id) throws

            BussinessException {
        log.info(String.format("Id actividad a eliminar %s", id));
        actividadService.deleteActividad(id);
        Map<String, String> response = new HashMap<>();
        response.put("Resultado", String.format("Registro eliminado correctamente id %s", id));
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
