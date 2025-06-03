package com.example.VueloDeBiazi.controller;

import com.example.VueloDeBiazi.Model.Consulta;
import com.example.VueloDeBiazi.service.IConsultaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/consultas")
@CrossOrigin(origins = "http://localhost:8080")
public class ConsultaController {

    @Autowired
    private IConsultaService consultaService;

    // Obtener consulta por ID
    @GetMapping("/consulta/{id}")
    public Consulta getConsulta(@PathVariable Integer id) {
        return consultaService.getConsultaById(id);
    }

    // Obtener todas las consultas
    @GetMapping("/consultas")
    public List<Consulta> getConsultas() {
        return consultaService.getAllConsultas();
    }

    // Guardar una consulta
    @PostMapping("/guardarConsulta")
    public Consulta post(@RequestBody Consulta consulta) {
        return consultaService.saveConsulta(consulta);
    }

    // Editar consulta
    @PutMapping("/editarConsulta/{id}")
    public String update(@PathVariable Integer id, @RequestBody Consulta consulta) {
        return consultaService.updateConsulta(id, consulta);
    }

    // Eliminar consulta
    @DeleteMapping("/eliminarConsulta/{id}")
    public String delete(@PathVariable Integer id) {
        return consultaService.deleteConsulta(id);
    }
}

