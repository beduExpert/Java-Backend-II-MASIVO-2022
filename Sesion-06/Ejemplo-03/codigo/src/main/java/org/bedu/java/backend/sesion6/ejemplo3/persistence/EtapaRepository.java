package org.bedu.java.backend.sesion6.ejemplo3.persistence;

import org.bedu.java.backend.sesion6.ejemplo3.model.Etapa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EtapaRepository extends JpaRepository<Etapa, Long> {
}
