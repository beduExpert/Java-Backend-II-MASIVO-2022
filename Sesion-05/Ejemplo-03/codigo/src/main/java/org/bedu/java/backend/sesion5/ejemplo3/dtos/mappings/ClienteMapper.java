package org.bedu.java.backend.sesion5.ejemplo3.dtos.mappings;

import org.bedu.java.backend.sesion5.ejemplo3.dtos.ClienteDto;
import org.bedu.java.backend.sesion5.ejemplo3.model.Cliente;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ClienteMapper {

    Cliente clienteDtoToCliente(ClienteDto clienteDto);

    ClienteDto clienteToClienteDto(Cliente cliente);
}
