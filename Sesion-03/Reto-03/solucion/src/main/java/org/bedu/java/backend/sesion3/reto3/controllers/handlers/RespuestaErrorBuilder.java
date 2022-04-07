package org.bedu.java.backend.sesion3.reto3.controllers.handlers;

import org.bedu.java.backend.sesion3.reto3.model.builders.RespuestaError;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class RespuestaErrorBuilder {
    private int estatus;
    private String error;
    private String mensaje;
    private String ruta;

    public RespuestaErrorBuilder estatus(int estatus) {
        this.estatus = estatus;
        return this;
    }

    public RespuestaErrorBuilder status(HttpStatus estatus) {
        this.estatus = estatus.value();

        if (estatus.isError()) {
            this.error = estatus.getReasonPhrase();
        }

        return this;
    }

    public RespuestaErrorBuilder error(String error) {
        this.error = error;
        return this;
    }

    public RespuestaErrorBuilder message(String mensaje) {
        this.mensaje = mensaje;
        return this;
    }

    public RespuestaErrorBuilder ruta(String ruta) {
        this.ruta = ruta;
        return this;
    }

    public RespuestaError build() {
        RespuestaError respuesta = new RespuestaError();
        respuesta.setEstatus(estatus);
        respuesta.setError(error);
        respuesta.setMensaje(mensaje);
        respuesta.setRuta(ruta);
        return respuesta;
    }

    public ResponseEntity<RespuestaError> entidad() {
        return ResponseEntity.status(estatus).headers(HttpHeaders.EMPTY).body(build());
    }
}
