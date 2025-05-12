package com.example.VueloDeBiazi.controller;

import com.example.VueloDeBiazi.entity.Pago;
import com.example.VueloDeBiazi.repository.RepositoryPago;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pagos")
@CrossOrigin(origins = "http://localhost:8080")
public class PagoController {

    @Autowired
    private RepositoryPago repositoryPago;

    // Obtener un pago por ID
    @GetMapping("pago/{id}")
    public Pago getPago(@PathVariable Integer id) {
        return repositoryPago.findById(id).get();
    }

    // Obtener todos los pagos
    @GetMapping("pagos")
    public List<Pago> getPagos() {
        return repositoryPago.findAll();
    }

    // Guardar un pago
    @PostMapping("/guardarPago")
    public String post(@RequestBody Pago pago) {
        repositoryPago.save(pago);
        return "PAGO GUARDADO";
    }

    // Editar un pago
    @PutMapping("/editarPago/{id}")
    public String update(@PathVariable Integer id, @RequestBody Pago pago) {
        Pago updatePago = repositoryPago.findById(id).get();
        updatePago.setCantidadPago(pago.getCantidadPago());
        repositoryPago.save(updatePago);
        return "PAGO EDITADO CORRECTAMENTE";
    }

    // Eliminar un pago
    @DeleteMapping("/eliminarPago/{id}")
    public String delete(@PathVariable Integer id) {
        Pago deletePago = repositoryPago.findById(id).get();
        repositoryPago.delete(deletePago);
        return "PAGO ELIMINADO";
    }
}
