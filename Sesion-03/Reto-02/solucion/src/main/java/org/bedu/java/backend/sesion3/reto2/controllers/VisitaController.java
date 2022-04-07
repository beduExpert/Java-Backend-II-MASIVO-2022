package org.bedu.java.backend.sesion3.reto2.controllers;

import org.bedu.java.backend.sesion3.reto2.model.Visita;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
public class VisitaController {

    @PostMapping("/visita")
    public ResponseEntity<Void> creaVisita(@RequestBody Visita visita){
        System.out.println("El cliente es " + visita.getCliente().getNombre());

        return ResponseEntity.created(URI.create("1")).build();
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(NullPointerException.class)
    public String manejaNullPointerException(NullPointerException npe){
        return "Ocurrió un error en el servidor al procesar la petición";
    }
}
