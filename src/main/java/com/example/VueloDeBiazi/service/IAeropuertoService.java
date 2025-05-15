package com.example.VueloDeBiazi.service;

import com.example.VueloDeBiazi.entity.Aeropuerto;
import java.util.List;

public interface IAeropuertoService {
        Aeropuerto getAeropuertoById(Integer id);
        List<Aeropuerto> getAllAeropuertos();
        String saveAeropuerto(Aeropuerto aeropuerto);
        String updateAeropuerto(Integer id, Aeropuerto aeropuerto);
        String deleteAeropuerto(Integer id);
}
