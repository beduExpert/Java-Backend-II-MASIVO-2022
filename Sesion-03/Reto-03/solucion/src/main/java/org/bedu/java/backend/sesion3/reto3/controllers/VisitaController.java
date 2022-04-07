package org.bedu.java.backend.sesion3.reto3.controllers;

import org.bedu.java.backend.sesion3.reto3.model.Visita;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
public class VisitaController {
    @PostMapping("/visita")
    public ResponseEntity<Void> creaVisita(@RequestBody Visita visita){
        System.out.println("El cliente es " + visita.getCliente().getNombre());

        return ResponseEntity.created(URI.create("1")).build();
    }
}
