package com.example.VueloDeBiazi.controller;

import com.example.VueloDeBiazi.entity.Tarjeta;
import com.example.VueloDeBiazi.repository.RepositoryTarjeta;
import com.example.VueloDeBiazi.service.ITarjetaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tarjetas")
@CrossOrigin(origins = "http://localhost:8080")
public class TarjetaController {

    @Autowired
    private ITarjetaService tarjetaService;

    // Obtener una tarjeta por ID
    @GetMapping("/tarjeta/{id}")
    public Tarjeta getTarjeta(@PathVariable Integer id) {
        return tarjetaService.getTarjetaById(id);
    }

    // Obtener todas las tarjetas
    @GetMapping("/tarjetas")
    public List<Tarjeta> getTarjetas() {
        return tarjetaService.getAllTarjetas();
    }

    // Guardar una tarjeta
    @PostMapping("/guardarTarjeta")
    public Tarjeta post(@RequestBody Tarjeta tarjeta) {
        return tarjetaService.saveTarjeta(tarjeta);
    }

    // Editar una tarjeta
    @PutMapping("/editarTarjeta/{id}")
    public String update(@PathVariable Integer id, @RequestBody Tarjeta tarjeta) {
        return tarjetaService.updateTarjeta(id, tarjeta);
    }

    // Eliminar una tarjeta
    @DeleteMapping("/eliminarTarjeta/{id}")
    public String delete(@PathVariable Integer id) {
        return tarjetaService.deleteTarjeta(id);
    }
}

