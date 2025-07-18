package com.example.VueloDeBiazi.service;

import com.example.VueloDeBiazi.Model.Usuario;

import java.util.List;

public interface IUsuarioService {
    Usuario getUsuarioById(Integer id);
    List<Usuario> getAllUsuarios();
    Usuario saveUsuario(Usuario u);
    String updateUsuario(Integer id, Usuario usuario);
    String deleteUsuario(Integer id);
}
