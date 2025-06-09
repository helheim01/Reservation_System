package com.example.VueloDeBiazi.service;

import com.example.VueloDeBiazi.Model.Usuario;
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
    public Usuario saveUsuario(Usuario u) {
        return repositoryUsuario.save(u);          //Al hacerlo así, me devuelve la entidad guardada con id
    }

    @Override
    public String updateUsuario(Integer id, Usuario usuario) {
        Usuario existente = repositoryUsuario.findById(id).orElse(null);
        if (existente != null) {
            existente.setContraseñaUsuario(usuario.getContraseñaUsuario());
            existente.setCorreoElectronicoUsuario(usuario.getCorreoElectronicoUsuario());
            existente.setTarjetas(usuario.getTarjetas());
            existente.setConsultas(usuario.getConsultas());
            existente.setReservas(usuario.getReservas());
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
