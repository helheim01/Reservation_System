package com.example.VueloDeBiazi.service;

import com.example.VueloDeBiazi.entity.Pago;

import java.util.List;

public interface IPagoService {
    Pago getPagoById(Integer id);
    List<Pago> getAllPagos();
    String savePago(Pago pago);
    String updatePago(Integer id, Pago pago);
    String deletePago(Integer id);
}
