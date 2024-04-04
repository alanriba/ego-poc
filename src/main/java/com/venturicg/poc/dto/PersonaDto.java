package com.venturicg.poc.dto;

import com.venturicg.poc.repository.entity.PaisEntity;

public class PersonaDto {

    private String nombre;
    private String apellido;
    private PaisDTO pais;

    // Constructores, getters y setters
    public PersonaDto() {
        // TODO document why this constructor is empty
    }

    // Constructor con todos los campos, getters y setters
    public PersonaDto(String nombre, String apellido, PaisDTO pais) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.pais = pais;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public PaisDTO getPais() {
        return pais;
    }

    public void setPais(PaisDTO pais) {
        this.pais = pais;
    }
}
