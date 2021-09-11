package com.sofkau.crudPerson.controlador;


import com.sofkau.crudPerson.entidades.Persona;
import com.sofkau.crudPerson.servicios.InterfazServiciosPersona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


//contiene los métodos de acceso para consumir a servicios
//Identifica metodo, url, llegada de parametros y que servicio implementará
@RestController
@RequestMapping("api")
public class ControladorPersona {
    @Autowired
    private InterfazServiciosPersona servicio;

    //devuelve lista de personas. Es iterable porque devuelve datos tipo arreglo
    @GetMapping(value= "/listarPersonas")
    public Iterable<Persona>listarPersonas(){
        return servicio.listar();
    }

    //Guarda la persona
    @PostMapping(value="/guardarPersona")
    public Persona guardarPersona(@RequestBody Persona persona){
        return servicio.guardar(persona);
    }

    //Elimina la persona con cierto id de la base de datos
    @DeleteMapping(value="/eliminarPersona")
    public void eliminarPersona(@RequestBody Integer id){ servicio.borrar(id);}

    // Devuelve la persona con determinado id
    @GetMapping(value="/listarPorId")
    public Optional<Persona> obtenerPorId(@RequestBody Integer id){ return servicio.listarId(id); }



}
