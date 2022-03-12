package com.co.todosistemas.todosistemas.services;

import com.co.todosistemas.todosistemas.utilities.exceptions.BussinessException;
import com.co.todosistemas.todosistemas.utilities.models.ParametrosDto;

import java.util.List;

public interface IParametrosService {

    List<ParametrosDto> getEstados() throws BussinessException;

    List<ParametrosDto> getEmpleados() throws BussinessException;

}
