package com.example.VueloDeBiazi.service;

import com.example.VueloDeBiazi.entity.Vuelo;
import com.example.VueloDeBiazi.repository.RepositoryVuelo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VueloServiceImpl implements IVueloService {

    @Autowired
    private RepositoryVuelo repositoryVuelo;

    @Override
    public Vuelo getVueloById(Integer id) {
        return repositoryVuelo.findById(id).orElse(null);
    }

    @Override
    public List<Vuelo> getAllVuelos() {
        return repositoryVuelo.findAll();
    }

    @Override
    public String saveVuelo(Vuelo vuelo) {
        repositoryVuelo.save(vuelo);
        return "VUELO GUARDADO";
    }

    @Override
    public String updateVuelo(Integer id, Vuelo vuelo) {
        Vuelo existente = repositoryVuelo.findById(id).orElse(null);
        if (existente != null) {
            existente.setAvion(vuelo.getAvion());
            existente.setAeropuertos(vuelo.getAeropuertos());
            existente.setPiloto(vuelo.getPiloto());
            existente.setFecha(vuelo.getFecha());
            existente.setAerolinea(vuelo.getAerolinea());
            existente.setTarifas(vuelo.getTarifas());
            repositoryVuelo.save(existente);
            return "VUELO EDITADO";
        }
        return "NO EXISTE EL VUELO CON ESE ID";
    }

    @Override
    public String deleteVuelo(Integer id) {
        Vuelo existente = repositoryVuelo.findById(id).orElse(null);
        if (existente != null) {
            repositoryVuelo.delete(existente);
            return "VUELO ELIMINADO";
        }
        return "NO EXISTE EL VUELO CON ESE ID";
    }
}
