package com.example.VueloDeBiazi.controller;

import com.example.VueloDeBiazi.Model.Asiento;
import com.example.VueloDeBiazi.service.IAsientoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/asientos")
@CrossOrigin(origins = "http://localhost:8080")
public class AsientoController {

    @Autowired
    private IAsientoService asientoService;

    // Obtener asiento por ID
    @GetMapping("/asiento/{id}")
    public Asiento getAsiento(@PathVariable Integer id) {
        return asientoService.getAsientoById(id);
    }

    // Obtener todos los asientos
    @GetMapping("/asientos")
    public List<Asiento> getAsientos() {
        return asientoService.getAllAsientos();
    }

    // Guardar un asiento
    @PostMapping("/guardarAsiento")
    public String post(@RequestBody Asiento asiento) {
        return asientoService.saveAsiento(asiento);
    }

    // Editar asiento
    @PutMapping("/editarAsiento/{id}")
    public String update(@PathVariable Integer id, @RequestBody Asiento asiento) {
        return asientoService.updateAsiento(id, asiento);
    }

    // Eliminar asiento
    @DeleteMapping("/eliminarAsiento/{id}")
    public String delete(@PathVariable Integer id) {
        return asientoService.deleteAsiento(id);
    }
}
