package com.example.VueloDeBiazi.controller;

import com.example.VueloDeBiazi.Model.Persona;
import com.example.VueloDeBiazi.service.IPersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/personas")
@CrossOrigin(origins = "http://localhost:8080")
public class PersonaController {

    @Autowired
    private IPersonaService personaService;

    // Obtener una persona por ID
    @GetMapping("/persona/{id}")
    public Persona getPersona(@PathVariable Integer id) {
        return personaService.getPersonaById(id);
    }

    // Obtener todas las personas
    @GetMapping("/personas")
    public List<Persona> getPersonas() {
        return personaService.getAllPersonas();
    }

    // Guardar una persona
    @PostMapping("/guardarPersona")
    public String post(@RequestBody Persona persona) {
        return personaService.savePersona(persona);
    }

    // Editar una persona
    @PutMapping("/editarPersona/{id}")
    public String update(@PathVariable Integer id, @RequestBody Persona persona) {
        return personaService.updatePersona(id, persona);
    }

    // Eliminar una persona
    @DeleteMapping("/eliminarPersona/{id}")
    public String delete(@PathVariable Integer id) {
        return personaService.deletePersona(id);
    }
}

