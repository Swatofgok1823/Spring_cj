package com.Consultorio_spring.consultorio_spring_sql.Entidades;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Recursos")
public class RecursosLegales {
    @Id
    private int id_documento;

    @Column(nullable = false,length = 55)
    private String nombreRecurso;


    @Column(nullable = false,length = 250)
    private String descripcion;

    @Column(nullable = false,length = 55)
    private String tipo;

    @Column(nullable = false,length = 254)
    private String url;

    public RecursosLegales() {
    }

    public RecursosLegales(int id_documento, String nombreRecurso, String descripcion, String tipo, String url) {
        this.id_documento = id_documento;
        this.nombreRecurso = nombreRecurso;
        this.descripcion = descripcion;
        this.tipo = tipo;
        this.url = url;
    }

    public int getId_documento() {
        return id_documento;
    }

    public void setId_documento(int id_documento) {
        this.id_documento = id_documento;
    }

    public String getNombreRecurso() {
        return nombreRecurso;
    }

    public void setNombreRecurso(String nombreRecurso) {
        this.nombreRecurso = nombreRecurso;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "RecursosLegales{" +
                "id_documento=" + id_documento +
                ", nombreRecurso='" + nombreRecurso + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", tipo='" + tipo + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
