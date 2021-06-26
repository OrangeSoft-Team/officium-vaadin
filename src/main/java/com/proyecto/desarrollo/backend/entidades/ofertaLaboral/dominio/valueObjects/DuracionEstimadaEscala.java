package com.proyecto.desarrollo.backend.entidades.ofertaLaboral.dominio.valueObjects;

public class DuracionEstimadaEscala {

    private String escala;

    public DuracionEstimadaEscala(String escala) {
        if (esValido(escala))
            this.escala = escala;
        else this.escala = "invalido";
    }

    public boolean esValido(String escala){
        if (escala == "hora" || escala == "dia" || escala == "semana" || escala == "mes")
            return true;
        return false;
    }

    public String getEscala() {
        return escala;
    }
}