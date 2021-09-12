package com.sofkau.crudPerson.controlador;


import com.sofkau.crudPerson.entidades.Persona;
import com.sofkau.crudPerson.servicios.InterfazServiciosPersona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;


//contiene los métodos de acceso para consumir a servicios
//Identifica metodo, url, llegada de parametros y que servicio implementará
@RestController
@RequestMapping("api")
public class ControladorPersona {
    @Autowired
    private InterfazServiciosPersona servicio;

    //devuelve lista de personas. Es iterable porque devuelve datos tipo arreglo
    @GetMapping(value= "/personas")
    public Iterable<Persona>listarPersonas(){
        return servicio.listar();
    }

    //Guarda la persona
    @PostMapping(value="/guardarPersona")
    public Persona guardarPersona(@RequestBody Persona persona){
        return servicio.guardar(persona);
    }

    //Elimina la persona con cierto id de la base de datos
    @DeleteMapping(value="/eliminar/{id}")
    public void eliminarPersona(@PathVariable Integer id){ servicio.borrar(id);}

    // Devuelve la persona con determinado id
    @GetMapping(value="/persona/{id}")

    public Persona obtenerPorId(@PathVariable Integer id){ return servicio.listarId(id); }

    //Actualiza un registro
    @PutMapping(value="/actualizar/{id}")
    public  void actualizarPersona(@RequestBody Persona persona, @PathVariable Integer id){servicio.actualizar(persona, id);}



}
