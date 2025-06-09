package com.example.VueloDeBiazi.repository;

import com.example.VueloDeBiazi.Model.Vuelo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RepositoryVuelo extends JpaRepository<Vuelo, Integer> {

    //Hice una query principal para filtrar por ciudad y aerolínea
    @Query("""
        SELECT DISTINCT v 
        FROM Vuelo v 
        JOIN v.aeropuertos a 
        WHERE v.aerolinea.id = :aerolineaId 
        AND a.ciudad.id = :ciudadId
    """)
    List<Vuelo> findByCiudadAndAerolinea(
            @Param("ciudadId") Integer ciudadId,
            @Param("aerolineaId") Integer aerolineaId
    );

    //Tuve que hacer otra query con SQL nativo (por si la anterior fallaba xd)
    @Query(value = """
        SELECT DISTINCT v.* 
        FROM vuelo v 
        INNER JOIN vuelo_aeropuerto va ON v.id = va.vuelo_id
        INNER JOIN aeropuerto a ON va.aeropuerto_id = a.id
        INNER JOIN ciudad c ON a.ciudad_id = c.id
        WHERE v.aerolinea_id = :aerolineaId 
        AND c.id = :ciudadId
    """, nativeQuery = true)
    List<Vuelo> findByCiudadAndAerolineaNative(
            @Param("ciudadId") Integer ciudadId,
            @Param("aerolineaId") Integer aerolineaId
    );

    @Query("SELECT v FROM Vuelo v WHERE v.aerolinea.id = :aerolineaId")
    List<Vuelo> findByAerolineaId(@Param("aerolineaId") Integer aerolineaId);

    @Query("""
        SELECT DISTINCT v 
        FROM Vuelo v 
        LEFT JOIN FETCH v.aerolinea 
        LEFT JOIN FETCH v.aeropuertos a
        LEFT JOIN FETCH a.ciudad
    """)
    List<Vuelo> findAllWithDetails();

    //Esta query es para tener los vuelos por ciudad (sin filtro de aerolínea)
    @Query("""
        SELECT DISTINCT v 
        FROM Vuelo v 
        JOIN v.aeropuertos a 
        WHERE a.ciudad.id = :ciudadId
    """)
    List<Vuelo> findByCiudad(@Param("ciudadId") Integer ciudadId);
}