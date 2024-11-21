package com.Consultorio_spring.consultorio_spring_sql.servicios;

import com.Consultorio_spring.consultorio_spring_sql.Entidades.GestionCasos;
import com.Consultorio_spring.consultorio_spring_sql.Entidades.Usuarios;
import com.Consultorio_spring.consultorio_spring_sql.Repositorios.GestionCasoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GestionCasosServicios {
    // autowired

    @Autowired
    private GestionCasoRepositorio repository;

    public GestionCasos insertarCaso(GestionCasos caso) {
        return repository.save(caso);
    }

    public GestionCasos crearCaso(GestionCasos caso, Optional<Usuarios> usuario) {
        usuario.ifPresent(caso:: setDocumentoEstudiante);
        return repository.save(caso);
    }

    public List<GestionCasos> consultarListaCasos() {
        return repository.findAll();
    }

    // Método para obtener un caso por número de caso
    public Optional<GestionCasos> consultarCasoPorNumero(String numeroCaso) {
        return repository.findById(numeroCaso);
    }
    public List<GestionCasos> consultarPorDocumento(String documento) {
        return repository.findByDocumentoUsuarioOrTipoCaso(documento, documento);
    }

    public boolean eliminarCaso(String numeroCaso) {
        if (repository.existsById(numeroCaso)) {
            repository.deleteById(numeroCaso);
            return true;
        }
        return false;
    }

    // Método para actualizar un caso existente
    public Optional<GestionCasos> actualizarCaso(String numeroCaso, GestionCasos casoActualizado) {
        return repository.findById(numeroCaso).map(caso -> {
            caso.setNombreUsuario(casoActualizado.getNombreUsuario());
            caso.setApellidoUsuario(casoActualizado.getApellidoUsuario());
            caso.setDocumentoUsuario(casoActualizado.getDocumentoUsuario());
            caso.setTipoCaso(casoActualizado.getTipoCaso());
            caso.setEstadoCas(casoActualizado.getEstadoCas());
            caso.setLinkCarpeta(casoActualizado.getLinkCarpeta());
            caso.setDocumentoEstudiante(casoActualizado.getDocumentoEstudiante());
            return repository.save(caso);
        });
    }
}