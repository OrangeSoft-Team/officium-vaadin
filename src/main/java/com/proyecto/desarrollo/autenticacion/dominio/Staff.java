package com.proyecto.desarrollo.autenticacion.dominio;

import com.proyecto.desarrollo.autenticacion.dominio.valueObjects.CorreoElectronico;
import com.proyecto.desarrollo.autenticacion.dominio.valueObjects.Nombre;
import com.proyecto.desarrollo.ofertaLaboral.dominio.valueObjects.Cargo;

public class Staff {
    private Nombre primer_nombre;
    private Nombre primer_apellido;
    private Cargo cargo;
    private CorreoElectronico correo;

    public Staff(Nombre primer_nombre, Nombre primer_apellido) {
        this.primer_nombre = primer_nombre;
        this.primer_apellido = primer_apellido;
    }

    public Staff(Nombre primer_nombre, Nombre primer_apellido, Cargo cargo, CorreoElectronico correo) {
        this.primer_nombre = primer_nombre;
        this.primer_apellido = primer_apellido;
        this.cargo = cargo;
        this.correo = correo;
    }

    public Nombre getPrimer_nombre() {
        return primer_nombre;
    }

    public Nombre getPrimer_apellido() {
        return primer_apellido;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public CorreoElectronico getCorreo() {
        return correo;
    }
}
