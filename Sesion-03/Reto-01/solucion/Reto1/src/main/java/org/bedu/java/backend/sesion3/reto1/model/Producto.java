package org.bedu.java.backend.sesion3.reto1.model;

import javax.validation.constraints.*;
import java.time.LocalDate;

public class Producto {
    @PositiveOrZero
    private long id;

    @NotBlank
    private String nombre;

    private String categoria;

    @DecimalMin(value = "1.00", inclusive = true)
    private float precio;

    @Pattern(regexp = "^(\\d{3}[-]?){2}\\d{4}$")
    private String numeroRegistro;

    @PastOrPresent
    private LocalDate fechaCreacion;

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

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getNumeroRegistro() {
        return numeroRegistro;
    }

    public void setNumeroRegistro(String numeroRegistro) {
        this.numeroRegistro = numeroRegistro;
    }

    public LocalDate getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDate fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }
}
