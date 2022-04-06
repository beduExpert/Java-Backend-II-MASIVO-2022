package org.bedu.java.backend.sesion5.reto1;

import org.bedu.java.backend.sesion5.reto1.model.Cliente;

public class Principal {
    public static void main(String[] args) {
        Cliente cliente = new Cliente();
        cliente.setDireccion("Dirección del cliente");
        cliente.setCorreoContacto("contacto@cliente.com");
        cliente.setNombre("Cliente importante");
        cliente.setNumeroEmpleados(100);

        System.out.printf("Datos del cliente %s", cliente);
    }
}
