package com.venturicg.poc.repository.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "pais")
public class PaisEntity implements Serializable {
    @Id
    private String id;
    private String nombre;

    // Constructores, getters y setters

    public PaisEntity() {
    }

    public PaisEntity(String id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}

