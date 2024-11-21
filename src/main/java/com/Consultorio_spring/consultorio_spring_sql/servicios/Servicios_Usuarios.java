package com.Consultorio_spring.consultorio_spring_sql.servicios;

import com.Consultorio_spring.consultorio_spring_sql.Entidades.Usuarios;
import com.Consultorio_spring.consultorio_spring_sql.Repositorios.UsuariosRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class Servicios_Usuarios {

    @Autowired
    private UsuariosRepositorio usuariosRepositorio;

    public List<Usuarios> getLista() {
        return usuariosRepositorio.findAll();
    }

    public Optional<Usuarios> buscarPorDocumento(String documento) {
        return usuariosRepositorio.findById(documento);
    }

    public Optional<Usuarios> getUsuariosById(String documento) {
        return usuariosRepositorio.findById(documento);
    }


    public void agregar(Usuarios user) {
        usuariosRepositorio.save(user); // Guarda el usuario en la base de datos
    }

    public void deleteUsuario(String documento) {
        usuariosRepositorio.deleteById(documento);
    }

    public Usuarios getUsuarioPorDocumento(String documento) {
        return usuariosRepositorio.findById(documento).orElse(null);
    }

    public Usuarios login(String documento, String password, String rol) {
        // Buscar el usuario por documento
        Usuarios usuario = usuariosRepositorio.findById(documento).orElse(null);

        // Verificar si el usuario existe y si la contraseña es correcta y si el rol coincide
        if (usuario != null && usuario.getPassword().equals(password) && usuario.getRol().name().equals(rol)) {
            return usuario; // Retornar el usuario si la autenticación es exitosa
        }
        return null; // Retornar null si las credenciales son incorrectas
    }


    public Usuarios login(String documento, String password) {
        // Buscar el usuario por documento
        Usuarios usuario = usuariosRepositorio.findById(documento).orElse(null);

        // Verificar si el usuario existe y si la contraseña es correcta
        if (usuario != null && usuario.getPassword().equals(password)) {
            return usuario; // Retornar el usuario si la autenticación es exitosa
        }
        return null; // Retornar null si las credenciales son incorrectas
    }

}
