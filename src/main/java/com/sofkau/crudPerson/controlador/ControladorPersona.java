package com.sofkau.crudPerson.controlador;


import com.sofkau.crudPerson.entidades.Persona;
import com.sofkau.crudPerson.servicios.InterfazServiciosPersona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


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

    @DeleteMapping(value="/eliminarPersona")
    public void eliminarPersona(@RequestBody Integer id){ servicio.borrar(id);}





}
