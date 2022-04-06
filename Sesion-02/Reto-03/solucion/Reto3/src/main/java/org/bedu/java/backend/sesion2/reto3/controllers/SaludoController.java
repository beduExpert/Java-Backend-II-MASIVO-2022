package org.bedu.java.backend.sesion2.reto3.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SaludoController {

    @DeleteMapping("/saludo")
    public ResponseEntity saluda(@RequestParam String id){
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
