package org.bedu.java.backend.crm.controllers.mappers;

import org.bedu.java.backend.crm.persistence.entities.Producto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductoMapper {
    Producto productoModelToProductoEntity(org.bedu.java.backend.crm.model.Producto productoModel);

    org.bedu.java.backend.crm.model.Producto productoEntityToProductoModel(Producto producto);
}
