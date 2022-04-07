package org.bedu.java.backend.crm.persistence;

import org.bedu.java.backend.crm.persistence.entities.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
