package com.co.todosistemas.todosistemas.jpa.entity;

import com.sun.istack.NotNull;
import lombok.Data;

import javax.persistence.*;

@Entity
@Cacheable(value = false)
@Data
@Table(name = "empleados")
public class EmpleadosEntity {

    @Id
    @NotNull
    @Column(name = "id")
    private Long id;

    @Column(name = "nombres")
    private String nombres;

    @Column(name = "tipodocumento")
    private String tipoDocumento;

    @Column(name = "numerodocumento")
    private Long numeroDocumento;
}
