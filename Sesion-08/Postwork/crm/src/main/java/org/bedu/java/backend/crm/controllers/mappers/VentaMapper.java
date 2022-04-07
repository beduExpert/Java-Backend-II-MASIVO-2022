package org.bedu.java.backend.crm.controllers.mappers;

import org.bedu.java.backend.crm.persistence.entities.Venta;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface VentaMapper {
    Venta ventaModelToVentaEntity(org.bedu.java.backend.crm.model.Venta ventaModel);

    org.bedu.java.backend.crm.model.Venta ventaEntityToVentaModel(Venta venta);
}
