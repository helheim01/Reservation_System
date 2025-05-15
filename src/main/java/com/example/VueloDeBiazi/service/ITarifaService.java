package com.example.VueloDeBiazi.service;

import com.example.VueloDeBiazi.entity.Tarifa;

import java.util.List;

public interface ITarifaService {
    Tarifa getTarifaById(Integer id);
    List<Tarifa> getAllTarifas();
    String saveTarifa(Tarifa tarifa);
    String updateTarifa(Integer id, Tarifa tarifa);
    String deleteTarifa(Integer id);
}
