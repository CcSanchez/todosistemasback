package com.co.todosistemas.todosistemas.services.Implementations;

import com.co.todosistemas.todosistemas.jpa.entity.EmpleadosEntity;
import com.co.todosistemas.todosistemas.jpa.entity.EstadosEntity;
import com.co.todosistemas.todosistemas.jpa.repository.EmpleadosRepository;
import com.co.todosistemas.todosistemas.jpa.repository.EstadosRepository;
import com.co.todosistemas.todosistemas.services.IParametrosService;
import com.co.todosistemas.todosistemas.utilities.exceptions.BussinessException;
import com.co.todosistemas.todosistemas.utilities.models.ParametrosDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ParametrosService implements IParametrosService {

    @Autowired
    EstadosRepository estadosRepository;

    @Autowired
    EmpleadosRepository empleadosRepository;

    @Override
    public List<ParametrosDto> getEstados() throws BussinessException {
        List<ParametrosDto> listaParametros = new ArrayList<>();
        List<EstadosEntity> estadosEntity = estadosRepository.findAll();
        if (estadosEntity.isEmpty())
            throw new BussinessException("No se encontraron estados");

        for (EstadosEntity estados : estadosEntity) {
            listaParametros.add(new ParametrosDto(estados.getId(), estados.getNombre()));
        }
        return listaParametros;
    }

    @Override
    public List<ParametrosDto> getEmpleados() throws BussinessException {
        List<ParametrosDto> listaParametros = new ArrayList<>();
        List<EmpleadosEntity> empleadosEntities = empleadosRepository.findAll();
        if (empleadosEntities.isEmpty())
            throw new BussinessException("No se encontraron estados");

        for (EmpleadosEntity empleados : empleadosEntities) {
            listaParametros.add(new ParametrosDto(empleados.getId(), empleados.getNombres()));
        }
        return listaParametros;
    }
}
