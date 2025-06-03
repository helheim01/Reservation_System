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

public class Tarjeta extends Pago implements Serializable{
    private int numeroTarjeta;
    @Enumerated(EnumType.STRING)
    private TipoTarjeta tipoTarjeta;
}
