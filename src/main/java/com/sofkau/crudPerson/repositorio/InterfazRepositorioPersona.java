package com.sofkau.crudPerson.repositorio;

import com.sofkau.crudPerson.entidades.Persona;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.Period;

@Repository
public interface InterfazRepositorioPersona extends CrudRepository <Persona, Integer > {
}
