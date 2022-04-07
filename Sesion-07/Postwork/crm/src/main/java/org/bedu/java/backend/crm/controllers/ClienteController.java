package org.bedu.java.backend.crm.controllers;

import lombok.RequiredArgsConstructor;
import org.bedu.java.backend.crm.model.Cliente;
import org.bedu.java.backend.crm.services.ClienteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cliente")
@RequiredArgsConstructor
public class ClienteController {

    private final ClienteService clienteService;

    @GetMapping("/{clienteId}")
    public ResponseEntity<Cliente> getCliente(@PathVariable Long clienteId) {

        Optional<Cliente> clienteDb = clienteService.obtenCliente(clienteId);

        if (clienteDb.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "El cliente especificado no existe.");
        }

        return ResponseEntity.ok(clienteDb.get());
    }

    @GetMapping
    public ResponseEntity<List<Cliente>> getClientes() {
        return ResponseEntity.ok(clienteService.obtenClientes());
    }

    @PostMapping
    public ResponseEntity<Void> creaCliente(@Valid @RequestBody Cliente cliente) {
        Cliente clienteNuevo = clienteService.guardaCliente(cliente);

        return ResponseEntity.created(URI.create(String.valueOf(clienteNuevo.getId()))).build();
    }

    @PutMapping("/{clienteId}")
    public ResponseEntity<Void> actualizaCliente(@PathVariable Long clienteId, @RequestBody @Valid Cliente cliente) {

        clienteService.actualizaCliente(cliente);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @DeleteMapping("/{clienteId}")
    public ResponseEntity<Void> eliminaCliente(@PathVariable Long clienteId) {
        clienteService.eliminaCliente(clienteId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
