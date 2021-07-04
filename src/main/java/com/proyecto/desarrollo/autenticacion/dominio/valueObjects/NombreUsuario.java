package com.proyecto.desarrollo.autenticacion.dominio.valueObjects;

public class NombreUsuario {
    private String nombreusuario;

    public NombreUsuario(String nombreusuario) {
        this.nombreusuario = nombreusuario;
    }

    public String getNombreusuario() {
        return nombreusuario;
    }

    public boolean comparar(String nombreusuario_comparar) {
        return nombreusuario.equals(nombreusuario_comparar);
    }
}
