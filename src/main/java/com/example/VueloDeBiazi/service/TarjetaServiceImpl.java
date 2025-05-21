package com.example.VueloDeBiazi.service;

import com.example.VueloDeBiazi.entity.Tarjeta;
import com.example.VueloDeBiazi.repository.RepositoryTarjeta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TarjetaServiceImpl implements ITarjetaService {

    @Autowired
    private RepositoryTarjeta repositoryTarjeta;

    @Override
    public Tarjeta getTarjetaById(Integer id) {
        return repositoryTarjeta.findById(id).orElse(null);
    }

    @Override
    public List<Tarjeta> getAllTarjetas() {
        return repositoryTarjeta.findAll();
    }

    @Override
    public Tarjeta saveTarjeta(Tarjeta tarjeta) {
        return repositoryTarjeta.save(tarjeta);
    }

    @Override
    public String updateTarjeta(Integer id, Tarjeta tarjeta) {
        Tarjeta existente = repositoryTarjeta.findById(id).orElse(null);
        if (existente != null) {
            existente.setNumeroTarjeta(tarjeta.getNumeroTarjeta());
            existente.setTipoTarjeta(tarjeta.getTipoTarjeta());
            existente.setMonto(tarjeta.getMonto()); // Heredado de Pago
            repositoryTarjeta.save(existente);
            return "TARJETA EDITADA";
        }
        return "NO EXISTE LA TARJETA CON ESE ID";
    }

    @Override
    public String deleteTarjeta(Integer id) {
        Tarjeta existente = repositoryTarjeta.findById(id).orElse(null);
        if (existente != null) {
            repositoryTarjeta.delete(existente);
            return "TARJETA ELIMINADA";
        }
        return "NO EXISTE LA TARJETA CON ESE ID";
    }
}
