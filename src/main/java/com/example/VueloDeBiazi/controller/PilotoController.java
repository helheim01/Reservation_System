package com.example.VueloDeBiazi.controller;

import com.example.VueloDeBiazi.entity.Piloto;
import com.example.VueloDeBiazi.repository.RepositoryPiloto;
import com.example.VueloDeBiazi.service.IPilotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pilotos")
@CrossOrigin(origins = "http://localhost:8080")
public class PilotoController {

    @Autowired
    private IPilotoService pilotoService;

    // Obtener un piloto por ID
    @GetMapping("/piloto/{id}")
    public Piloto getPiloto(@PathVariable Integer id) {
        return pilotoService.getPilotoById(id);
    }

    // Obtener todos los pilotos
    @GetMapping("/pilotos")
    public List<Piloto> getPilotos() {
        return pilotoService.getAllPilotos();
    }

    // Guardar un piloto
    @PostMapping("/guardarPiloto")
    public String post(@RequestBody Piloto piloto) {
        return pilotoService.savePiloto(piloto);
    }

    // Editar un piloto
    @PutMapping("/editarPiloto/{id}")
    public String update(@PathVariable Integer id, @RequestBody Piloto piloto) {
        return pilotoService.updatePiloto(id, piloto);
    }

    // Eliminar un piloto
    @DeleteMapping("/eliminarPiloto/{id}")
    public String delete(@PathVariable Integer id) {
        return pilotoService.deletePiloto(id);
    }
}

