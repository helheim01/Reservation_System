package com.example.VueloDeBiazi.controller;

import com.example.VueloDeBiazi.entity.Vuelo;
import com.example.VueloDeBiazi.repository.RepositoryVuelo;
import com.example.VueloDeBiazi.service.IVueloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vuelos")
@CrossOrigin(origins = "http://localhost:8080")
public class VueloController {

    @Autowired
    private IVueloService vueloService;

    // Obtener un vuelo por ID
    @GetMapping("/vuelo/{id}")
    public Vuelo getVuelo(@PathVariable Integer id) {
        return vueloService.getVueloById(id);
    }

    // Obtener todos los vuelos
    @GetMapping("/vuelos")
    public List<Vuelo> getVuelos() {
        return vueloService.getAllVuelos();
    }

    // Guardar un vuelo
    @PostMapping("/guardarVuelo")
    public String post(@RequestBody Vuelo vuelo) {
        return vueloService.saveVuelo(vuelo);
    }

    // Editar un vuelo
    @PutMapping("/editarVuelo/{id}")
    public String update(@PathVariable Integer id, @RequestBody Vuelo vuelo) {
        return vueloService.updateVuelo(id, vuelo);
    }

    // Eliminar un vuelo
    @DeleteMapping("/eliminarVuelo/{id}")
    public String delete(@PathVariable Integer id) {
        return vueloService.deleteVuelo(id);
    }
}

