package com.example.VueloDeBiazi.service;

import com.example.VueloDeBiazi.entity.Avion;
import com.example.VueloDeBiazi.repository.RepositoryAvion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AvionServiceImpl implements IAvionService {

    @Autowired
    private RepositoryAvion repositoryAvion;

    @Override
    public Avion getAvionById(Integer id) {
        return repositoryAvion.findById(id).orElse(null);
    }

    @Override
    public List<Avion> getAllAviones() {
        return repositoryAvion.findAll();
    }

    @Override
    public String saveAvion(Avion avion) {
        repositoryAvion.save(avion);
        return "AVIÓN GUARDADO";
    }

    @Override
    public String updateAvion(Integer id, Avion avion) {
        Avion existente = repositoryAvion.findById(id).orElse(null);
        if (existente != null) {
            // Nota: no se está modificando lista de asientos, solo reemplazamos si fuera necesario
            existente.setAsientos(avion.getAsientos());
            repositoryAvion.save(existente);
            return "AVIÓN EDITADO";
        }
        return "NO EXISTE EL AVIÓN CON ESE ID";
    }

    @Override
    public String deleteAvion(Integer id) {
        Avion existente = repositoryAvion.findById(id).orElse(null);
        if (existente != null) {
            repositoryAvion.delete(existente);
            return "AVIÓN ELIMINADO";
        }
        return "NO EXISTE EL AVIÓN CON ESE ID";
    }
}
