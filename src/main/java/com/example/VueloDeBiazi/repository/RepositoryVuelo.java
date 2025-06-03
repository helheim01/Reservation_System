package com.example.VueloDeBiazi.repository;

import com.example.VueloDeBiazi.Model.Vuelo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RepositoryVuelo extends JpaRepository<Vuelo, Integer> {

    @Query("""
      SELECT DISTINCT v
      FROM Vuelo v
      JOIN v.aeropuertos a
      WHERE v.aerolinea.id = :aeroId
        AND a.ciudad.id      = :ciudadId
    """)
    List<Vuelo> findByCiudadAndAerolinea(
            @Param("ciudadId")  Integer ciudadId,
            @Param("aeroId")    Integer aerolineaId
    );
}