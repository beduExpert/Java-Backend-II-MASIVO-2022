package org.bedu.java.backend.sesion6.reto2.dtos.mappers;

import org.bedu.java.backend.sesion6.reto2.dtos.EtapaDto;
import org.bedu.java.backend.sesion6.reto2.model.Etapa;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EtapaMapper {
    Etapa etapaDtoToEtapa(EtapaDto etapaDto);

    EtapaDto etapatoEtapaDto(Etapa etapa);
}
