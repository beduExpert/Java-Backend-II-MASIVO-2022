package org.bedu.java.backend.sesion6.ejemplo1.persistence;

import org.bedu.java.backend.sesion6.ejemplo1.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository  extends JpaRepository<Cliente, Long> {
}
