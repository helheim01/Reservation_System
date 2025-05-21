package com.example.VueloDeBiazi.service;

import com.example.VueloDeBiazi.entity.Vuelo;

import java.util.List;

public interface IVueloService {
    Vuelo getVueloById(Integer id);
    List<Vuelo> getAllVuelos();
    String saveVuelo(Vuelo vuelo);
    String updateVuelo(Integer id, Vuelo vuelo);
    String deleteVuelo(Integer id);
    List<Vuelo> findByCiudadAndAerolinea(Integer ciudadId, Integer aerolineaId);
    List<String> getAsientosByVueloId(Integer vueloId);
}
