package org.bedu.java.backend.crm.controllers.mappers;

import org.bedu.java.backend.crm.persistence.entities.Cliente;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ClienteMapper {
    Cliente clienteModelToClienteEntity(org.bedu.java.backend.crm.model.Cliente clienteModel);

    org.bedu.java.backend.crm.model.Cliente clienteEntityToClienteModel(Cliente cliente);
}
