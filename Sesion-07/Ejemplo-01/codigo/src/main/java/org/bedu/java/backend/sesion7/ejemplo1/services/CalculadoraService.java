package org.bedu.java.backend.sesion7.ejemplo1.services;

import lombok.RequiredArgsConstructor;
import org.bedu.java.backend.sesion7.ejemplo1.persistence.CalculadoraDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CalculadoraService {

    private final CalculadoraDao calculadoraDao;

    public int suma(int a, int b) {
        return a + b + calculadoraDao.findValorConstante();
    }

    public int resta(int a, int b) {
        return a - b + calculadoraDao.findValorConstante();
    }

    public int multiplica(int a, int b) {
        return a * b + calculadoraDao.findValorConstante();
    }
}
