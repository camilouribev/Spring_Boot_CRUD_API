package com.sofkau.crudPerson.entidades;

import javax.annotation.processing.Generated;
import javax.persistence.*;

@Entity //designa esta clase como entidad con atributos que se guardan en  db
@Table(name = "persona") // relaciona DB con atributos de esta clase, en tabla llamada persona
public class Persona {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nombre;
    private String edad;

    public Persona() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

}
