package org.bedu.java.backend.sesion3.ejemplo1.model;

import javax.validation.constraints.*;

public class Cliente {
    @PositiveOrZero(message = "El identificador no puede ser un número negativo")
    private long id;

    @NotEmpty(message = "El nombre del cliente no puede estar vacío")
    @Size(min = 5, max = 30, message = "El nombre del cliente debe tener al menos 5 letras y ser menor a 30")
    private String nombre;

    @Email
    private String correoContacto;

    @Min(value = 10, message = "Los clientes con menos de 10 empleados no son válidos")
    @Max(value = 10000, message = "Los clientes con más de 10000 empleados no son válidos")
    private String numeroEmpleados;

    @NotBlank(message = "Se debe proporcionar una dirección")
    private String direccion;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreoContacto() {
        return correoContacto;
    }

    public void setCorreoContacto(String correoContacto) {
        this.correoContacto = correoContacto;
    }

    public String getNumeroEmpleados() {
        return numeroEmpleados;
    }

    public void setNumeroEmpleados(String numeroEmpleados) {
        this.numeroEmpleados = numeroEmpleados;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
}
