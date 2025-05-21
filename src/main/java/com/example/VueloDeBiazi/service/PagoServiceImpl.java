package com.example.VueloDeBiazi.service;

import com.example.VueloDeBiazi.entity.Pago;
import com.example.VueloDeBiazi.repository.RepositoryPago;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PagoServiceImpl implements IPagoService {

    @Autowired
    private RepositoryPago repositoryPago;

    @Override
    public Pago getPagoById(Integer id) {
        return repositoryPago.findById(id).orElse(null);
    }

    @Override
    public List<Pago> getAllPagos() {
        return repositoryPago.findAll();
    }

    @Override
    public String savePago(Pago pago) {
        repositoryPago.save(pago);
        return "PAGO GUARDADO";
    }

    @Override
    public String updatePago(Integer id, Pago pago) {
        Pago existente = repositoryPago.findById(id).orElse(null);
        if (existente != null) {
            existente.setMonto(pago.getMonto());
            repositoryPago.save(existente);
            return "PAGO EDITADO";
        }
        return "NO EXISTE EL PAGO CON ESE ID";
    }

    @Override
    public String deletePago(Integer id) {
        Pago existente = repositoryPago.findById(id).orElse(null);
        if (existente != null) {
            repositoryPago.delete(existente);
            return "PAGO ELIMINADO";
        }
        return "NO EXISTE EL PAGO CON ESE ID";
    }
}
