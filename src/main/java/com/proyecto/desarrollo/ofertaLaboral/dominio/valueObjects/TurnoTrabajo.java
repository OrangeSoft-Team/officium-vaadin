package com.proyecto.desarrollo.ofertaLaboral.dominio.valueObjects;

import java.util.Locale;

public class TurnoTrabajo {

    private  String turno;

    public TurnoTrabajo(String turno) {
        if (esValido(turno))
            this.turno = turno;
        else this.turno = "invalido";
    }

    public boolean esValido(String turno){
        if (turno.toLowerCase(Locale.ROOT) == "diurno" || turno.toLowerCase() == "nocturno"  ||  turno.toLowerCase(Locale.ROOT) == "mixto")
            return true;
        return false;
    }

    public String getTurno() {
        return turno;
    }
}
