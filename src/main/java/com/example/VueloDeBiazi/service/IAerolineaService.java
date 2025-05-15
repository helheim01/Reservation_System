package com.example.VueloDeBiazi.service;

import com.example.VueloDeBiazi.entity.Aerolinea;

import java.util.List;

public interface IAerolineaService {
    Aerolinea getAerolineaById(Integer id);
    List<Aerolinea> getAllAerolineas();
    String saveAerolinea(Aerolinea aerolinea);
    String updateAerolinea(Integer id, Aerolinea aerolinea);
    String deleteAerolinea(Integer id);
}