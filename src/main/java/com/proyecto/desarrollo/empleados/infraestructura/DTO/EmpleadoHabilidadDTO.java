package com.proyecto.desarrollo.empleados.infraestructura.DTO;

public class EmpleadoHabilidadDTO {
    private String uuid;
    private String nombre;
    private String categoria;

    public EmpleadoHabilidadDTO(String uuid, String nombre, String categoria) {
        this.uuid = uuid;
        this.nombre = nombre;
        this.categoria = categoria;
    }

    public String getUuid() {
        return uuid;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCategoria() {
        return categoria;
    }
}
