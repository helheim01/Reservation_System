package com.example.VueloDeBiazi.service;

import com.example.VueloDeBiazi.Model.Piloto;

import java.util.List;

public interface IPilotoService {
    Piloto getPilotoById(Integer id);
    List<Piloto> getAllPilotos();
    String savePiloto(Piloto piloto);
    String updatePiloto(Integer id, Piloto piloto);
    String deletePiloto(Integer id);
}
