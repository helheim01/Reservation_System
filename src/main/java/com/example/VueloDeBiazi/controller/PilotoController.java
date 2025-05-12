package com.example.VueloDeBiazi.controller;

import com.example.VueloDeBiazi.entity.Piloto;
import com.example.VueloDeBiazi.repository.RepositoryPiloto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pilotos")
@CrossOrigin(origins = "http://localhost:8080")
public class PilotoController {

    @Autowired
    private RepositoryPiloto repositoryPiloto;

    // Obtener un piloto por ID
    @GetMapping("piloto/{id}")
    public Piloto getPiloto(@PathVariable Integer id) {
        return repositoryPiloto.findById(id).get();
    }

    // Obtener todos los pilotos
    @GetMapping("pilotos")
    public List<Piloto> getPilotos() {
        return repositoryPiloto.findAll();
    }

    // Guardar un piloto
    @PostMapping("/guardarPiloto")
    public String post(@RequestBody Piloto piloto) {
        repositoryPiloto.save(piloto);
        return "PILOTO GUARDADO";
    }

    // Editar un piloto
    @PutMapping("/editarPiloto/{id}")
    public String update(@PathVariable Integer id, @RequestBody Piloto piloto) {
        Piloto updatePiloto = repositoryPiloto.findById(id).get();
        updatePiloto.setDni(piloto.getDni());
        updatePiloto.setNombre(piloto.getNombre());
        updatePiloto.setApellido(piloto.getApellido());
        updatePiloto.setNumeroPiloto(piloto.getNumeroPiloto());
        repositoryPiloto.save(updatePiloto);
        return "PILOTO EDITADO CORRECTAMENTE";
    }

    // Eliminar un piloto
    @DeleteMapping("/eliminarPiloto/{id}")
    public String delete(@PathVariable Integer id) {
        Piloto deletePiloto = repositoryPiloto.findById(id).get();
        repositoryPiloto.delete(deletePiloto);
        return "PILOTO ELIMINADO";
    }
}
