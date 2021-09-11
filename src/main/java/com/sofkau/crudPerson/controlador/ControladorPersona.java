package com.sofkau.crudPerson.controlador;


import com.sofkau.crudPerson.entidades.Persona;
import com.sofkau.crudPerson.servicios.InterfazServiciosPersona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


//contiene los métodos de acceso para consumir a servicios
//Identifica metodo, url, llegada de parametros y que servicio implementará
@RestController
@RequestMapping("api")
public class ControladorPersona {
    @Autowired
    private InterfazServiciosPersona servicio;

    //devuelve lista de personas. Es iterable porque devuelve datos tipo arreglo
    @GetMapping(value= "listarPersonas")
    public Iterable<Persona>listarPersonas(){
        return servicio.listar();
    }



}