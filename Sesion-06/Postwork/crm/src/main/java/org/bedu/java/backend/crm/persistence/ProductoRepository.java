package org.bedu.java.backend.crm.persistence;

import org.bedu.java.backend.crm.persistence.entities.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepository extends JpaRepository<Producto, Long> {
}
