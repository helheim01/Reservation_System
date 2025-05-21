package com.example.VueloDeBiazi.service;

import com.example.VueloDeBiazi.entity.Consulta;

import java.util.List;

public interface IConsultaService {
    Consulta getConsultaById(Integer id);
    List<Consulta> getAllConsultas();
    Consulta saveConsulta(Consulta consulta);
    String updateConsulta(Integer id, Consulta consulta);
    String deleteConsulta(Integer id);
}
