package com.proyecto.desarrollo.empleados.infraestructura.DTO.entrada;

public class EmpleadoEntradaDTO {
    private String uuid;
    private String primerNombre;
    private String primerApellido;
    private String correo;
    private String estatus;
    private String genero;

    public EmpleadoEntradaDTO(String uuid, String primerNombre, String primerApellido, String correo, String estatus, String genero) {
        this.uuid = uuid;
        this.primerNombre = primerNombre;
        this.primerApellido = primerApellido;
        this.correo = correo;
        this.estatus = estatus;
        this.genero = genero;
    }

    public String getUuid() {
        return uuid;
    }

    public String getPrimerNombre() {
        return primerNombre;
    }

    public String getPrimerApellido() {
        return primerApellido;
    }

    public String getCorreo() {
        return correo;
    }

    public String getEstatus() {
        return estatus;
    }

    public String getGenero() {
        return genero;
    }
}
