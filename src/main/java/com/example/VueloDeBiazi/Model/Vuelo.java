package com.example.VueloDeBiazi.Model;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "avion_id")
    private Avion avion;

     @ManyToMany(fetch = FetchType.LAZY)
     @JoinTable(
         name = "vuelo_aeropuerto",
         joinColumns = @JoinColumn(name = "vuelo_id"),
         inverseJoinColumns = @JoinColumn(name = "aeropuerto_id")
     )
     private List<Aeropuerto> aeropuertos = new ArrayList<>();

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "piloto_id")
    private Piloto piloto;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "fecha_id")
    private Fecha fecha;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "aerolinea_id")
    private Aerolinea aerolinea;

    @OneToMany(mappedBy = "vuelo", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Tarifa> tarifas = new ArrayList<>();
}
