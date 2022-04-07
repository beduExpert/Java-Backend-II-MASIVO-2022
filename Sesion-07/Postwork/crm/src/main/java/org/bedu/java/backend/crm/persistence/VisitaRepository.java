package org.bedu.java.backend.crm.persistence;

import org.bedu.java.backend.crm.persistence.entities.Visita;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VisitaRepository extends JpaRepository<Visita, Long> {
}
