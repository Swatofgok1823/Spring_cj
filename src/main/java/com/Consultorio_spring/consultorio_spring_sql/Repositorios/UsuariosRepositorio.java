package com.Consultorio_spring.consultorio_spring_sql.Repositorios;

import com.Consultorio_spring.consultorio_spring_sql.Entidades.Usuarios;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuariosRepositorio extends JpaRepository<Usuarios, Integer> {
    // Método para buscar un usuario por su documento
    Optional<Usuarios> findByDocumento(String documento);

    // Método para eliminar un usuario por su documento
    void deleteByDocumento(String documento);
}