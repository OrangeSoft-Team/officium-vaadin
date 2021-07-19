package com.proyecto.desarrollo.ofertaLaboral.dominio.valueObjects;

public class RequisitosEspeciales {

    private String requisitosEspeciales;

    public RequisitosEspeciales(String requisitosEspeciales) {
        if (esValido(requisitosEspeciales))
            this.requisitosEspeciales = requisitosEspeciales;
        else this.requisitosEspeciales = "invalido";
    }

    public boolean esValido(String requisitos){
        if (requisitos.length() >= 4 && requisitos.length() <= 256)
            return true;
        return false;
    }

    public String getRequisitosEspeciales() {
        return requisitosEspeciales;
    }
}
