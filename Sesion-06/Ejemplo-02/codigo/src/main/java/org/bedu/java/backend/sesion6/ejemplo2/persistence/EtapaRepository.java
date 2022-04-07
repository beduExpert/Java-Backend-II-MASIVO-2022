package org.bedu.java.backend.sesion6.ejemplo2.persistence;

import org.bedu.java.backend.sesion6.ejemplo2.model.Etapa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EtapaRepository extends JpaRepository<Etapa, Long> {
}
