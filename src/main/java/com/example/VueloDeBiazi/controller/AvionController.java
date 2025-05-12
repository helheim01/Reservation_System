package com.example.VueloDeBiazi.controller;

import com.example.VueloDeBiazi.entity.Asiento;
import com.example.VueloDeBiazi.entity.Avion;
import com.example.VueloDeBiazi.repository.RepositoryAvion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/aviones")
@CrossOrigin(origins = "http://localhost:8080")
public class AvionController {

    @Autowired
    private RepositoryAvion repositoryAvion;

    // Obtener un avión por ID
    @GetMapping("avion/{id}")
    public Avion getAvion(@PathVariable Integer id) {
        return repositoryAvion.findById(id).get();
    }

    // Obtener todos los aviones
    @GetMapping("aviones")
    public List<Avion> getAviones() {
        return repositoryAvion.findAll();
    }

    // Guardar un avión
    @PostMapping("/guardarAvion")
    public String post(@RequestBody Avion avion) {
        for (Asiento a : avion.getAsientos()) {
            a.setAvion(avion);
        }
        repositoryAvion.save(avion);
        return "AVIÓN GUARDADO";
    }


    // Editar un avión
    @PutMapping("/editarAvion/{id}")
    public String update(@PathVariable Integer id, @RequestBody Avion avion) {
        Avion updateAvion = repositoryAvion.findById(id).get();
        updateAvion.setAsientos(avion.getAsientos());
        repositoryAvion.save(updateAvion);
        return "AVIÓN EDITADO CORRECTAMENTE";
    }

    // Eliminar un avión
    @DeleteMapping("/eliminarAvion/{id}")
    public String delete(@PathVariable Integer id) {
        Avion deleteAvion = repositoryAvion.findById(id).get();
        repositoryAvion.delete(deleteAvion);
        return "AVIÓN ELIMINADO";
    }
}
