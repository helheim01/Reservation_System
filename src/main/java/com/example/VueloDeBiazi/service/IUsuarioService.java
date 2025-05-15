package com.example.VueloDeBiazi.service;

import com.example.VueloDeBiazi.entity.Usuario;

import java.util.List;

public interface IUsuarioService {
    Usuario getUsuarioById(Integer id);
    List<Usuario> getAllUsuarios();
    String saveUsuario(Usuario usuario);
    String updateUsuario(Integer id, Usuario usuario);
    String deleteUsuario(Integer id);
}
