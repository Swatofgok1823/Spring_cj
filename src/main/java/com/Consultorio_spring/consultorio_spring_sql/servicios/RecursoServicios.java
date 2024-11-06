package com.Consultorio_spring.consultorio_spring_sql.servicios;

import com.Consultorio_spring.consultorio_spring_sql.Entidades.RecursosLegales;
import com.Consultorio_spring.consultorio_spring_sql.Entidades.Usuarios;
import com.Consultorio_spring.consultorio_spring_sql.Repositorios.RecursosRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecursoServicios {
    @Autowired
    private RecursosRepositorio repositori;

    public List<RecursosLegales> getLista(){
        return repositori.findAll();
    }
    public void agregar(RecursosLegales recurso) {

        repositori.save(recurso); // Guarda el usuario en la base de datos
    }

}
