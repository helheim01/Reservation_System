package com.example.VueloDeBiazi.controller;

import com.example.VueloDeBiazi.entity.Fecha;
import com.example.VueloDeBiazi.repository.RepositoryFecha;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fechas")
@CrossOrigin(origins = "http://localhost:8080")
public class FechaController {

    @Autowired
    private RepositoryFecha repositoryFecha;

    // Obtener una fecha por ID
    @GetMapping("fecha/{id}")
    public Fecha getFecha(@PathVariable Integer id) {
        return repositoryFecha.findById(id).get();
    }

    // Obtener todas las fechas
    @GetMapping("fechas")
    public List<Fecha> getFechas() {
        return repositoryFecha.findAll();
    }

    // Guardar una fecha
    @PostMapping("/guardarFecha")
    public String post(@RequestBody Fecha fecha) {
        repositoryFecha.save(fecha);
        return "FECHA GUARDADA";
    }

    // Editar una fecha
    @PutMapping("/editarFecha/{id}")
    public String update(@PathVariable Integer id, @RequestBody Fecha fecha) {
        Fecha updateFecha = repositoryFecha.findById(id).get();
        updateFecha.setFecha(fecha.getFecha());
        repositoryFecha.save(updateFecha);
        return "FECHA EDITADA CORRECTAMENTE";
    }

    // Eliminar una fecha
    @DeleteMapping("/eliminarFecha/{id}")
    public String delete(@PathVariable Integer id) {
        Fecha deleteFecha = repositoryFecha.findById(id).get();
        repositoryFecha.delete(deleteFecha);
        return "FECHA ELIMINADA";
    }
}
