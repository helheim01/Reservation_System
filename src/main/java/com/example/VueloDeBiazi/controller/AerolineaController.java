package com.example.VueloDeBiazi.controller;
import com.example.VueloDeBiazi.entity.Aerolinea;
import com.example.VueloDeBiazi.repository.RepositoryAerolinea;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/aerolineas")
@CrossOrigin(origins = "http://localhost:8080")  // Ajustar la URL si es necesario

public class AerolineaController {
    @Autowired
    private RepositoryAerolinea repositoryAerolinea;

    // Obtener Aerolinea por ID
    @GetMapping("aerolinea/{id}")
    public Aerolinea getAerolinea(@PathVariable Integer id) {
        return repositoryAerolinea.findById(id).get();
    }

    // Obtener todos los Aerolineas
    @GetMapping("aerolineas")
    public List<Aerolinea> getAerolineas() {
        return repositoryAerolinea.findAll();
    }

    // Guardar Aerolinea
    @PostMapping("guardarAerolinea")
    public String post(@RequestBody Aerolinea aerolinea) {
        repositoryAerolinea.save(aerolinea);
        return "AEROLINEA GUARDADA";
    }

    // Editar Articulo
    @PutMapping("editarAerolinea/{id}")
    public String uptdate(@PathVariable Integer id, @RequestBody Aerolinea aerolinea) {
        Aerolinea uptdateAerolinea = repositoryAerolinea.findById(id).get();
        uptdateAerolinea.setNombreAerolinea(aerolinea.getNombreAerolinea());
        repositoryAerolinea.save(uptdateAerolinea);

        return "AEROLINEA EDITADO CORRECTAMENTE";
    }

    // Eliminar Articulo
    @DeleteMapping("deleteAerolinea/{id}")
    public String delete(@PathVariable Integer id) {
        Aerolinea deleteAerolinea = repositoryAerolinea.findById(id).get();
        repositoryAerolinea.delete(deleteAerolinea);

        return "AEROLINEA ELIMINADA";
    }

}
