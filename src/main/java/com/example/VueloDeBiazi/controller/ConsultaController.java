package com.example.VueloDeBiazi.controller;

import com.example.VueloDeBiazi.entity.Consulta;
import com.example.VueloDeBiazi.repository.RepositoryConsulta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/consultas")
@CrossOrigin(origins = "http://localhost:8080")
public class ConsultaController {

    @Autowired
    private RepositoryConsulta repositoryConsulta;

    // Obtener consulta por ID
    @GetMapping("consulta/{id}")
    public Consulta getConsulta(@PathVariable Integer id) {
        return repositoryConsulta.findById(id).get();
    }

    // Obtener todas las consultas
    @GetMapping("consultas")
    public List<Consulta> getConsultas() {
        return repositoryConsulta.findAll();
    }

    // Guardar una consulta
    @PostMapping("/guardarConsulta")
    public String post(@RequestBody Consulta consulta) {
        repositoryConsulta.save(consulta);
        return "CONSULTA GUARDADA";
    }

    // Editar consulta
    @PutMapping("/editarConsulta/{id}")
    public String update(@PathVariable Integer id, @RequestBody Consulta consulta) {
        Consulta updateConsulta = repositoryConsulta.findById(id).get();
        updateConsulta.setVuelo(consulta.getVuelo());
        repositoryConsulta.save(updateConsulta);
        return "CONSULTA EDITADA CORRECTAMENTE";
    }

    // Eliminar consulta
    @DeleteMapping("/eliminarConsulta/{id}")
    public String delete(@PathVariable Integer id) {
        Consulta deleteConsulta = repositoryConsulta.findById(id).get();
        repositoryConsulta.delete(deleteConsulta);
        return "CONSULTA ELIMINADA";
    }
}
