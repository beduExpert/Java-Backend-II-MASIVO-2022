package org.bedu.java.backend.sesion5.ejemplo2;

import org.bedu.java.backend.sesion5.ejemplo2.dtos.ClienteDto;
import org.bedu.java.backend.sesion5.ejemplo2.dtos.mappings.ClienteMapper;
import org.bedu.java.backend.sesion5.ejemplo2.dtos.mappings.ClienteMapperImpl;
import org.bedu.java.backend.sesion5.ejemplo2.model.Cliente;

public class Principal {
    public static void main(String[] args) {


        ClienteDto clienteDto = new ClienteDto();
        clienteDto.setDireccion("Direccion DTO");
        clienteDto.setNombre("Nombre cliente dto");
        clienteDto.setNumeroEmpleados("10");

        ClienteMapper clienteMapper = new ClienteMapperImpl();

        Cliente clienteMapeado = clienteMapper.clienteDtoToCliente(clienteDto);

        System.out.printf("Cliente, dirección: %s%n", clienteMapeado.getDireccion());
        System.out.printf("Cliente nombre %s%n", clienteMapeado.getNombre());
        System.out.printf("Cliente numero empleados %d%n%n", clienteMapeado.getNumeroEmpleados());


        Cliente cliente = new Cliente();
        cliente.setId(1L);
        cliente.setCorreoContacto("correo@cliente.com");
        cliente.setDireccion("Dirección cliente");
        cliente.setNombre("Nombre cliente");
        cliente.setNumeroEmpleados(10);

        ClienteDto clienteDtoMapeado = clienteMapper.clienteToClienteDto(cliente);
        System.out.printf("ClienteDto, dirección: %s%n", clienteDtoMapeado.getDireccion());
        System.out.printf("ClienteDto nombre %s%n", clienteDtoMapeado.getNombre());
        System.out.printf("ClienteDto numero empleados %s%n", clienteDtoMapeado.getNumeroEmpleados());
    }
}
