package com.example.VueloDeBiazi.controller;

import com.example.VueloDeBiazi.entity.Aerolinea;
import com.example.VueloDeBiazi.service.AerolineaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/aerolineas")
@CrossOrigin(origins = "http://localhost:8080")
public class AerolineaController {

    @Autowired
    private AerolineaServiceImpl aerolineaService;

    @GetMapping("/aerolinea/{id}")
    public Aerolinea getAerolinea(@PathVariable Integer id) {
        return aerolineaService.getAerolineaById(id);
    }

    @GetMapping("/aerolineas")
    public List<Aerolinea> getAerolineas() {
        return aerolineaService.getAllAerolineas();
    }

    @PostMapping("/guardarAerolinea")
    public String post(@RequestBody Aerolinea aerolinea) {
        return aerolineaService.saveAerolinea(aerolinea);
    }

    @PutMapping("/editarAerolinea/{id}")
    public String update(@PathVariable Integer id, @RequestBody Aerolinea aerolinea) {
        return aerolineaService.updateAerolinea(id, aerolinea);
    }

    @DeleteMapping("/deleteAerolinea/{id}")
    public String delete(@PathVariable Integer id) {
        return aerolineaService.deleteAerolinea(id);
    }
}

