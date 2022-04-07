package org.bedu.java.backend.crm.services;


import lombok.RequiredArgsConstructor;
import org.bedu.java.backend.crm.controllers.mappers.EtapaMapper;
import org.bedu.java.backend.crm.model.Etapa;
import org.bedu.java.backend.crm.persistence.EtapaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EtapaService {
    private final EtapaRepository repository;
    private final EtapaMapper mapper;

    public Etapa guardaEtapa(Etapa etapa) {
        return mapper.etapaEntityToEtapaModel(
                repository.save(mapper.etapaModelToEtapaEntity(etapa))
        );
    }

    public List<Etapa> obtenEtapas(){
        return repository.findAll().stream().map(etapa -> mapper.etapaEntityToEtapaModel(etapa)).collect(Collectors.toList());
    }

    public Optional<Etapa> obtenEtapa(long idEtapa) {
        return repository.findById(idEtapa)
                .map(Etapa -> Optional.of(mapper.etapaEntityToEtapaModel(Etapa)))
                .orElse(Optional.empty());
    }

    public void eliminaEtapa(long idEtapa){
        repository.deleteById(idEtapa);
    }

    public Etapa actualizaEtapa(Etapa etapa){
        return mapper.etapaEntityToEtapaModel(
                repository.save(mapper.etapaModelToEtapaEntity(etapa))
        );
    }

    public long cuenteEtapas(){
        return repository.count();
    }
}
