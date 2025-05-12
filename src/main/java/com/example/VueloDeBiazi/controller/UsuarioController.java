package com.example.VueloDeBiazi.controller;

import com.example.VueloDeBiazi.entity.Usuario;
import com.example.VueloDeBiazi.repository.RepositoryUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
@CrossOrigin(origins = "http://localhost:8080")
public class UsuarioController {

    @Autowired
    private RepositoryUsuario repositoryUsuario;

    // Obtener un usuario por ID
    @GetMapping("usuario/{id}")
    public Usuario getUsuario(@PathVariable Integer id) {
        return repositoryUsuario.findById(id).get();
    }

    // Obtener todos los usuarios
    @GetMapping("usuarios")
    public List<Usuario> getUsuarios() {
        return repositoryUsuario.findAll();
    }

    // Guardar un usuario
    @PostMapping("/guardarUsuario")
    public String post(@RequestBody Usuario usuario) {
        repositoryUsuario.save(usuario);
        return "USUARIO GUARDADO";
    }

    // Editar un usuario
    @PutMapping("/editarUsuario/{id}")
    public String update(@PathVariable Integer id, @RequestBody Usuario usuario) {
        Usuario updateUsuario = repositoryUsuario.findById(id).get();
        updateUsuario.setDni(usuario.getDni());
        updateUsuario.setNombre(usuario.getNombre());
        updateUsuario.setApellido(usuario.getApellido());
        updateUsuario.setNumeroUsuario(usuario.getNumeroUsuario());
        updateUsuario.setContraseñaUsuario(usuario.getContraseñaUsuario());
        updateUsuario.setCorreoElectronicoUsuario(usuario.getCorreoElectronicoUsuario());
        updateUsuario.setTarjetas(usuario.getTarjetas());
        updateUsuario.setConsultas(usuario.getConsultas());
        updateUsuario.setReservas(usuario.getReservas());

        repositoryUsuario.save(updateUsuario);
        return "USUARIO EDITADO CORRECTAMENTE";
    }

    // Eliminar un usuario
    @DeleteMapping("/eliminarUsuario/{id}")
    public String delete(@PathVariable Integer id) {
        Usuario deleteUsuario = repositoryUsuario.findById(id).get();
        repositoryUsuario.delete(deleteUsuario);
        return "USUARIO ELIMINADO";
    }
}
