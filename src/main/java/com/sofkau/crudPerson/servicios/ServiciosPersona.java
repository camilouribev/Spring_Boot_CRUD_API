package com.sofkau.crudPerson.servicios;

import com.sofkau.crudPerson.entidades.Persona;
import com.sofkau.crudPerson.repositorio.InterfazRepositorioPersona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class ServiciosPersona implements InterfazServiciosPersona {

    @Autowired
    private InterfazRepositorioPersona data;

    @Override
    public List<Persona> listar() {
        return (List<Persona>) data.findAll();
    }

    @Override
    public Optional<Persona> listarId(Integer id) {
        return data.findById(id);
    }

    @Override
    public Persona guardar(Persona persona) {
        return data.save(persona);
    }

    @Override
    public void borrar(Integer id) { data.deleteById(id);  }

    @Override
    public Persona actualizar(Persona persona, Integer id) {
        Optional<Persona> aSerModificado = data.findById(id);
        try{
            Persona actualizado = aSerModificado.get();
            actualizado.setEdad(persona.getEdad());
            actualizado.setNombre(persona.getNombre());
            data.save(actualizado);
            return actualizado;
        }catch(Exception e){return null;}


    }


}
