package com.proyecto.desarrollo.backend.entidades.ofertaLaboral.dominio.valueObjects;

public class Descripcion {

    private String descripcion;

    public Descripcion(String descripcion) {
        if (esValido(descripcion))
            this.descripcion = descripcion;
        else this.descripcion = "invalido";
    }

    public boolean esValido(String descripcion){
        if (descripcion.length() >= 32 && descripcion.length() <= 512)
            return true;
        return false;
    }

    public String getDescripcion() {
        return descripcion;
    }
}
