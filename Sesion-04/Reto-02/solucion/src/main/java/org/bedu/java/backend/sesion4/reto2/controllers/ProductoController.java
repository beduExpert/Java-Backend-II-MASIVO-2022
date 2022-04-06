package org.bedu.java.backend.sesion4.reto2.controllers;

import org.apache.coyote.Response;
import org.bedu.java.backend.sesion4.reto2.model.Producto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
@RequestMapping("/producto")
public class ProductoController {
    @PostMapping
    public ResponseEntity<Void> agregaProducto(@RequestBody Producto producto){
        return ResponseEntity.created(URI.create("")).build();
    }
}
