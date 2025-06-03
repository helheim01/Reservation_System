package com.example.VueloDeBiazi.service;

import com.example.VueloDeBiazi.Model.Avion;

import java.util.List;

public interface IAvionService {
    Avion getAvionById(Integer id);
    List<Avion> getAllAviones();
    String saveAvion(Avion avion);
    String updateAvion(Integer id, Avion avion);
    String deleteAvion(Integer id);

}
