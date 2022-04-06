package org.bedu.java.backend.sesion6.reto2;

import org.bedu.java.backend.sesion6.reto2.dtos.VisitaDto;
import org.bedu.java.backend.sesion6.reto2.dtos.mappings.VisitaMapper;
import org.bedu.java.backend.sesion6.reto2.dtos.mappings.VisitaMapperImpl;
import org.bedu.java.backend.sesion6.reto2.model.Visita;

import java.time.LocalDateTime;

public class Principal {
    public static void main(String[] args) {
        Visita visita = new Visita();
        visita.setDireccion("Oficina del cliente");
        visita.setFechaProgramada(LocalDateTime.now().plusDays(5));
        visita.setProposito("Presentar nuevos productos");
        visita.setVendedor("Juan Pérez");

        VisitaMapper mapper  = new VisitaMapperImpl();

        VisitaDto visitaDtoMapeada = mapper.visitaToVisitaDto(visita);

        System.out.printf("Propósito: %s%n", visitaDtoMapeada.getProposito());
        System.out.printf("Fecha de visita: %s%n", visitaDtoMapeada.getFecha());
        System.out.printf("Vendedor: %s%n%n", visitaDtoMapeada.getNombreVendedor());

        VisitaDto visitaDto = new VisitaDto();
        visitaDto.setFecha(LocalDateTime.now().plusDays(7));
        visitaDto.setLugar("Casa del cliente");
        visitaDto.setNombreVendedor("Juan Manuel");
        visitaDto.setProposito("Presentación de nuevos productos");

        Visita visitaMapeada = mapper.visitaDtoToVisita(visitaDto);

        System.out.printf("Propósito: %s%n", visitaMapeada.getProposito());
        System.out.printf("Fecha de visita: %s%n", visitaMapeada.getFechaProgramada());
        System.out.printf("Vendedor: %s%n", visitaMapeada.getVendedor());


    }
}
