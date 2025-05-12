package com.example.VueloDeBiazi.controller;
import com.example.VueloDeBiazi.entity.Aeropuerto;
import com.example.VueloDeBiazi.repository.RepositoryAeropuerto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/aeropuertos")
@CrossOrigin(origins = "http://localhost:8080")  // Ajustar si usás otro frontend
public class AeropuertoController {

    @Autowired
    private RepositoryAeropuerto repositoryAeropuerto;

    // Obtener un aeropuerto por ID
    @GetMapping("aeropuerto/{id}")
    public Aeropuerto getAeropuerto(@PathVariable Integer id) {
        return repositoryAeropuerto.findById(id).get();
    }

    // Obtener todos los aeropuertos
    @GetMapping
    public List<Aeropuerto> getAeropuertos() {
        return repositoryAeropuerto.findAll();
    }

    // Guardar un aeropuerto
    @PostMapping("/guardarAeropuerto")
    public String post(@RequestBody Aeropuerto aeropuerto) {
        repositoryAeropuerto.save(aeropuerto);
        return "AEROPUERTO GUARDADO";
    }

    // Editar un aeropuerto
    @PutMapping("/editarAeropuerto/{id}")
    public String update(@PathVariable Integer id, @RequestBody Aeropuerto aeropuerto) {
        Aeropuerto updateAeropuerto = repositoryAeropuerto.findById(id).get();
        updateAeropuerto.setNombreAeropuerto(aeropuerto.getNombreAeropuerto());
        updateAeropuerto.setCiudad(aeropuerto.getCiudad());
        repositoryAeropuerto.save(updateAeropuerto);
        return "AEROPUERTO EDITADO CORRECTAMENTE";
    }

    // Eliminar un aeropuerto
    @DeleteMapping("/eliminarAeropuerto/{id}")
    public String delete(@PathVariable Integer id) {
        Aeropuerto deleteAeropuerto = repositoryAeropuerto.findById(id).get();
        repositoryAeropuerto.delete(deleteAeropuerto);
        return "AEROPUERTO ELIMINADO";
    }
}
