package com.example.VueloDeBiazi.service;

import com.example.VueloDeBiazi.Model.Aeropuerto;
import com.example.VueloDeBiazi.repository.RepositoryAeropuerto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AeropuertoServiceImpl implements IAeropuertoService {

    @Autowired
    private RepositoryAeropuerto repositoryAeropuerto;

    @Override
    public Aeropuerto getAeropuertoById(Integer id) {
        return repositoryAeropuerto.findById(id).orElse(null);
    }

    @Override
    public List<Aeropuerto> getAllAeropuertos() {
        return repositoryAeropuerto.findAll();
    }

    @Override
    public String saveAeropuerto(Aeropuerto aeropuerto) {
        repositoryAeropuerto.save(aeropuerto);
        return "AEROPUERTO GUARDADO";
    }

    @Override
    public String updateAeropuerto(Integer id, Aeropuerto aeropuerto) {
        Aeropuerto existente = repositoryAeropuerto.findById(id).orElse(null);
        if (existente != null) {
            existente.setNombreAeropuerto(aeropuerto.getNombreAeropuerto());
            existente.setCiudad(aeropuerto.getCiudad());
            repositoryAeropuerto.save(existente);
            return "AEROPUERTO EDITADO";
        }
        return "NO EXISTE EL AEROPUERTO CON ESE ID";
    }

    @Override
    public String deleteAeropuerto(Integer id) {
        Aeropuerto existente = repositoryAeropuerto.findById(id).orElse(null);
        if (existente != null) {
            repositoryAeropuerto.delete(existente);
            return "AEROPUERTO ELIMINADO";
        }
        return "NO EXISTE EL AEROPUERTO CON ESE ID";
    }
}
