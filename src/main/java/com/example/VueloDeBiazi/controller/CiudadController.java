package com.example.VueloDeBiazi.controller;
import com.example.VueloDeBiazi.Model.Ciudad;
import com.example.VueloDeBiazi.service.ICiudadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ciudades")
@CrossOrigin(origins = "http://localhost:8080")
public class CiudadController {

    @Autowired
    private ICiudadService ciudadService;

    // Obtener Ciudad por ID
    @GetMapping("/ciudad/{id}")
    public Ciudad getCiudad(@PathVariable Integer id) {
        return ciudadService.getCiudadById(id);
    }

    // Obtener todas las Ciudades
    @GetMapping("/ciudades")
    public List<Ciudad> getCiudades() {
        return ciudadService.getAllCiudades();
    }

    // Guardar Ciudad
    @PostMapping("/guardarCiudad")
    public String post(@RequestBody Ciudad ciudad) {
        return ciudadService.saveCiudad(ciudad);
    }

    // Editar Ciudad
    @PutMapping("/editarCiudad/{id}")
    public String update(@PathVariable Integer id, @RequestBody Ciudad ciudad) {
        return ciudadService.updateCiudad(id, ciudad);
    }

    // Eliminar Ciudad
    @DeleteMapping("/deleteCiudad/{id}")
    public String delete(@PathVariable Integer id) {
        return ciudadService.deleteCiudad(id);
    }
}


