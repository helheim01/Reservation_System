package com.example.VueloDeBiazi.controller;

import com.example.VueloDeBiazi.entity.Asiento;
import com.example.VueloDeBiazi.repository.RepositoryAsiento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/asientos")
@CrossOrigin(origins = "http://localhost:8080")
public class AsientoController {

    @Autowired
    private RepositoryAsiento repositoryAsiento;

    // Obtener asiento por ID
    @GetMapping("asiento/{id}")
    public Asiento getAsiento(@PathVariable Integer id) {
        return repositoryAsiento.findById(id).get();
    }

    // Obtener todos los asientos
    @GetMapping("asientos")
    public List<Asiento> getAsientos() {
        return repositoryAsiento.findAll();
    }

    // Guardar un asiento
    @PostMapping("/guardarAsiento")
    public String post(@RequestBody Asiento asiento) {
        repositoryAsiento.save(asiento);
        return "ASIENTO GUARDADO";
    }

    // Editar asiento
    @PutMapping("/editarAsiento/{id}")
    public String update(@PathVariable Integer id, @RequestBody Asiento asiento) {
        Asiento updateAsiento = repositoryAsiento.findById(id).get();
        updateAsiento.setFilaAsiento(asiento.getFilaAsiento());
        updateAsiento.setLetraAsiento(asiento.getLetraAsiento());
        updateAsiento.setClase(asiento.getClase());
        updateAsiento.setAvion(asiento.getAvion());
        repositoryAsiento.save(updateAsiento);
        return "ASIENTO EDITADO CORRECTAMENTE";
    }

    // Eliminar asiento
    @DeleteMapping("/eliminarAsiento/{id}")
    public String delete(@PathVariable Integer id) {
        Asiento deleteAsiento = repositoryAsiento.findById(id).get();
        repositoryAsiento.delete(deleteAsiento);
        return "ASIENTO ELIMINADO";
    }
}
