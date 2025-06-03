package com.example.VueloDeBiazi.controller;

import com.example.VueloDeBiazi.Model.Pago;
import com.example.VueloDeBiazi.service.IPagoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pagos")
@CrossOrigin(origins = "http://localhost:8080")
public class PagoController {

    @Autowired
    private IPagoService pagoService;

    // Obtener un pago por ID
    @GetMapping("/pago/{id}")
    public Pago getPago(@PathVariable Integer id) {
        return pagoService.getPagoById(id);
    }

    // Obtener todos los pagos
    @GetMapping("/pagos")
    public List<Pago> getPagos() {
        return pagoService.getAllPagos();
    }

    // Guardar un pago
    @PostMapping("/guardarPago")
    public String post(@RequestBody Pago pago) {
        return pagoService.savePago(pago);
    }

    // Editar un pago
    @PutMapping("/editarPago/{id}")
    public String update(@PathVariable Integer id, @RequestBody Pago pago) {
        return pagoService.updatePago(id, pago);
    }

    // Eliminar un pago
    @DeleteMapping("/eliminarPago/{id}")
    public String delete(@PathVariable Integer id) {
        return pagoService.deletePago(id);
    }
}
