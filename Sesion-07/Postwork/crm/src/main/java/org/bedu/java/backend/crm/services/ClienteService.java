package org.bedu.java.backend.crm.services;


import lombok.RequiredArgsConstructor;
import org.bedu.java.backend.crm.controllers.mappers.ClienteMapper;
import org.bedu.java.backend.crm.model.Cliente;
import org.bedu.java.backend.crm.persistence.ClienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ClienteService {
    private final ClienteRepository repository;
    private final ClienteMapper mapper;

    public Cliente guardaCliente(Cliente cliente) {
        return mapper.clienteEntityToClienteModel(
                repository.save(mapper.clienteModelToClienteEntity(cliente))
        );
    }

    public List<Cliente> obtenClientes(){
        return repository.findAll().stream().map(cliente -> mapper.clienteEntityToClienteModel(cliente)).collect(Collectors.toList());
    }

    public Optional<Cliente> obtenCliente(long idCliente) {
        return repository.findById(idCliente)
                .map(cliente -> Optional.of(mapper.clienteEntityToClienteModel(cliente)))
                .orElse(Optional.empty());
    }

    public void eliminaCliente(long idcliente){
        repository.deleteById(idcliente);
    }

    public Cliente actualizaCliente(Cliente cliente){
        return mapper.clienteEntityToClienteModel(
                repository.save(mapper.clienteModelToClienteEntity(cliente))
        );
    }

    public long cuenteClientes(){
        return repository.count();
    }
}
