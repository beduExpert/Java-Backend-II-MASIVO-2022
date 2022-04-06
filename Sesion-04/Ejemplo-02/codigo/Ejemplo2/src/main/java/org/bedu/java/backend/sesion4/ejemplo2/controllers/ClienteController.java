package org.bedu.java.backend.sesion4.ejemplo2.controllers;

import org.bedu.java.backend.sesion4.ejemplo2.model.Cliente;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    @PostMapping
    public ResponseEntity<Void> creaCliente(@Valid @RequestBody Cliente cliente){
        return ResponseEntity.created(URI.create("")).build();
    }
}
