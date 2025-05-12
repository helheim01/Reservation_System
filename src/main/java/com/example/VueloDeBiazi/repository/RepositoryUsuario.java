package com.example.VueloDeBiazi.repository;

import com.example.VueloDeBiazi.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositoryUsuario extends JpaRepository<Usuario, Integer> {
}
