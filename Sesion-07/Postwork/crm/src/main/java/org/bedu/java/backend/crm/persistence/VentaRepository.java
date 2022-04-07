package org.bedu.java.backend.crm.persistence;

import org.bedu.java.backend.crm.persistence.entities.Venta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VentaRepository extends JpaRepository<Venta, Long> {
}
