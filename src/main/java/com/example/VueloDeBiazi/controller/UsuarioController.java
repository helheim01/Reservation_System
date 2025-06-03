package com.example.VueloDeBiazi.controller;

import com.example.VueloDeBiazi.Model.Usuario;
import com.example.VueloDeBiazi.service.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
@CrossOrigin(origins = "http://localhost:8080")
public class UsuarioController {

    @Autowired
    private IUsuarioService usuarioService;

    // Obtener un usuario por ID
    @GetMapping("/usuario/{id}")
    public Usuario getUsuario(@PathVariable Integer id) {
        return usuarioService.getUsuarioById(id);
    }

    // Obtener todos los usuarios
    @GetMapping("/usuarios")
    public List<Usuario> getUsuarios() {
        return usuarioService.getAllUsuarios();
    }

    // Guardar un usuario
    @PostMapping("/guardarUsuario")
    public Usuario post(@RequestBody Usuario usuario) {
        return usuarioService.saveUsuario(usuario);
    }

    // Editar un usuario
    @PutMapping("/editarUsuario/{id}")
    public String update(@PathVariable Integer id, @RequestBody Usuario usuario) {
        return usuarioService.updateUsuario(id, usuario);
    }

    // Eliminar un usuario
    @DeleteMapping("/eliminarUsuario/{id}")
    public String delete(@PathVariable Integer id) {
        return usuarioService.deleteUsuario(id);
    }
}
