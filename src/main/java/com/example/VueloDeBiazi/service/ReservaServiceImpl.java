package com.example.VueloDeBiazi.service;

import com.example.VueloDeBiazi.entity.Reserva;
import com.example.VueloDeBiazi.repository.RepositoryReserva;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservaServiceImpl implements IReservaService {

    @Autowired
    private RepositoryReserva repositoryReserva;

    @Override
    public Reserva getReservaById(Integer id) {
        return repositoryReserva.findById(id).orElse(null);
    }

    @Override
    public List<Reserva> getAllReservas() {
        return repositoryReserva.findAll();
    }

    @Override
    public String saveReserva(Reserva reserva) {
        repositoryReserva.save(reserva);
        return "RESERVA GUARDADA";
    }

    @Override
    public String updateReserva(Integer id, Reserva reserva) {
        Reserva existente = repositoryReserva.findById(id).orElse(null);
        if (existente != null) {
            existente.setPago(reserva.getPago());
            existente.setVuelo(reserva.getVuelo());
            repositoryReserva.save(existente);
            return "RESERVA EDITADA";
        }
        return "NO EXISTE LA RESERVA CON ESE ID";
    }

    @Override
    public String deleteReserva(Integer id) {
        Reserva existente = repositoryReserva.findById(id).orElse(null);
        if (existente != null) {
            repositoryReserva.delete(existente);
            return "RESERVA ELIMINADA";
        }
        return "NO EXISTE LA RESERVA CON ESE ID";
    }
}
