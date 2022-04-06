package org.bedu.java.backend.crm.controllers;

import org.bedu.java.backend.crm.model.Visita;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

public class VisitaController {

    @GetMapping("/{visitaId}")
    public ResponseEntity<Visita> getVisita(@PathVariable Long visitaId){
        return ResponseEntity.ok(new Visita());
    }

    @GetMapping
    public ResponseEntity <List<Visita>> getVisitas(@RequestParam Long clienteId){
        return ResponseEntity.ok(new ArrayList<>());
    }

    @PostMapping
    public ResponseEntity<Void> creaVisita(@RequestBody Visita visita, @RequestParam Long clienteId){
        return ResponseEntity.created(URI.create("")).build();
    }

    @PutMapping("/{visitaId}")
    public ResponseEntity<Void> actualizaVisits(@PathVariable Long visitaId, @RequestBody Visita visita){
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @DeleteMapping("/{visitaId}")
    public ResponseEntity<Void> eliminaVisita(@PathVariable Long visitaId){
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
