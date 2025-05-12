package com.example.VueloDeBiazi.controller;
import com.example.VueloDeBiazi.entity.Ciudad;
import com.example.VueloDeBiazi.repository.RepositoryCiudad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/ciudades")
@CrossOrigin(origins = "http://localhost:8080")  // Ajustar la URL si es necesario

public class CiudadController {
    @Autowired
    private RepositoryCiudad repositoryCiudad;

    // Obtener Aerolinea por ID
    @GetMapping("ciudad/{id}")
    public Ciudad getCiudad(@PathVariable Integer id) {
        return repositoryCiudad.findById(id).get();
    }

    // Obtener todos los Ciudades
    @GetMapping("ciudades")
    public List<Ciudad> getCiudades() {
        return repositoryCiudad.findAll();
    }

    // Guardar Aerolinea
    @PostMapping("guardarCiudad")
    public String post(@RequestBody Ciudad ciudad) {
        repositoryCiudad.save(ciudad);
        return "CIUDAD GUARDADA";
    }

    // Editar Articulo
    @PutMapping("editarCiudad/{id}")
    public String uptdate(@PathVariable Integer id, @RequestBody Ciudad ciudad) {
        Ciudad uptdateCiudad = repositoryCiudad.findById(id).get();
        uptdateCiudad.setNombreCiudad(ciudad.getNombreCiudad());
        repositoryCiudad.save(uptdateCiudad);

        return "CIUDAD EDITADO CORRECTAMENTE";
    }

    // Eliminar Articulo
    @DeleteMapping("deleteCiudad/{id}")
    public String delete(@PathVariable Integer id) {
        Ciudad deleteCiudad = repositoryCiudad.findById(id).get();
        repositoryCiudad.delete(deleteCiudad);

        return "CIUDAD ELIMINADA";
    }
}

