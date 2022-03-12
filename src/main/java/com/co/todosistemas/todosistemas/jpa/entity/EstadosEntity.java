package com.co.todosistemas.todosistemas.jpa.entity;

import com.sun.istack.NotNull;
import lombok.Data;

import javax.persistence.*;

@Entity
@Cacheable(value = false)
@Table(name = "estados")
@Data
public class EstadosEntity {

    @Id
    @NotNull
    @Column(name = "id")
    private Long id;

    @Column(name = "nombre")
    private String nombre;
}
