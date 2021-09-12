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
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Persona listarId(Integer id) {
        Optional<Persona> match = data.findById(id);

        if(match.isEmpty()){
            throw new NoSuchElementException( id + " no existe en la base de datos  .");
        }
        return match.get();


    }

    @Override
    public Persona guardar(Persona persona) {
        return data.save(persona);
    }

    @Override
    public void borrar(Integer id) { data.deleteById(id);  }

    @Override
    public Persona actualizar(Persona persona, Integer id) {
        Persona aSerModificado = data.findById(id).orElseThrow(() -> new EntityNotFoundException(String.valueOf(id)));
        aSerModificado.setEdad(persona.getEdad());
        aSerModificado.setNombre(persona.getNombre());
        return data.save(aSerModificado);
    }


}
