package com.example.VueloDeBiazi.entity;
import java.io.Serializable;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity

public class Tarifa implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int numeroTarifa;
    @Basic
    private int impuestoTarifa;
    private int precioTarifa;
    private Clase claseTarifa;
    @ManyToOne
    private Vuelo vuelo;
}
