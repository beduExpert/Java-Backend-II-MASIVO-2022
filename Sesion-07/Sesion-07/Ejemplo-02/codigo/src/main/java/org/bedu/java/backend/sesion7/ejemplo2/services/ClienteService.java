package org.bedu.java.backend.sesion7.ejemplo2.services;

import org.bedu.java.backend.sesion7.ejemplo2.model.Cliente;

import java.util.Optional;

public interface ClienteService {
    Cliente guardaCliente(Cliente cliente);

    Optional<Cliente> obtenCliente(Long clienteId);
}
