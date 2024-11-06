package com.Consultorio_spring.consultorio_spring_sql.servicios;

import com.Consultorio_spring.consultorio_spring_sql.Entidades.GestionCasos;
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
}