package org.bedu.java.backend.sesion7.ejemplo1.persistence;

import org.springframework.stereotype.Component;

@Component
public interface CalculadoraDao {
    int findValorConstante();
}
