package com.example.VueloDeBiazi.service;

import com.example.VueloDeBiazi.entity.Piloto;
import com.example.VueloDeBiazi.repository.RepositoryPiloto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PilotoServiceImpl implements IPilotoService {

    @Autowired
    private RepositoryPiloto repositoryPiloto;

    @Override
    public Piloto getPilotoById(Integer id) {
        return repositoryPiloto.findById(id).orElse(null);
    }

    @Override
    public List<Piloto> getAllPilotos() {
        return repositoryPiloto.findAll();
    }

    @Override
    public String savePiloto(Piloto piloto) {
        repositoryPiloto.save(piloto);
        return "PILOTO GUARDADO";
    }

    @Override
    public String updatePiloto(Integer id, Piloto piloto) {
        Piloto existente = repositoryPiloto.findById(id).orElse(null);
        if (existente != null) {
            existente.setNumeroPiloto(piloto.getNumeroPiloto());
            // También podrías actualizar otros datos de Persona si corresponde
            repositoryPiloto.save(existente);
            return "PILOTO EDITADO";
        }
        return "NO EXISTE EL PILOTO CON ESE ID";
    }

    @Override
    public String deletePiloto(Integer id) {
        Piloto existente = repositoryPiloto.findById(id).orElse(null);
        if (existente != null) {
            repositoryPiloto.delete(existente);
            return "PILOTO ELIMINADO";
        }
        return "NO EXISTE EL PILOTO CON ESE ID";
    }
}
