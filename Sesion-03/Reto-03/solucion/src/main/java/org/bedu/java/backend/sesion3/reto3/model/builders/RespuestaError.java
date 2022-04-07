package org.bedu.java.backend.sesion3.reto3.model.builders;

import org.bedu.java.backend.sesion3.reto3.controllers.handlers.RespuestaErrorBuilder;

import java.time.LocalDateTime;

public class RespuestaError {
    private final LocalDateTime timestamp = LocalDateTime.now();
    private int estatus;
    private String error;
    private String mensaje;
    private String ruta;

    public static RespuestaErrorBuilder builder() {
        return new RespuestaErrorBuilder();
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public int getEstatus() {
        return estatus;
    }

    public void setEstatus(int estatus) {
        this.estatus = estatus;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getRuta() {
        return ruta;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
    }
}
