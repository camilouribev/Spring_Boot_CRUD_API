package com.sofkau.crudPerson.servicios;

import com.sofkau.crudPerson.entidades.Persona;

import java.util.List;
import java.util.Optional;

public interface InterfazServiciosPersona {

    public List<Persona> listar();
    public Optional<Persona> listarId(Integer id);
    public Persona guardar(Persona persona);
    public void borrar(Integer id);
    public Persona actualizar(Persona persona, Integer id);

}
