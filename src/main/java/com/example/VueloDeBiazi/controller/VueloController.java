package com.example.VueloDeBiazi.controller;

import com.example.VueloDeBiazi.entity.Vuelo;
import com.example.VueloDeBiazi.repository.RepositoryVuelo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vuelos")
@CrossOrigin(origins = "http://localhost:8080")
public class VueloController {

    @Autowired
    private RepositoryVuelo repositoryVuelo;

    // Obtener un vuelo por ID
    @GetMapping("vuelo/{id}")
    public Vuelo getVuelo(@PathVariable Integer id) {
        return repositoryVuelo.findById(id).get();
    }

    // Obtener todos los vuelos
    @GetMapping("vuelos")
    public List<Vuelo> getVuelos() {
        return repositoryVuelo.findAll();
    }

    // Guardar un vuelo
    @PostMapping("/guardarVuelo")
    public String post(@RequestBody Vuelo vuelo) {
        repositoryVuelo.save(vuelo);
        return "VUELO GUARDADO";
    }

    // Editar un vuelo
    @PutMapping("/editarVuelo/{id}")
    public String update(@PathVariable Integer id, @RequestBody Vuelo vuelo) {
        Vuelo updateVuelo = repositoryVuelo.findById(id).get();
        updateVuelo.setAvion(vuelo.getAvion());
        updateVuelo.setAeropuertos(vuelo.getAeropuertos());
        updateVuelo.setPiloto(vuelo.getPiloto());
        updateVuelo.setFecha(vuelo.getFecha());
        updateVuelo.setAerolinea(vuelo.getAerolinea());
        updateVuelo.setTarifas(vuelo.getTarifas());

        repositoryVuelo.save(updateVuelo);
        return "VUELO EDITADO CORRECTAMENTE";
    }

    // Eliminar un vuelo
    @DeleteMapping("/eliminarVuelo/{id}")
    public String delete(@PathVariable Integer id) {
        Vuelo deleteVuelo = repositoryVuelo.findById(id).get();
        repositoryVuelo.delete(deleteVuelo);
        return "VUELO ELIMINADO";
    }
}
