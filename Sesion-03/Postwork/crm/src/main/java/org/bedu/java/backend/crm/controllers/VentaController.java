package org.bedu.java.backend.crm.controllers;

import org.bedu.java.backend.crm.model.Venta;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/venta")
public class VentaController {
    @GetMapping("/{ventaId}")
    public ResponseEntity<Venta> getVenta(@PathVariable Long ventaId){
        return ResponseEntity.ok(new Venta());
    }

    @GetMapping
    public ResponseEntity <List<Venta>> getVentas(@Valid @RequestParam Long clienteId){
        return ResponseEntity.ok(new ArrayList<>());
    }

    @PostMapping
    public ResponseEntity<Void> creaVenta(@Valid @RequestBody Venta venta, @RequestParam Long clienteId){
        return ResponseEntity.created(URI.create("")).build();
    }

    @PutMapping("/{ventaId}")
    public ResponseEntity<Void> actualizaVenta(@PathVariable Long ventaId, @Valid @RequestBody Venta venta){
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @DeleteMapping("/{ventaId}")
    public ResponseEntity<Void> eliminaVenta(@PathVariable Long ventaId){
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
