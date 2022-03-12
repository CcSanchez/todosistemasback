package com.co.todosistemas.todosistemas.services;

import com.co.todosistemas.todosistemas.jpa.entity.ActividadesEntity;
import com.co.todosistemas.todosistemas.utilities.exceptions.BussinessException;
import com.co.todosistemas.todosistemas.utilities.models.ActividadDto;
import com.co.todosistemas.todosistemas.utilities.models.ActividadesInDto;

import java.util.List;

public interface IActividadService {


    List<ActividadDto> getActividades() throws BussinessException;

    ActividadesEntity insertActividad(ActividadesInDto actividadesInDto) throws BussinessException;

    ActividadesEntity updateActividad(Long id, ActividadesInDto actividades) throws BussinessException;

    void deleteActividad(Long id) throws BussinessException;
}
