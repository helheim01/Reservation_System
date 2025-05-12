package com.example.VueloDeBiazi.entity;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

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

public class Vuelo {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int numeroVuelo;
    @OneToOne
    private Avion avion;
    @OneToMany
    private List<Aeropuerto>aeropuertos=new ArrayList<>();
    @OneToOne
    private Piloto piloto;
    @OneToOne
    private Fecha fecha;
    @OneToOne
    private Aerolinea aerolinea;
    @OneToMany(mappedBy = "vuelo")
    private List<Tarifa>tarifas=new ArrayList<>();
}
