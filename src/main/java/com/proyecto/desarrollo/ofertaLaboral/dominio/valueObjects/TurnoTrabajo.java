package com.proyecto.desarrollo.ofertaLaboral.dominio.valueObjects;

public class TurnoTrabajo {

    private  String turno;

    public TurnoTrabajo(String turno) {
        if (esValido(turno))
            this.turno = turno;
        else this.turno = "invalido";
    }

    public boolean esValido(String turno){
        if (turno == "diurno" || turno == "nocturno"  ||  turno == "mixto")
            return true;
        return false;
    }

    public String getTurno() {
        return turno;
    }
}
