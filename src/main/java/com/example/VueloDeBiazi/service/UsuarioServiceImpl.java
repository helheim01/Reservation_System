package com.example.VueloDeBiazi.service;

import com.example.VueloDeBiazi.entity.Usuario;
import com.example.VueloDeBiazi.repository.RepositoryUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioServiceImpl implements IUsuarioService {

    @Autowired
    private RepositoryUsuario repositoryUsuario;

    @Override
    public Usuario getUsuarioById(Integer id) {
        return repositoryUsuario.findById(id).orElse(null);
    }

    @Override
    public List<Usuario> getAllUsuarios() {
        return repositoryUsuario.findAll();
    }

    @Override
    public String saveUsuario(Usuario usuario) {
        repositoryUsuario.save(usuario);
        return "USUARIO GUARDADO";
    }

    @Override
    public String updateUsuario(Integer id, Usuario usuario) {
        Usuario existente = repositoryUsuario.findById(id).orElse(null);
        if (existente != null) {
            existente.setNumeroUsuario(usuario.getNumeroUsuario());
            existente.setContraseñaUsuario(usuario.getContraseñaUsuario());
            existente.setCorreoElectronicoUsuario(usuario.getCorreoElectronicoUsuario());
            existente.setTarjetas(usuario.getTarjetas());
            existente.setConsultas(usuario.getConsultas());
            existente.setReservas(usuario.getReservas());
            // También podrías actualizar los atributos heredados de Persona si corresponde
            repositoryUsuario.save(existente);
            return "USUARIO ACTUALIZADO";
        }
        return "NO EXISTE USUARIO CON ESE ID";
    }

    @Override
    public String deleteUsuario(Integer id) {
        Usuario existente = repositoryUsuario.findById(id).orElse(null);
        if (existente != null) {
            repositoryUsuario.delete(existente);
            return "USUARIO ELIMINADO";
        }
        return "NO EXISTE USUARIO CON ESE ID";
    }
}
