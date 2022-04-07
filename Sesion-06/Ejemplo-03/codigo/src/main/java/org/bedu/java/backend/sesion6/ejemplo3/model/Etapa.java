package org.bedu.java.backend.sesion6.ejemplo3.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "ETAPAS")
public class Etapa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long etapaId;

    @Column(nullable = false, length = 100)
    private String nombre;

    @Column(nullable = false, unique = true)
    private Integer orden;
}
