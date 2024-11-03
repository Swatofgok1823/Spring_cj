package com.Consultorio_spring.consultorio_spring_sql.servicios;

import com.Consultorio_spring.consultorio_spring_sql.Entidades.Usuarios;
import com.Consultorio_spring.consultorio_spring_sql.Repositorios.UsuariosRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Servicios_Usuarios {

    @Autowired
    private UsuariosRepositorio usuariosRepositorio;

    public List<Usuarios> getLista() {
        return usuariosRepositorio.findAll();
    }

    public void agregar(Usuarios user) {
        usuariosRepositorio.save(user); // Guarda el usuario en la base de datos
    }
}
