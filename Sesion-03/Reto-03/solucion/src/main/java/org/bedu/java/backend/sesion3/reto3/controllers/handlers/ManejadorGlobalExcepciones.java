package org.bedu.java.backend.sesion3.reto3.controllers.handlers;

import org.bedu.java.backend.sesion3.reto3.model.builders.RespuestaError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class ManejadorGlobalExcepciones {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> manejaException(Exception ex, WebRequest request) {
        return RespuestaError.builder()
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .message("Server encountered an error")
                .ruta(request.getDescription(false).substring(4))
                .entidad();
    }
}
