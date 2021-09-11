package com.sofkau.crudPerson.servicios;

import com.sofkau.crudPerson.entidades.Persona;
import com.sofkau.crudPerson.repositorio.InterfazRepositorioPersona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiciosPersona implements InterfazServiciosPersona {

    @Autowired
    private InterfazRepositorioPersona data;

    @Override
    public List<Persona> listar() {
        return (List<Persona>) data.findAll();
    }

    @Override
    public Persona listarId(int id) {
        return null;
    }

    @Override
    public Persona guardar(Persona persona) {
        return data.save(persona);
    }

    @Override
    public void borrar(Integer id) { data.deleteById(id);  }

    @Override
    public Persona actualizar(Persona persona) {
        return null;
    }
}
