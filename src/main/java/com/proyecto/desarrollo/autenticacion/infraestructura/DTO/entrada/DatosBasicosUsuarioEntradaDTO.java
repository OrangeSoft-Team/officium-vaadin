package com.proyecto.desarrollo.autenticacion.infraestructura.DTO.entrada;

public class DatosBasicosUsuarioEntradaDTO {
    private String primer_nombre;
    private String primer_apellido;
    private String cargo;
    private String correo;

    public DatosBasicosUsuarioEntradaDTO(String primer_nombre, String primer_apellido, String cargo, String correo) {
        this.primer_nombre = primer_nombre;
        this.primer_apellido = primer_apellido;
        this.cargo = cargo;
        this.correo = correo;
    }

    public String getPrimer_nombre() {
        return primer_nombre;
    }

    public String getPrimer_apellido() {
        return primer_apellido;
    }

    public String getCorreo() {
        return correo;
    }

    public String getCargo() {
        return cargo;
    }
}
