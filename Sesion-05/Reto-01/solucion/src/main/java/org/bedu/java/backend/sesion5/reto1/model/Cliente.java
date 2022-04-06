package org.bedu.java.backend.sesion5.reto1.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
public class Cliente {
    private long id;
    private String nombre;
    private String correoContacto;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private int numeroEmpleados;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private String direccion;
}
