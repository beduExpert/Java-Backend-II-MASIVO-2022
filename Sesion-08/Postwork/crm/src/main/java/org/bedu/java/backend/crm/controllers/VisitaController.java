package org.bedu.java.backend.crm.controllers;

import lombok.RequiredArgsConstructor;
import org.bedu.java.backend.crm.model.Visita;
import org.bedu.java.backend.crm.services.VisitaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/visita")
@RequiredArgsConstructor
public class VisitaController {

    private final VisitaService visitaService;

    @GetMapping("/{visitaId}")
    public ResponseEntity<Visita> getVisita(@PathVariable Long visitaId){
        Optional<Visita> visitaDb = visitaService.obtenVisita(visitaId);

        if (visitaDb.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "El visita especificado no existe.");
        }

        return ResponseEntity.ok(visitaDb.get());
    }

    @GetMapping
    public ResponseEntity <List<Visita>> getVisitas(@RequestParam Long visitaId){
        return ResponseEntity.ok(visitaService.obtenVisitas());
    }

    @PostMapping
    public ResponseEntity<Void> creaVisita(@Valid @RequestBody Visita visita, @RequestParam Long visitaId){
        Visita visitaNuevo = visitaService.guardaVisita(visita);

        return ResponseEntity.created(URI.create(String.valueOf(visitaNuevo.getId()))).build();
    }

    @PutMapping("/{visitaId}")
    public ResponseEntity<Void> actualizaVisits(@PathVariable Long visitaId, @Valid @RequestBody Visita visita){

        visitaService.actualizaVisita(visita);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @DeleteMapping("/{visitaId}")
    public ResponseEntity<Void> eliminaVisita(@PathVariable Long visitaId){

        visitaService.eliminaVisita(visitaId);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
