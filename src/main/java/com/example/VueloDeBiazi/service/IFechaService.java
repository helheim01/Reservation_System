package com.example.VueloDeBiazi.service;

import com.example.VueloDeBiazi.Model.Fecha;

import java.util.List;

public interface IFechaService {
    Fecha getFechaById(Integer id);
    List<Fecha> getAllFechas();
    String saveFecha(Fecha fecha);
    String updateFecha(Integer id, Fecha fecha);
    String deleteFecha(Integer id);
}

