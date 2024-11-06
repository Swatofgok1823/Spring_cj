package com.Consultorio_spring.consultorio_spring_sql.Repositorios;

import com.Consultorio_spring.consultorio_spring_sql.Entidades.GestionCasos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GestionCasoRepositorio extends JpaRepository<GestionCasos, String> {
    List<GestionCasos> findByDocumentoUsuarioOrTipoCaso(String documentoUsuario, String tipoCaso);
    GestionCasos findByNumeroCaso(String numeroCaso);
}