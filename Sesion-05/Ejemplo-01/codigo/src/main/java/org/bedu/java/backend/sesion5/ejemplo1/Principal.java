package org.bedu.java.backend.sesion5.ejemplo1;

import org.bedu.java.backend.sesion5.ejemplo1.model.Visita;

import java.time.LocalDateTime;

public class Principal {
    public static void main(String[] args) {
        Visita visita = Visita.builder().proposito("Presentar los nuevos productos")
                .direccion("Oficina del cliente")
                .fechaProgramada(LocalDateTime.now().plusDays(3))
                .vendedor("Juan Manuel")
        .build();

        System.out.printf("Datos de la visita: %s%n", visita);
    }
}
