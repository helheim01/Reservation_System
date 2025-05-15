package com.example.VueloDeBiazi.controller;

import com.example.VueloDeBiazi.entity.Fecha;
import com.example.VueloDeBiazi.repository.RepositoryFecha;
import com.example.VueloDeBiazi.service.IFechaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fechas")
@CrossOrigin(origins = "http://localhost:8080")
public class FechaController {

    @Autowired
    private IFechaService fechaService;

    // Obtener una fecha por ID
    @GetMapping("/fecha/{id}")
    public Fecha getFecha(@PathVariable Integer id) {
        return fechaService.getFechaById(id);
    }

    // Obtener todas las fechas
    @GetMapping("/fechas")
    public List<Fecha> getFechas() {
        return fechaService.getAllFechas();
    }

    // Guardar una fecha
    @PostMapping("/guardarFecha")
    public String post(@RequestBody Fecha fecha) {
        return fechaService.saveFecha(fecha);
    }

    // Editar una fecha
    @PutMapping("/editarFecha/{id}")
    public String update(@PathVariable Integer id, @RequestBody Fecha fecha) {
        return fechaService.updateFecha(id, fecha);
    }

    // Eliminar una fecha
    @DeleteMapping("/eliminarFecha/{id}")
    public String delete(@PathVariable Integer id) {
        return fechaService.deleteFecha(id);
    }
}

