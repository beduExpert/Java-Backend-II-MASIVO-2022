package org.bedu.java.backend.sesion7.reto1.services;

import org.bedu.java.backend.sesion7.reto1.persistence.CalculadoraDao;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class CalculadoraServiceTest {

    @Mock(lenient = true)
    CalculadoraDao calculadoraDao;

    @InjectMocks
    private CalculadoraService calculadora;


    @BeforeEach
    void setUp() {
        given(calculadoraDao.findValorConstante(AdditionalMatchers.gt(6))).willReturn(2);
        given(calculadoraDao.findValorConstante(AdditionalMatchers.lt(5))).willReturn(1);
    }

    @Test
    @DisplayName("Prueba suma")
    void sumaTest() {
        int esperado = 6;
        int constante = 1;
        assertEquals(esperado, calculadora.suma(3, 2, constante));
    }

    @Test
    @DisplayName("Prueba resta")
    void restaTest() {
        int esperado = 1;
        int constante = 5;
        assertEquals(esperado, calculadora.resta(3, 2, constante));
    }

    @Test
    @DisplayName("Prueba multiplicación")
    void multiplicaTest() {
        int esperado = 8;
        int constante = 15;
        assertEquals(esperado, calculadora.multiplica(3, 2, 15));
    }
}