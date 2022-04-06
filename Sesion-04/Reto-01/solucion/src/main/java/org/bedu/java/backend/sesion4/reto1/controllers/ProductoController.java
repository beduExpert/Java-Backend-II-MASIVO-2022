package org.bedu.java.backend.sesion4.reto1.controllers;

import org.bedu.java.backend.sesion4.reto1.model.Producto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.net.URI;

@RestController
@RequestMapping("/producto")
public class ProductoController {
    @PostMapping
    public ResponseEntity<Void> creaProducto(@RequestBody Producto producto){
        if(producto.getId() > 0){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "El cliente con el id especificado no existe.");
        }

        if(producto.getPrecio() >= 1 && !producto.getNombre().isBlank()){
            return ResponseEntity.created(URI.create("")).build();
        }

        throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Los parámetros proporcionados no son correctos.");
    }
}
