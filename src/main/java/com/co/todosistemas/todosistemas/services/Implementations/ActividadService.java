package com.co.todosistemas.todosistemas.services.Implementations;

import com.co.todosistemas.todosistemas.jpa.entity.ActividadesEntity;
import com.co.todosistemas.todosistemas.jpa.entity.EmpleadosEntity;
import com.co.todosistemas.todosistemas.jpa.entity.EstadosEntity;
import com.co.todosistemas.todosistemas.jpa.repository.ActividadesRepository;
import com.co.todosistemas.todosistemas.jpa.repository.EmpleadosRepository;
import com.co.todosistemas.todosistemas.jpa.repository.EstadosRepository;
import com.co.todosistemas.todosistemas.services.IActividadService;
import com.co.todosistemas.todosistemas.utilities.exceptions.BussinessException;
import com.co.todosistemas.todosistemas.utilities.models.ActividadDto;
import com.co.todosistemas.todosistemas.utilities.models.ActividadesInDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Slf4j
@Service
public class ActividadService implements IActividadService {

    private static SimpleDateFormat FORMAT = new SimpleDateFormat("dd-MM-yyyy HH:mm");

    @Autowired
    ActividadesRepository actividadesRepository;

    @Autowired
    EstadosRepository estadosRepository;

    @Autowired
    EmpleadosRepository empleadosRepository;

    @Override
    public List<ActividadDto> getActividades() throws BussinessException {
        try {
            List<ActividadDto> actividadDtos = new ArrayList<>();
            List<ActividadesEntity> actividadesEntities = actividadesRepository.findAll();
            if (!actividadesEntities.isEmpty()) {
                for (ActividadesEntity actividad : actividadesEntities) {
                    EstadosEntity estados = this.getEstado(actividad.getEstado());
                    EmpleadosEntity empleadosEntity = this.getEmpleado(actividad.getIdEmpleado());
                    actividadDtos.add(
                            new ActividadDto(
                                    actividad.getId(),
                                    actividad.getNombreActividad(),
                                    estados.getId(),
                                    estados.getNombre(),
                                    actividad.getFechaEstimada(),
                                    empleadosEntity.getId(),
                                    empleadosEntity.getNombres(),
                                    this.getDiasRetraso(actividad.getFechaEstimada())
                            ));
                }
            }
            return actividadDtos;
        } catch (Exception e) {
            throw new BussinessException(String.format("Error al obtener actividades %s", e.getMessage()));
        }
    }

    @Override
    public ActividadesEntity insertActividad(ActividadesInDto actividadesInDto) throws BussinessException {
        ActividadesEntity actividades = new ActividadesEntity();
        actividades.setNombreActividad(actividadesInDto.getNombreActividad());
        actividades.setEstado(actividadesInDto.getEstado());
        actividades.setFechaEstimada(actividadesInDto.getFechaIngreso());
        actividades.setIdEmpleado(actividadesInDto.getEmpleadoAsignado());
        return actividadesRepository.save(actividades);
    }

    @Override
    public ActividadesEntity updateActividad(Long id, ActividadesInDto actividadesInDto) throws BussinessException {
        ActividadesEntity actividades = actividadesRepository.findById(id).orElseThrow(() -> new BussinessException("Actividad no encontrada"));
        actividades.setNombreActividad(actividadesInDto.getNombreActividad());
        actividades.setEstado(actividadesInDto.getEstado());
        actividades.setFechaEstimada(actividadesInDto.getFechaIngreso());
        actividades.setIdEmpleado(actividadesInDto.getEmpleadoAsignado());
        return actividadesRepository.save(actividades);
    }

    @Override
    public void deleteActividad(Long id) throws BussinessException {
        try {
            actividadesRepository.deleteById(id);
        } catch (Exception e) {
            throw new BussinessException("Error al eliminar actividad");
        }

    }

    private EstadosEntity getEstado(Long idEstado) throws BussinessException {
        try {
            return estadosRepository.findById(idEstado).orElseThrow(() -> new BussinessException(""));
        } catch (Exception e) {
            throw new BussinessException("Error al obtener estado");
        }
    }

    private EmpleadosEntity getEmpleado(Long idEmpleado) throws BussinessException {
        try {
            return empleadosRepository.findById(idEmpleado).orElseThrow(() -> new BussinessException(""));
        } catch (Exception e) {
            throw new BussinessException("Error al obtener empleado");
        }
    }

    private Long getDiasRetraso(Date fechaEstimada) {
        int milisecondsByDay = 86400000;
        long diasRetraso = ((new Date().getTime() - fechaEstimada.getTime()) / milisecondsByDay);
        return diasRetraso >= 0 ? diasRetraso : 0;
    }
}
