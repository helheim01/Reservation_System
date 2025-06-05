package com.example.VueloDeBiazi.repository;

import com.example.VueloDeBiazi.Model.Vuelo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RepositoryVuelo extends JpaRepository<Vuelo, Integer> {

    // Query principal para filtrar por ciudad y aerolínea
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

    // Query alternativa usando SQL nativo (por si la JPQL falla)
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

    // Para debugging - solo por aerolínea
    @Query("SELECT v FROM Vuelo v WHERE v.aerolinea.id = :aerolineaId")
    List<Vuelo> findByAerolineaId(@Param("aerolineaId") Integer aerolineaId);

    // Para debugging - traer todos los vuelos con sus relaciones
    @Query("""
        SELECT DISTINCT v 
        FROM Vuelo v 
        LEFT JOIN FETCH v.aerolinea 
        LEFT JOIN FETCH v.aeropuertos a
        LEFT JOIN FETCH a.ciudad
    """)
    List<Vuelo> findAllWithDetails();

    // Query para obtener vuelos por ciudad (sin filtro de aerolínea)
    @Query("""
        SELECT DISTINCT v 
        FROM Vuelo v 
        JOIN v.aeropuertos a 
        WHERE a.ciudad.id = :ciudadId
    """)
    List<Vuelo> findByCiudad(@Param("ciudadId") Integer ciudadId);
}