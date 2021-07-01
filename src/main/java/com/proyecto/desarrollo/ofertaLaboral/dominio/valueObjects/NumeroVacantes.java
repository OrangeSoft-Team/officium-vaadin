package com.proyecto.desarrollo.ofertaLaboral.dominio.valueObjects;

public class NumeroVacantes {

    private int vacantes;

    public NumeroVacantes(int vacantes) {
        if (esValido(vacantes))
            this.vacantes = vacantes;
        else this.vacantes = -1;
    }

    public boolean esValido(int vacantes){
        if (vacantes > 0 && vacantes <= 99)
           return true;
        return false;
    }

    public int getVacantes() {
        return vacantes;
    }
}
