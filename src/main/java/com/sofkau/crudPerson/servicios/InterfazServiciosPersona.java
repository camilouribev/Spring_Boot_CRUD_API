package com.sofkau.crudPerson.servicios;

import com.sofkau.crudPerson.entidades.Persona;
import org.springframework.context.annotation.Bean;

import java.util.List;
public interface InterfazServiciosPersona {

    public List<Persona> listar();
    public Persona listarId(int id);
    public Persona guardar(Persona persona);
    public void borrar(int id);
    public Persona actualizar(Persona persona);

}
