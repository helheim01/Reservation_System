package com.example.VueloDeBiazi.service;

import com.example.VueloDeBiazi.entity.Persona;

import java.util.List;

public interface IPersonaService {
    Persona getPersonaById(Integer id);

    List<Persona> getAllPersonas();

    String savePersona(Persona persona);

    String updatePersona(Integer id, Persona persona);

    String deletePersona(Integer id);
}
