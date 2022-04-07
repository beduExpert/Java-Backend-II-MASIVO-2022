package org.bedu.java.backend.crm.controllers;

import lombok.RequiredArgsConstructor;
import org.bedu.java.backend.crm.model.Producto;
import org.bedu.java.backend.crm.services.ProductoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/producto")
@RequiredArgsConstructor
public class ProductoController {

    private final ProductoService productoService;

    @GetMapping("/{productoId}")
    public ResponseEntity<Producto> getProducto(@PathVariable Long productoId){

        Optional<Producto> productoDb = productoService.obtenProducto(productoId);

        if (productoDb.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "El producto especificado no existe.");
        }

        return ResponseEntity.ok(productoDb.get());
    }

    @GetMapping
    public ResponseEntity <List<Producto>> getProductos(){
        return ResponseEntity.ok(productoService.obtenProductos());
    }

    @PostMapping
    public ResponseEntity<Void> creaProducto(@Valid @RequestBody Producto producto){
        Producto productoNuevo = productoService.guardaProducto(producto);

        return ResponseEntity.created(URI.create(String.valueOf(productoNuevo.getId()))).build();
    }

    @PutMapping("/{productoId}")
    public ResponseEntity<Void> actualizaProducto(@PathVariable Long productoId, @Valid @RequestBody Producto producto){

        productoService.actualizaProducto(producto);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @DeleteMapping("/{productoId}")
    public ResponseEntity<Void> eliminaProducto(@PathVariable Long productoId){

        productoService.eliminaProducto(productoId);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
