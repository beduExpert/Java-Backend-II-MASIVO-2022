package org.bedu.java.backend.sesion3.reto1.controllers;

import org.bedu.java.backend.sesion3.reto1.model.Producto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
public class ProductoController {

    @PostMapping("/producto")
    public ResponseEntity<Void> creaProducto(@Valid @RequestBody Producto producto){
        return ResponseEntity.ok().build();
    }
}
