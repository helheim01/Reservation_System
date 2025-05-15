package com.example.VueloDeBiazi.service;

import com.example.VueloDeBiazi.entity.Tarjeta;
import java.util.List;

public interface ITarjetaService {
    Tarjeta getTarjetaById(Integer id);
    List<Tarjeta> getAllTarjetas();
    String saveTarjeta(Tarjeta tarjeta);
    String updateTarjeta(Integer id, Tarjeta tarjeta);
    String deleteTarjeta(Integer id);
}
