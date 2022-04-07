package org.bedu.java.backend.sesion6.reto2.dtos;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class EtapaDto {
    private Long etapaId;
    private String nombre;
    private Integer orden;
}
