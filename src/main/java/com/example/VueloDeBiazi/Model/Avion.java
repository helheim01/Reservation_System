package com.example.VueloDeBiazi.Model;
import java.io.Serializable;
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

public class Avion implements Serializable, Especificacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int numeroAvion;

    @OneToMany(mappedBy = "avion", cascade = CascadeType.PERSIST, orphanRemoval = true)
    private List<Asiento> asientos = new ArrayList<>();

    @OneToMany(mappedBy = "avion", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Vuelo> vuelos = new ArrayList<>();

    @Override
    public String tipoTurbina() {
        return "Estandar";
    }

    @Override
    public String tipoAvion() {
        return "Avion comercial";
    }
}
