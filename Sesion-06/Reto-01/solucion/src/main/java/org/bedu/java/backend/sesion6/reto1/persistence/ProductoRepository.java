package org.bedu.java.backend.sesion6.reto1.persistence;

import org.bedu.java.backend.sesion6.reto1.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepository extends JpaRepository<Producto, Long> {
}
