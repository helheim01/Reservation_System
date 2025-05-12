package com.example.VueloDeBiazi.controller;

import com.example.VueloDeBiazi.entity.Tarjeta;
import com.example.VueloDeBiazi.repository.RepositoryTarjeta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tarjetas")
@CrossOrigin(origins = "http://localhost:8080")
public class TarjetaController {

    @Autowired
    private RepositoryTarjeta repositoryTarjeta;

    // Obtener una tarjeta por ID
    @GetMapping("tarjeta/{id}")
    public Tarjeta getTarjeta(@PathVariable Integer id) {
        return repositoryTarjeta.findById(id).get();
    }

    // Obtener todas las tarjetas
    @GetMapping("tarjetas")
    public List<Tarjeta> getTarjetas() {
        return repositoryTarjeta.findAll();
    }

    // Guardar una tarjeta
    @PostMapping("/guardarTarjeta")
    public String post(@RequestBody Tarjeta tarjeta) {
        repositoryTarjeta.save(tarjeta);
        return "TARJETA GUARDADA";
    }

    // Editar una tarjeta
    @PutMapping("/editarTarjeta/{id}")
    public String update(@PathVariable Integer id, @RequestBody Tarjeta tarjeta) {
        Tarjeta updateTarjeta = repositoryTarjeta.findById(id).get();
        updateTarjeta.setNumeroTarjeta(tarjeta.getNumeroTarjeta());
        updateTarjeta.setTipoTarjeta(tarjeta.getTipoTarjeta());
        updateTarjeta.setCantidadPago(tarjeta.getCantidadPago());  // Heredado de Pago

        repositoryTarjeta.save(updateTarjeta);
        return "TARJETA EDITADA CORRECTAMENTE";
    }

    // Eliminar una tarjeta
    @DeleteMapping("/eliminarTarjeta/{id}")
    public String delete(@PathVariable Integer id) {
        Tarjeta deleteTarjeta = repositoryTarjeta.findById(id).get();
        repositoryTarjeta.delete(deleteTarjeta);
        return "TARJETA ELIMINADA";
    }
}
