package org.bedu.java.backend.crm.persistence.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Table(name = "ETAPAS")
@Entity
@NoArgsConstructor
public class Etapa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long etapaId;

    private String nombre;

    @Column(unique = true, nullable = false)
    private Integer orden;
}
