package org.bedu.java.backend.sesion7.reto1.services;

import lombok.RequiredArgsConstructor;
import org.bedu.java.backend.sesion7.reto1.persistence.CalculadoraDao;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CalculadoraService {

    private final CalculadoraDao calculadoraDao;

    public int suma(int a, int b, int c) {
        return a + b + calculadoraDao.findValorConstante(c);
    }

    public int resta(int a, int b, int c) {
        return a - b + calculadoraDao.findValorConstante(c);
    }

    public int multiplica(int a, int b, int c) {
        return a * b + calculadoraDao.findValorConstante(c);
    }
}
