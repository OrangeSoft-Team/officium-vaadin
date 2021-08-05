package com.proyecto.desarrollo.ofertaLaboral.dominio.valueObjects;

import java.util.Locale;

public class DuracionEstimadaEscala {

    private String escala;

    public DuracionEstimadaEscala(String escala) {
        if (esValido(escala))
            this.escala = escala;
        else this.escala = "invalido";
    }

    public boolean esValido(String escala){
        if (escala.toLowerCase(Locale.ROOT) == "hora" || escala.toLowerCase(Locale.ROOT) == "dia" || escala.toLowerCase(Locale.ROOT) == "semana" || escala.toLowerCase(Locale.ROOT) == "mes" )
            return true;
        return false;
    }

    public String getEscala() {
        return escala;
    }
}
