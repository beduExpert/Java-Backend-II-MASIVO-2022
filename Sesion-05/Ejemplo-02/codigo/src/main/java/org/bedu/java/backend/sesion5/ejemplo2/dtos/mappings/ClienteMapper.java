package org.bedu.java.backend.sesion5.ejemplo2.dtos.mappings;

import org.bedu.java.backend.sesion5.ejemplo2.dtos.ClienteDto;
import org.bedu.java.backend.sesion5.ejemplo2.model.Cliente;
import org.mapstruct.Mapper;

@Mapper
public interface ClienteMapper {
    Cliente clienteDtoToCliente(ClienteDto clienteDto);

    ClienteDto clienteToClienteDto(Cliente cliente);
}
