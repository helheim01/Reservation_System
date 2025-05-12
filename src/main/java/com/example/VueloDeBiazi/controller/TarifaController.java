package com.example.VueloDeBiazi.controller;

import com.example.VueloDeBiazi.entity.Tarifa;
import com.example.VueloDeBiazi.repository.RepositoryTarifa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tarifas")
@CrossOrigin(origins = "http://localhost:8080")
public class TarifaController {

    @Autowired
    private RepositoryTarifa repositoryTarifa;

    // Obtener una tarifa por ID
    @GetMapping("tarifa/{id}")
    public Tarifa getTarifa(@PathVariable Integer id) {
        return repositoryTarifa.findById(id).get();
    }

    // Obtener todas las tarifas
    @GetMapping("tarifas")
    public List<Tarifa> getTarifas() {
        return repositoryTarifa.findAll();
    }

    // Guardar una tarifa
    @PostMapping("/guardarTarifa")
    public String post(@RequestBody Tarifa tarifa) {
        repositoryTarifa.save(tarifa);
        return "TARIFA GUARDADA";
    }

    // Editar una tarifa
    @PutMapping("/editarTarifa/{id}")
    public String update(@PathVariable Integer id, @RequestBody Tarifa tarifa) {
        Tarifa updateTarifa = repositoryTarifa.findById(id).get();
        updateTarifa.setImpuestoTarifa(tarifa.getImpuestoTarifa());
        updateTarifa.setPrecioTarifa(tarifa.getPrecioTarifa());
        updateTarifa.setClaseTarifa(tarifa.getClaseTarifa());
        updateTarifa.setVuelo(tarifa.getVuelo());

        repositoryTarifa.save(updateTarifa);
        return "TARIFA EDITADA CORRECTAMENTE";
    }

    // Eliminar una tarifa
    @DeleteMapping("/eliminarTarifa/{id}")
    public String delete(@PathVariable Integer id) {
        Tarifa deleteTarifa = repositoryTarifa.findById(id).get();
        repositoryTarifa.delete(deleteTarifa);
        return "TARIFA ELIMINADA";
    }
}
