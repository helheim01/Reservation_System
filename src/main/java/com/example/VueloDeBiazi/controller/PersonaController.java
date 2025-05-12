package com.example.VueloDeBiazi.controller;

import com.example.VueloDeBiazi.entity.Persona;
import com.example.VueloDeBiazi.repository.RepositoryPersona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/personas")
@CrossOrigin(origins = "http://localhost:8080")
public class PersonaController {

    @Autowired
    private RepositoryPersona repositoryPersona;

    // Obtener una persona por ID
    @GetMapping("persona/{id}")
    public Persona getPersona(@PathVariable Integer id) {
        return repositoryPersona.findById(id).get();
    }

    // Obtener todas las personas
    @GetMapping("personas")
    public List<Persona> getPersonas() {
        return repositoryPersona.findAll();
    }

    // Guardar una persona
    @PostMapping("/guardarPersona")
    public String post(@RequestBody Persona persona) {
        repositoryPersona.save(persona);
        return "PERSONA GUARDADA";
    }

    // Editar una persona
    @PutMapping("/editarPersona/{id}")
    public String update(@PathVariable Integer id, @RequestBody Persona persona) {
        Persona updatePersona = repositoryPersona.findById(id).get();
        updatePersona.setDni(persona.getDni());
        updatePersona.setNombre(persona.getNombre());
        updatePersona.setApellido(persona.getApellido());
        repositoryPersona.save(updatePersona);
        return "PERSONA EDITADA CORRECTAMENTE";
    }

    // Eliminar una persona
    @DeleteMapping("/eliminarPersona/{id}")
    public String delete(@PathVariable Integer id) {
        Persona deletePersona = repositoryPersona.findById(id).get();
        repositoryPersona.delete(deletePersona);
        return "PERSONA ELIMINADA";
    }
}
