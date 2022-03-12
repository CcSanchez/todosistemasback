package com.co.todosistemas.todosistemas.jpa.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sun.istack.NotNull;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Cacheable(value = false)
@Table(name = "actividades")
@Data
public class ActividadesEntity {

    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nombreactividad")
    private String nombreActividad;

    @NotNull
    @Column(name = "estado")
    private Long estado;

    @JsonFormat(pattern="dd-MM-yyyy HH:mm",timezone="America/Bogota")
    @Column(name = "fechaestimada")
    private Date fechaEstimada;

    @Column(name = "idempleado")
    private Long idEmpleado;

}
