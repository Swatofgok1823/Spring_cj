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


    public String modificar(int id, RecursosLegales recursoActualizado) {
        return repositori.findById(id).map(recurso -> {
            recurso.setNombreRecurso(recursoActualizado.getNombreRecurso());
            recurso.setDescripcion(recursoActualizado.getDescripcion());
            recurso.setTipo(recursoActualizado.getTipo());
            recurso.setUrl(recursoActualizado.getUrl());
            repositori.save(recurso);
            return "Recurso modificado exitosamente.";
        }).orElse("Recurso no encontrado.");
    }

    public String eliminar(int id) {
        if (repositori.existsById(id)) {
            repositori.deleteById(id);
            return "Recurso eliminado exitosamente.";
        } else {
            return "Recurso no encontrado.";
        }
    }



}


