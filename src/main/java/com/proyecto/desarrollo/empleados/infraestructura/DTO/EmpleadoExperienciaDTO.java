package com.proyecto.desarrollo.empleados.infraestructura.DTO;

public class EmpleadoExperienciaDTO {
    private String uuid;
    private String cargo;
    private String nombreEmpresa;
    private String fechaInicio;
    private String fechaFin;

    public EmpleadoExperienciaDTO(String uuid, String cargo, String nombreEmpresa, String fechaInicio, String fechaFin) {
        this.uuid = uuid;
        this.cargo = cargo;
        this.nombreEmpresa = nombreEmpresa;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
    }

    public String getUuid() {
        return uuid;
    }

    public String getCargo() {
        return cargo;
    }

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public String getFechaFin() {
        return fechaFin;
    }
}
