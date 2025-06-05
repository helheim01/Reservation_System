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

public class Reserva implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "pago_id")
    private Pago pago;
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "vuelo_id")
    private Vuelo vuelo;
}
