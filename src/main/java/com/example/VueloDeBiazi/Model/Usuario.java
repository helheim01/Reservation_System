package com.example.VueloDeBiazi.Model;
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
@DiscriminatorValue("Usuario")
public class Usuario extends Persona implements Serializable {
    private String contraseñaUsuario;
    private String correoElectronicoUsuario;
    @OneToMany
    private List<Tarjeta> tarjetas = new ArrayList<>();
    @OneToMany
    private List<Consulta> consultas = new ArrayList<>();
    @OneToMany
    private List<Reserva> reservas = new ArrayList<>();
}
