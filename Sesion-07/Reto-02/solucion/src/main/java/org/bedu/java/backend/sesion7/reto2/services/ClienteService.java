package org.bedu.java.backend.sesion7.reto2.services;

import org.bedu.java.backend.sesion7.reto2.model.Cliente;

import java.util.Optional;

public interface ClienteService {
    Cliente guardaCliente(Cliente cliente);

    Optional<Cliente> obtenCliente(Long clienteId);
}