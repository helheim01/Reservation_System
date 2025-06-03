package com.example.VueloDeBiazi.controller;

import com.example.VueloDeBiazi.Model.Asiento;
import com.example.VueloDeBiazi.Model.Avion;
import com.example.VueloDeBiazi.service.IAvionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/aviones")
@CrossOrigin(origins = "http://localhost:8080")
public class AvionController {

    @Autowired
    private IAvionService avionService;

    // Obtener un avión por ID
    @GetMapping("/avion/{id}")
    public Avion getAvion(@PathVariable Integer id) {
        return avionService.getAvionById(id);
    }

    // Obtener todos los aviones
    @GetMapping("/aviones")
    public List<Avion> getAviones() {
        return avionService.getAllAviones();
    }

    // Guardar un avión
    @PostMapping("/guardarAvion")
    public String post(@RequestBody Avion avion) {
        for (Asiento a : avion.getAsientos()) {
            a.setAvion(avion);
        }
        return avionService.saveAvion(avion);
    }

    // Editar un avión
    @PutMapping("/editarAvion/{id}")
    public String update(@PathVariable Integer id, @RequestBody Avion avion) {
        return avionService.updateAvion(id, avion);
    }

    // Eliminar un avión
    @DeleteMapping("/eliminarAvion/{id}")
    public String delete(@PathVariable Integer id) {
        return avionService.deleteAvion(id);
    }
}

