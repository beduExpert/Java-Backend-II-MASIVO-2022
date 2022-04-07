package org.bedu.java.backend.crm.controllers.mappers;

import org.bedu.java.backend.crm.persistence.entities.Visita;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface VisitaMapper {
    Visita visitaModelToVisitaEntity(org.bedu.java.backend.crm.model.Visita visitaModel);

    org.bedu.java.backend.crm.model.Visita visitaEntityToVisitaModel(Visita visita);
}
