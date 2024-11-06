package com.Consultorio_spring.consultorio_spring_sql.Entidades;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(name="gestionCasos")
public class GestionCasos {
    @Id
    private String numeroCaso;

    @Column(nullable = false, length = 100)
    private String nombreUsuario;

    @Column(nullable = false, length = 100)
    private String apellidoUsuario;

    @Column(nullable = false, length = 100)
    private String documentoUsuario;

    @Column(nullable = false, length = 100)
    private String tipoCaso;

    @Enumerated(EnumType.STRING)
    private EstadoCas estadoCas;

    @Column(nullable = false, length = 250)
    private String linkCarpeta;

    // Relación con la entidad Usuarios (muchos a uno)
    @Column(name = "documentoEstudiante", nullable = false, length = 100)
    private String documentoEstudiante;

    public GestionCasos() {
    }

    public GestionCasos(String numeroCaso, String nombreUsuario, String apellidoUsuario, String documentoUsuario, String tipoCaso, EstadoCas estadoCas, String linkCarpeta, String documentoEstudiante) {
        this.numeroCaso = numeroCaso;
        this.nombreUsuario = nombreUsuario;
        this.apellidoUsuario = apellidoUsuario;
        this.documentoUsuario = documentoUsuario;
        this.tipoCaso = tipoCaso;
        this.estadoCas = estadoCas;
        this.linkCarpeta = linkCarpeta;
        this.documentoEstudiante = documentoEstudiante; // Se pasa como String
    }

    public String getNumeroCaso() {
        return numeroCaso;
    }

    public void setNumeroCaso(String numeroCaso) {
        this.numeroCaso = numeroCaso;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getApellidoUsuario() {
        return apellidoUsuario;
    }

    public void setApellidoUsuario(String apellidoUsuario) {
        this.apellidoUsuario = apellidoUsuario;
    }

    public String getDocumentoUsuario() {
        return documentoUsuario;
    }

    public void setDocumentoUsuario(String documentoUsuario) {
        this.documentoUsuario = documentoUsuario;
    }

    public String getTipoCaso() {
        return tipoCaso;
    }

    public void setTipoCaso(String tipoCaso) {
        this.tipoCaso = tipoCaso;
    }

    public EstadoCas getEstadoCas() {
        return estadoCas;
    }

    public void setEstadoCas(EstadoCas estadoCas) {
        this.estadoCas = estadoCas;
    }

    public String getLinkCarpeta() {
        return linkCarpeta;
    }

    public void setLinkCarpeta(String linkCarpeta) {
        this.linkCarpeta = linkCarpeta;
    }

    public String getDocumentoEstudiante() {
        return documentoEstudiante;
    }

    public void setDocumentoEstudiante(String documentoEstudiante) {
        this.documentoEstudiante = documentoEstudiante;
    }

    @Override
    public String toString() {
        return "GestionCasos{" +
                "numeroCaso='" + numeroCaso + '\'' +
                ", nombreUsuario='" + nombreUsuario + '\'' +
                ", apellidoUsuario='" + apellidoUsuario + '\'' +
                ", documentoUsuario='" + documentoUsuario + '\'' +
                ", tipoCaso='" + tipoCaso + '\'' +
                ", estadoCas=" + estadoCas +
                ", linkCarpeta='" + linkCarpeta + '\'' +
                ", documentoEstudiante='" + documentoEstudiante + '\'' +
                '}';
    }
}
