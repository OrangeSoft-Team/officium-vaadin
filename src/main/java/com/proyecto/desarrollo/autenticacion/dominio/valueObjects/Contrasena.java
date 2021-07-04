package com.proyecto.desarrollo.autenticacion.dominio.valueObjects;

public class Contrasena {
    private String contrasena;

    public Contrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getContrasena() {
        return contrasena;
    }

//    verifica si la contrasena es valida
    public boolean esValido(String contrasena){
        if (contrasena.length() >= 4 && contrasena.length() <= 25 )
            return true;
        return false;
    }

    public boolean validar_contrasena(String contrasena_s) {
        return contrasena.equals(contrasena_s);
    }
}
