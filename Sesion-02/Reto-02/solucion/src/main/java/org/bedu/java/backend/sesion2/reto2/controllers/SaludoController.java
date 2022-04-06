package org.bedu.java.backend.sesion2.reto2.controllers;

import org.bedu.java.backend.sesion2.reto2.model.Saludo;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SaludoController {

    @PutMapping("/saludo")
    public Saludo saluda(@RequestBody Saludo saludo){
        return saludo;
    }
}
