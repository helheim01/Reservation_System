package com.example.VueloDeBiazi.service;

import com.example.VueloDeBiazi.Model.Ciudad;

import java.util.List;

public interface ICiudadService {
    Ciudad getCiudadById(Integer id);
    List<Ciudad> getAllCiudades();
    String saveCiudad(Ciudad ciudad);
    String updateCiudad(Integer id, Ciudad ciudad);
    String deleteCiudad(Integer id);
}
