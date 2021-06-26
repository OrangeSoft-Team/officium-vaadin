package com.proyecto.desarrollo.backend.entidades.ofertaLaboral.dominio.valueObjects;

public class DuracionEstimadaValor {

    private int valor;

    public DuracionEstimadaValor(int valor) {
        if (esValido(valor))
            this.valor = valor;
        else this.valor = -1;
    }

    public boolean esValido(int valor){
        if (valor > 0 && valor <= 99)
            return true;
        return false;
    }

    public int getValor() {
        return valor;
    }
}
