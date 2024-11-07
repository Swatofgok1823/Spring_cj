package com.Consultorio_spring.consultorio_spring_sql.controladores;

import com.Consultorio_spring.consultorio_spring_sql.Entidades.RecursosLegales;
import com.Consultorio_spring.consultorio_spring_sql.Entidades.Usuarios;
import com.Consultorio_spring.consultorio_spring_sql.servicios.RecursoServicios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/recursos")
public class RecursosControlador {
    @Autowired
    private RecursoServicios servi;

    @GetMapping
    public List<RecursosLegales> getrecurso(){
        return servi.getLista();
    }
    @PostMapping("/agregarr")
    public String addUsuario(@RequestBody RecursosLegales recursos) {
        // Verifica si el documento ya existe
        for (RecursosLegales u : servi.getLista()) {
            if (u.getId_documento() == recursos.getId_documento()) {
                return "El usuario con el documento " + recursos.getId_documento() + " ya existe.";
            }
        }

        // Si el documento no existe, agrega el usuario
        servi.agregar(recursos);
        return "Usuario agregado exitosamente.";
    }

    @PutMapping("/modificar/{id}")
    public String updateRecurso(@PathVariable int id, @RequestBody RecursosLegales recurso) {
        return servi.modificar(id, recurso);
    }

    @DeleteMapping("/eliminar/{id}")
    public String deleteRecurso(@PathVariable int id) {
        return servi.eliminar(id);
    }

}