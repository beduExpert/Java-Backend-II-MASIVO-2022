package org.bedu.java.backend.sesion4.ejemplo2.controllers.handlers;

import org.bedu.java.backend.sesion4.ejemplo2.model.builders.RespuestaError;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


import java.util.Map;
import java.util.TreeMap;

@RestControllerAdvice
public class ManejadorGlobalExcepciones extends ResponseEntityExceptionHandler {
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {


        Map<String, String> errors = new TreeMap<>();

        for (FieldError error : ex.getBindingResult().getFieldErrors()) {
            errors.put(error.getField(), error.getDefaultMessage());
        }
        for (ObjectError error : ex.getBindingResult().getGlobalErrors()) {
            errors.put(error.getObjectName(), error.getDefaultMessage());
        }

        RespuestaError respuestaError = new RespuestaError();
        respuestaError.setErrores(errors);
        respuestaError.setRuta(request.getDescription(false).substring(4));

        return handleExceptionInternal(
                ex, respuestaError, headers, HttpStatus.BAD_REQUEST, request);
    }
}
