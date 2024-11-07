package com.Consultorio_spring.consultorio_spring_sql.Repositorios;


import com.Consultorio_spring.consultorio_spring_sql.Entidades.RecursosLegales;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface RecursosRepositorio extends JpaRepository<RecursosLegales, Integer> {

    List<RecursosLegales> findAll();

}


