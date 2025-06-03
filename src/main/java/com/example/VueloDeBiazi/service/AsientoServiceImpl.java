package com.example.VueloDeBiazi.service;

import com.example.VueloDeBiazi.Model.Asiento;
import com.example.VueloDeBiazi.repository.RepositoryAsiento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AsientoServiceImpl implements IAsientoService {

    @Autowired
    private RepositoryAsiento repositoryAsiento;

    @Override
    public Asiento getAsientoById(Integer id) {
        return repositoryAsiento.findById(id).orElse(null);
    }

    @Override
    public List<Asiento> getAllAsientos() {
        return repositoryAsiento.findAll();
    }

    @Override
    public String saveAsiento(Asiento asiento) {
        repositoryAsiento.save(asiento);
        return "ASIENTO GUARDADO";
    }

    @Override
    public String updateAsiento(Integer id, Asiento asiento) {
        Asiento existente = repositoryAsiento.findById(id).orElse(null);
        if (existente != null) {
            existente.setFilaAsiento(asiento.getFilaAsiento());
            existente.setLetraAsiento(asiento.getLetraAsiento());
            repositoryAsiento.save(existente);
            return "ASIENTO EDITADO";
        }
        return "NO EXISTE EL ASIENTO CON ESE ID";
    }

    @Override
    public String deleteAsiento(Integer id) {
        Asiento existente = repositoryAsiento.findById(id).orElse(null);
        if (existente != null) {
            repositoryAsiento.delete(existente);
            return "ASIENTO ELIMINADO";
        }
        return "NO EXISTE EL ASIENTO CON ESE ID";
    }
}
