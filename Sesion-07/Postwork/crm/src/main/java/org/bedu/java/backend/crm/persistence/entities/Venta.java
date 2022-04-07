package org.bedu.java.backend.crm.persistence.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Table(name = "VENTAS")
@Entity
@NoArgsConstructor
public class Venta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long ventaId;

    private float monto;

    @OneToMany
    private List<Producto> productos;

    @ManyToOne
    private Cliente cliente;

    @Column(nullable = false)
    private LocalDateTime fechaCreacion;
}
