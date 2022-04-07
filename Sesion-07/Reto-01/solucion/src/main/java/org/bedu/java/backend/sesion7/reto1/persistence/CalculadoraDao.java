package org.bedu.java.backend.sesion7.reto1.persistence;

import org.springframework.stereotype.Component;

@Component
public interface CalculadoraDao {
    int findValorConstante(int valorInicial);
}
