package org.bedu.java.backend.crm.controllers;

import org.bedu.java.backend.crm.model.Etapa;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/etapa")
public class EtapaController {

    @GetMapping("/{etapaId}")
    public ResponseEntity<Etapa> getEtapa(@PathVariable Long etapaId){
        return ResponseEntity.ok(new Etapa());
    }

    @GetMapping
    public ResponseEntity <List<Etapa>> getEtapas(@RequestParam Long clienteId){
        return ResponseEntity.ok(new ArrayList<>());
    }

    @PostMapping
    public ResponseEntity<Void> creaEtapa(@RequestBody Etapa etapa, @RequestParam Long clienteId){
        return ResponseEntity.created(URI.create("")).build();
    }

    @PutMapping("/{etapaId}")
    public ResponseEntity<Void> actualizaEtapa(@PathVariable Long etapaId, @RequestBody Etapa etapa){
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @DeleteMapping("/{etapaId}")
    public ResponseEntity<Void> eliminaEtapa(@PathVariable Long etapaId){
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
