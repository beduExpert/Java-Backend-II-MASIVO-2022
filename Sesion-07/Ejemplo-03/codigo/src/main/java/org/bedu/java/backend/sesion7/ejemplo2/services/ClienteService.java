package org.bedu.java.backend.sesion7.ejemplo2.services;

import lombok.RequiredArgsConstructor;
import org.bedu.java.backend.sesion7.ejemplo2.model.Cliente;
import org.bedu.java.backend.sesion7.ejemplo2.persistence.ClienteRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClienteService {

    private final ClienteRepository clienteRepository;

    public Cliente guardaCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    public Optional<Cliente> obtenCliente(Long clienteId) {
        return clienteRepository.findById(clienteId);
    }
}
