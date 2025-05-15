package com.example.VueloDeBiazi.service;

import com.example.VueloDeBiazi.entity.Tarifa;
import com.example.VueloDeBiazi.repository.RepositoryTarifa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TarifaServiceImpl implements ITarifaService {

    @Autowired
    private RepositoryTarifa repositoryTarifa;

    @Override
    public Tarifa getTarifaById(Integer id) {
        return repositoryTarifa.findById(id).orElse(null);
    }

    @Override
    public List<Tarifa> getAllTarifas() {
        return repositoryTarifa.findAll();
    }

    @Override
    public String saveTarifa(Tarifa tarifa) {
        repositoryTarifa.save(tarifa);
        return "TARIFA GUARDADA";
    }

    @Override
    public String updateTarifa(Integer id, Tarifa tarifa) {
        Tarifa existente = repositoryTarifa.findById(id).orElse(null);
        if (existente != null) {
            existente.setImpuestoTarifa(tarifa.getImpuestoTarifa());
            existente.setPrecioTarifa(tarifa.getPrecioTarifa());
            existente.setClaseTarifa(tarifa.getClaseTarifa());
            existente.setVuelo(tarifa.getVuelo());
            repositoryTarifa.save(existente);
            return "TARIFA EDITADA";
        }
        return "NO EXISTE LA TARIFA CON ESE ID";
    }

    @Override
    public String deleteTarifa(Integer id) {
        Tarifa existente = repositoryTarifa.findById(id).orElse(null);
        if (existente != null) {
            repositoryTarifa.delete(existente);
            return "TARIFA ELIMINADA";
        }
        return "NO EXISTE LA TARIFA CON ESE ID";
    }
}
