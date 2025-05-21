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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Basic
    private int impuestoTarifa;
    private int precioTarifa;
    @Enumerated(EnumType.STRING)
    private Clase claseTarifa;
    @ManyToOne
    private Vuelo vuelo;
}
