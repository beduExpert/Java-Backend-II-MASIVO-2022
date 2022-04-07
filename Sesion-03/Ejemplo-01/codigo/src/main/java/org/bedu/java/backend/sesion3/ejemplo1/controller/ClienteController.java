package org.bedu.java.backend.sesion3.ejemplo1.controller;

import org.bedu.java.backend.sesion3.ejemplo1.model.Cliente;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.net.URI;

@RestController
public class ClienteController {
    @PostMapping("/cliente")
    public ResponseEntity<Void> creaCliente(@Valid @RequestBody Cliente cliente){
        System.out.println(cliente.getNombre());
        return ResponseEntity.created(URI.create("1")).build();
    }
}
