package org.bedu.java.backend.sesion4.ejemplo1.controllers;

import org.bedu.java.backend.sesion4.ejemplo1.model.Cliente;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    @GetMapping("/{clienteId}")
    public ResponseEntity<Cliente> getCliente(@PathVariable long clienteId){
        if(clienteId > 10) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "El cliente con el id especificado no existe.");
        }

        if (clienteId > 5){
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "No tiene permiso para visualizar al cliente indicado.");
        }

        Cliente cliente = new Cliente();
        cliente.setId(clienteId);
        cliente.setNombre("Cliente");

        return ResponseEntity.ok(cliente);
    }
}
