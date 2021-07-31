package com.proyecto.desarrollo.autenticacion.dominio;

import com.proyecto.desarrollo.autenticacion.dominio.valueObjects.Nombre;

public class Staff {
    private Nombre primer_nombre;
    private Nombre primer_apellido;

    public Staff(Nombre primer_nombre, Nombre primer_apellido) {
        this.primer_nombre = primer_nombre;
        this.primer_apellido = primer_apellido;
    }

}
