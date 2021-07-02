package com.proyecto.desarrollo.autenticacion.dominio;

import com.proyecto.desarrollo.autenticacion.dominio.valueObjects.Contrasena;
import com.proyecto.desarrollo.autenticacion.dominio.valueObjects.NombreUsuario;

public class Staff {
    private NombreUsuario nombreUsuario;
    private Contrasena contrasena;

    public Staff(NombreUsuario nombreUsuario, Contrasena contrasena) {
        this.nombreUsuario = nombreUsuario;
        this.contrasena = contrasena;
    }

    public Boolean validar_contrasena(String contrasena_s){
        return contrasena.validar_contrasena(contrasena_s);
    }

    public NombreUsuario getNombreUsuario() {
        return nombreUsuario;
    }

    public Contrasena getContrasena() {
        return contrasena;
    }

}
