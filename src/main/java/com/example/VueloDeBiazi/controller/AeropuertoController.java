package com.example.VueloDeBiazi.controller;
import com.example.VueloDeBiazi.entity.Aeropuerto;
import com.example.VueloDeBiazi.repository.RepositoryAeropuerto;
import com.example.VueloDeBiazi.service.AeropuertoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/aeropuertos")
@CrossOrigin(origins = "http://localhost:8080")  // Ajustar si usás otro frontend
public class AeropuertoController {

    @Autowired
    private AeropuertoServiceImpl aeropuertoService;

    // Obtener un aeropuerto por ID
    @GetMapping("aeropuerto/{id}")
    public Aeropuerto getAeropuerto(@PathVariable Integer id) {
        return aeropuertoService.getAeropuertoById(id);
    }

    // Obtener todos los aeropuertos
    @GetMapping
    public List<Aeropuerto> getAeropuertos() {
        return aeropuertoService.getAllAeropuertos();
    }

    // Guardar un aeropuerto
    @PostMapping("/guardarAeropuerto")
    public String post(@RequestBody Aeropuerto aeropuerto) {
        return aeropuertoService.saveAeropuerto(aeropuerto);
    }

    // Editar un aeropuerto
    @PutMapping("/editarAeropuerto/{id}")
    public String update(@PathVariable Integer id, @RequestBody Aeropuerto aeropuerto) {
        return aeropuertoService.updateAeropuerto(id, aeropuerto);

    }

    // Eliminar un aeropuerto
    @DeleteMapping("/eliminarAeropuerto/{id}")
    public String delete(@PathVariable Integer id) {
        return aeropuertoService.deleteAeropuerto(id);

    }
}
