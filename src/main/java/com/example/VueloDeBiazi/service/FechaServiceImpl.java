package com.example.VueloDeBiazi.service;

import com.example.VueloDeBiazi.entity.Fecha;
import com.example.VueloDeBiazi.repository.RepositoryFecha;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FechaServiceImpl implements IFechaService {

    @Autowired
    private RepositoryFecha repositoryFecha;

    @Override
    public Fecha getFechaById(Integer id) {
        return repositoryFecha.findById(id).orElse(null);
    }

    @Override
    public List<Fecha> getAllFechas() {
        return repositoryFecha.findAll();
    }

    @Override
    public String saveFecha(Fecha fecha) {
        repositoryFecha.save(fecha);
        return "FECHA GUARDADA";
    }

    @Override
    public String updateFecha(Integer id, Fecha fecha) {
        Fecha existente = repositoryFecha.findById(id).orElse(null);
        if (existente != null) {
            existente.setFecha(fecha.getFecha());
            repositoryFecha.save(existente);
            return "FECHA EDITADA";
        }
        return "NO EXISTE LA FECHA CON ESE ID";
    }

    @Override
    public String deleteFecha(Integer id) {
        Fecha existente = repositoryFecha.findById(id).orElse(null);
        if (existente != null) {
            repositoryFecha.delete(existente);
            return "FECHA ELIMINADA";
        }
        return "NO EXISTE LA FECHA CON ESE ID";
    }
}
