package com.example.VueloDeBiazi.service;

import com.example.VueloDeBiazi.entity.Aerolinea;
import com.example.VueloDeBiazi.entity.Ciudad;
import com.example.VueloDeBiazi.repository.RepositoryAerolinea;
import com.example.VueloDeBiazi.repository.RepositoryCiudad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CiudadServiceImpl implements ICiudadService{
    @Autowired
    private RepositoryCiudad repositoryCiudad;

    @Override
    public Ciudad getCiudadById(Integer id) {
        return repositoryCiudad.findById(id).orElse(null);
    }

    @Override
    public List<Ciudad> getAllCiudades() {
        return repositoryCiudad.findAll();
    }

    @Override
    public String saveCiudad(Ciudad ciudad) {
        repositoryCiudad.save(ciudad);
        return "CIUDAD GUARDADA";
    }

    @Override
    public String updateCiudad(Integer id, Ciudad ciudad) {
        Ciudad existente = repositoryCiudad.findById(id).orElse(null);
        if (existente != null) {
            existente.setNombreCiudad(ciudad.getNombreCiudad());
            repositoryCiudad.save(existente);
            return "CIUDAD EDITADA";
        }
        return "NO EXISTE LA CIUDAD CON ESE ID";
    }

    @Override
    public String deleteCiudad(Integer id) {
        Ciudad existente = repositoryCiudad.findById(id).orElse(null);
        if (existente != null) {
            repositoryCiudad.delete(existente);
            return "CIUDAD ELIMINADA";
        }
        return "NO EXISTE LA CIUDAD CON ESE ID";
    }
}
