package com.example.VueloDeBiazi.service;


import com.example.VueloDeBiazi.entity.Aerolinea;
import com.example.VueloDeBiazi.repository.RepositoryAerolinea;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AerolineaServiceImpl implements IAerolineaService {

    @Autowired
    private RepositoryAerolinea repositoryAerolinea;

    @Override
    public Aerolinea getAerolineaById(Integer id) {
        return repositoryAerolinea.findById(id).orElse(null);
    }

    @Override
    public List<Aerolinea> getAllAerolineas() {
        return repositoryAerolinea.findAll();
    }

    @Override
    public String saveAerolinea(Aerolinea aerolinea) {
        repositoryAerolinea.save(aerolinea);
        return "AEROLINEA GUARDADA";
    }

    @Override
    public String updateAerolinea(Integer id, Aerolinea aerolinea) {
        Aerolinea existente = repositoryAerolinea.findById(id).orElse(null);
        if (existente != null) {
            existente.setNombreAerolinea(aerolinea.getNombreAerolinea());
            repositoryAerolinea.save(existente);
            return "AEROLINEA EDITADA";
        }
        return "NO EXISTE LA AEROLINEA CON ESE ID";
    }

    @Override
    public String deleteAerolinea(Integer id) {
        Aerolinea existente = repositoryAerolinea.findById(id).orElse(null);
        if (existente != null) {
            repositoryAerolinea.delete(existente);
            return "AEROLINEA ELIMINADA";
        }
        return "NO EXISTE LA AEROLINEA CON ESE ID";
    }
}