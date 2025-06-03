package com.example.VueloDeBiazi.Model;
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

public class Asiento implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Basic
    private int filaAsiento;
    private char letraAsiento;
    @Enumerated(EnumType.STRING)
    private Clase clase;
    @ManyToOne
    @JoinColumn(name = "avion_id")
    private Avion avion;
}
