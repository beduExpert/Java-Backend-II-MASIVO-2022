package org.bedu.java.backend.sesion3.ejemplo2.model;

import javax.validation.constraints.*;
import java.time.LocalDateTime;

public class Visita {

    @PositiveOrZero(message = "El identificador de la visita no puede ser un número negativo.")
    private long id;

    @Positive(message = "El identificador del cliente no puede ser un número negativo o cero.")
    private long clienteId;

    @Future(message = "La fecha de la cita no puede ser en una fecha en el pasado.")
    private LocalDateTime fechaProgramada;

    @NotEmpty(message = "La dirección no puede estar en blanco.")
    @Size(min = 10, message = "La dirección debe tener al menos 10 letras.")
    private String direccion;

    @NotEmpty(message = "El propósito de la visita no puede estar en blanco.")
    @Size(min = 15, message = "El propósito de la visita debe tener al menos 15 letras.")
    private String proposito;

    @NotEmpty(message = "El nombre del vendedor no puede estar en blanco.")
    @Size(min = 4, max = 30, message = "El nombre del vendedor debe tener entre 4 y 30 letras.")
    private String vendedor;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getClienteId() {
        return clienteId;
    }

    public void setClienteId(long clienteId) {
        this.clienteId = clienteId;
    }

    public LocalDateTime getFechaProgramada() {
        return fechaProgramada;
    }

    public void setFechaProgramada(LocalDateTime fechaProgramada) {
        this.fechaProgramada = fechaProgramada;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getProposito() {
        return proposito;
    }

    public void setProposito(String proposito) {
        this.proposito = proposito;
    }

    public String getVendedor() {
        return vendedor;
    }

    public void setVendedor(String vendedor) {
        this.vendedor = vendedor;
    }
}
