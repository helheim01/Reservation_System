package com.example.VueloDeBiazi.service;
import com.example.VueloDeBiazi.entity.Aerolinea;
import com.example.VueloDeBiazi.entity.Aeropuerto;
import com.example.VueloDeBiazi.entity.Persona;
import com.example.VueloDeBiazi.repository.RepositoryPersona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonaServiceImpl implements IPersonaService {

    @Autowired
    private RepositoryPersona repositoryPersona;

    @Override
    public Persona getPersonaById(Integer id){
        return repositoryPersona.findById(id).orElse(null);
    }

    @Override
    public List<Persona> getAllPersonas(){
        return repositoryPersona.findAll();
    }

    @Override
    public String savePersona(Persona persona){
        repositoryPersona.save(persona);
        return "PERSONA GUARDADA";
    }

    @Override
    public String updatePersona(Integer id, Persona persona){
            Persona existente=repositoryPersona.findById(id).orElse(null);
            if(existente!=null){
                existente.setNombre(persona.getNombre());
                existente.setApellido(persona.getApellido());
                existente.setDni(persona.getDni());
                repositoryPersona.save(existente);
                return "PERSONA EDITADA";
            }
            return "NO EXISTE UNA PERSOAN CON ESE ID";

    }

    @Override
    public String deletePersona(Integer id){
        Persona existente=repositoryPersona.findById(id).orElse(null);
        if(existente!=null){
            repositoryPersona.delete(existente);
            return "PERSONA ELIMINADA";
        }
        return "NO EXISTE UNA PERSOAN CON ESE ID";

    }
}
