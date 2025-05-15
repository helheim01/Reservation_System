package com.example.VueloDeBiazi.service;

import com.example.VueloDeBiazi.entity.Consulta;
import com.example.VueloDeBiazi.repository.RepositoryConsulta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConsultaServiceImpl implements IConsultaService {

    @Autowired
    private RepositoryConsulta repositoryConsulta;

    @Override
    public Consulta getConsultaById(Integer id) {
        return repositoryConsulta.findById(id).orElse(null);
    }

    @Override
    public List<Consulta> getAllConsultas() {
        return repositoryConsulta.findAll();
    }

    @Override
    public String saveConsulta(Consulta consulta) {
        repositoryConsulta.save(consulta);
        return "CONSULTA GUARDADA";
    }

    @Override
    public String updateConsulta(Integer id, Consulta consulta) {
        Consulta existente = repositoryConsulta.findById(id).orElse(null);
        if (existente != null) {
            existente.setVuelo(consulta.getVuelo());
            repositoryConsulta.save(existente);
            return "CONSULTA EDITADA";
        }
        return "NO EXISTE LA CONSULTA CON ESE ID";
    }

    @Override
    public String deleteConsulta(Integer id) {
        Consulta existente = repositoryConsulta.findById(id).orElse(null);
        if (existente != null) {
            repositoryConsulta.delete(existente);
            return "CONSULTA ELIMINADA";
        }
        return "NO EXISTE LA CONSULTA CON ESE ID";
    }
}
