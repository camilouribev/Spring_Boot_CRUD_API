package com.sofkau.crudPerson.controlador;


import com.sofkau.crudPerson.entidades.Persona;
import com.sofkau.crudPerson.servicios.InterfazServiciosPersona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.StreamingHttpOutputMessage;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

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
    @GetMapping(value = "/personas")
    public Iterable<Persona> listarPersonas() {
        return servicio.listar();
    }

    //Guarda la persona
    @PostMapping(value = "/guardarPersona")
    public Persona guardarPersona(@RequestBody Persona persona) {
        return servicio.guardar(persona);
    }

    //Elimina la persona con cierto id de la base de datos
    @DeleteMapping(value = "/eliminar/{id}")
    public ResponseEntity<Object> eliminarPersona(@PathVariable Integer id) {
        try {
            servicio.borrar(id);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().build();
    }

    // Devuelve la persona con determinado id
    @GetMapping(value = "/persona/{id}")

    public ResponseEntity<Persona> obtenerPorId(@PathVariable Integer id) {
        Optional<Persona> match = servicio.listarId(id);
        return match.isPresent() ? ResponseEntity.ok(match.get()) : ResponseEntity.notFound().build();

    }

    //Actualiza un registro
    @PutMapping(value = "/actualizar/{id}")
    public ResponseEntity<Persona> actualizarPersona(@RequestBody Persona persona, @PathVariable Integer id) {
        Persona actualizado = servicio.actualizar(persona, id);
        return actualizado == null ? ResponseEntity.notFound().build() : ResponseEntity.ok(actualizado);

    }


}
