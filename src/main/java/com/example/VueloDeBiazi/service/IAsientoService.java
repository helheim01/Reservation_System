package com.example.VueloDeBiazi.service;

import com.example.VueloDeBiazi.Model.Asiento;

import java.util.List;

public interface IAsientoService {
    Asiento getAsientoById(Integer id);
    List<Asiento> getAllAsientos();
    String saveAsiento(Asiento asiento);
    String updateAsiento(Integer id, Asiento asiento);
    String deleteAsiento(Integer id);
}
