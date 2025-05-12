package com.example.VueloDeBiazi.controller;

import com.example.VueloDeBiazi.entity.Reserva;
import com.example.VueloDeBiazi.repository.RepositoryReserva;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reservas")
@CrossOrigin(origins = "http://localhost:8080")
public class ReservaController {

    @Autowired
    private RepositoryReserva repositoryReserva;

    // Obtener una reserva por ID
    @GetMapping("reserva/{id}")
    public Reserva getReserva(@PathVariable Integer id) {
        return repositoryReserva.findById(id).get();
    }

    // Obtener todas las reservas
    @GetMapping("reservas")
    public List<Reserva> getReservas() {
        return repositoryReserva.findAll();
    }

    // Guardar una reserva
    @PostMapping("/guardarReserva")
    public String post(@RequestBody Reserva reserva) {
        repositoryReserva.save(reserva);
        return "RESERVA GUARDADA";
    }

    // Editar una reserva
    @PutMapping("/editarReserva/{id}")
    public String update(@PathVariable Integer id, @RequestBody Reserva reserva) {
        Reserva updateReserva = repositoryReserva.findById(id).get();
        updateReserva.setPago(reserva.getPago());
        updateReserva.setVuelo(reserva.getVuelo());

        repositoryReserva.save(updateReserva);
        return "RESERVA EDITADA CORRECTAMENTE";
    }

    // Eliminar una reserva
    @DeleteMapping("/eliminarReserva/{id}")
    public String delete(@PathVariable Integer id) {
        Reserva deleteReserva = repositoryReserva.findById(id).get();
        repositoryReserva.delete(deleteReserva);
        return "RESERVA ELIMINADA";
    }
}
