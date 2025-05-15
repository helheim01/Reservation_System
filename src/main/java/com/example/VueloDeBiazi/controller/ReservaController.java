package com.example.VueloDeBiazi.controller;

import com.example.VueloDeBiazi.entity.Reserva;
import com.example.VueloDeBiazi.repository.RepositoryReserva;
import com.example.VueloDeBiazi.service.IReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reservas")
@CrossOrigin(origins = "http://localhost:8080")
public class ReservaController {

    @Autowired
    private IReservaService reservaService;

    // Obtener una reserva por ID
    @GetMapping("/reserva/{id}")
    public Reserva getReserva(@PathVariable Integer id) {
        return reservaService.getReservaById(id);
    }

    // Obtener todas las reservas
    @GetMapping("/reservas")
    public List<Reserva> getReservas() {
        return reservaService.getAllReservas();
    }

    // Guardar una reserva
    @PostMapping("/guardarReserva")
    public String post(@RequestBody Reserva reserva) {
        return reservaService.saveReserva(reserva);
    }

    // Editar una reserva
    @PutMapping("/editarReserva/{id}")
    public String update(@PathVariable Integer id, @RequestBody Reserva reserva) {
        return reservaService.updateReserva(id, reserva);
    }

    // Eliminar una reserva
    @DeleteMapping("/eliminarReserva/{id}")
    public String delete(@PathVariable Integer id) {
        return reservaService.deleteReserva(id);
    }
}

