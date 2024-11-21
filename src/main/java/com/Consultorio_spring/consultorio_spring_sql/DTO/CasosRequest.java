package com.Consultorio_spring.consultorio_spring_sql.DTO;

import com.Consultorio_spring.consultorio_spring_sql.Entidades.GestionCasos;

public class CasosRequest {

    private String documentoEstudiante;
    private GestionCasos caso;

    public String getDocumentoEstudiante() {
        return documentoEstudiante;
    }

    public void setDocumentoEstudiante(String documentoEstudiante) {
        this.documentoEstudiante = documentoEstudiante;
    }

    public GestionCasos getCaso() {
        return caso;
    }

    public void setCaso(GestionCasos caso) {
        this.caso = caso;
    }
}
