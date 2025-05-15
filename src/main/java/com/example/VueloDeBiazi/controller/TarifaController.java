package com.example.VueloDeBiazi.controller;

import com.example.VueloDeBiazi.entity.Tarifa;
import com.example.VueloDeBiazi.repository.RepositoryTarifa;
import com.example.VueloDeBiazi.service.ITarifaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tarifas")
@CrossOrigin(origins = "http://localhost:8080")
public class TarifaController {

    @Autowired
    private ITarifaService tarifaService;

    // Obtener una tarifa por ID
    @GetMapping("/tarifa/{id}")
    public Tarifa getTarifa(@PathVariable Integer id) {
        return tarifaService.getTarifaById(id);
    }

    // Obtener todas las tarifas
    @GetMapping("/tarifas")
    public List<Tarifa> getTarifas() {
        return tarifaService.getAllTarifas();
    }

    // Guardar una tarifa
    @PostMapping("/guardarTarifa")
    public String post(@RequestBody Tarifa tarifa) {
        return tarifaService.saveTarifa(tarifa);
    }

    // Editar una tarifa
    @PutMapping("/editarTarifa/{id}")
    public String update(@PathVariable Integer id, @RequestBody Tarifa tarifa) {
        return tarifaService.updateTarifa(id, tarifa);
    }

    // Eliminar una tarifa
    @DeleteMapping("/eliminarTarifa/{id}")
    public String delete(@PathVariable Integer id) {
        return tarifaService.deleteTarifa(id);
    }
}

