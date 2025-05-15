package com.example.VueloDeBiazi.service;

import com.example.VueloDeBiazi.entity.Reserva;

import java.util.List;

public interface IReservaService {
    Reserva getReservaById(Integer id);
    List<Reserva> getAllReservas();
    String saveReserva(Reserva reserva);
    String updateReserva(Integer id, Reserva reserva);
    String deleteReserva(Integer id);
}
