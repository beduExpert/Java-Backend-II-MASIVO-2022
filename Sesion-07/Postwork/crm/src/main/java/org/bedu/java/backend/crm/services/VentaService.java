package org.bedu.java.backend.crm.services;


import lombok.RequiredArgsConstructor;
import org.bedu.java.backend.crm.controllers.mappers.VentaMapper;
import org.bedu.java.backend.crm.model.Venta;
import org.bedu.java.backend.crm.persistence.VentaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class VentaService {
    private final VentaRepository repository;
    private final VentaMapper mapper;

    public Venta guardaVenta(Venta Venta) {
        return mapper.ventaEntityToVentaModel(
                repository.save(mapper.ventaModelToVentaEntity(Venta))
        );
    }

    public List<Venta> obtenVentas(){
        return repository.findAll().stream().map(venta -> mapper.ventaEntityToVentaModel(venta)).collect(Collectors.toList());
    }

    public Optional<Venta> obtenVenta(long idVenta) {
        return repository.findById(idVenta)
                .map(venta -> Optional.of(mapper.ventaEntityToVentaModel(venta)))
                .orElse(Optional.empty());
    }

    public void eliminaVenta(long idVenta){
        repository.deleteById(idVenta);
    }

    public Venta actualizaVenta(Venta venta){
        return mapper.ventaEntityToVentaModel(
                repository.save(mapper.ventaModelToVentaEntity(venta))
        );
    }

    public long cuenteVentas(){
        return repository.count();
    }
}
