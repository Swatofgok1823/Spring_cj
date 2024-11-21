package com.Consultorio_spring.consultorio_spring_sql.Entidades;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name="Usuarios")
public class Usuarios {
    @Id
    private String documento;

    @Column(nullable = false, length = 50)
    private String nombre;

    @Column(nullable = false, length = 50)
    private String apellido;

    @Column(nullable = false, length = 50)
    private String correo;

    @Column(nullable = false, length = 50)
    private String password;

    @Enumerated(EnumType.STRING)
    private Rol rol;


    @OneToMany(targetEntity = GestionCasos.class,fetch = FetchType.LAZY, mappedBy = "documentoEstudiante")
    private List<GestionCasos> gestionCasos;

    @OneToMany(targetEntity = RecursosLegales.class,fetch = FetchType.LAZY, mappedBy = "documentoUsuario")
    private List<RecursosLegales> recursoslegales;

    public Usuarios() {
    }

    public Usuarios(String documento, String nombre, String apellido, String correo, String password, Rol rol) {
        this.documento = documento;
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.password = password;
        this.rol = rol;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    @Override
    public String toString() {
        return "Usuarios{" +
                "documento=" + documento +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", correo='" + correo + '\'' +
                ", password='" + password + '\'' +
                ", rol=" + rol +
                '}';
    }
}
