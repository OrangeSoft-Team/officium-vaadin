package com.proyecto.desarrollo.comunes.infraestructura.DTOs;

public class HabilidadDTO {

    private String uuid;

    private String nombre;

    private String categoria;

    public HabilidadDTO(String uuid, String nombre, String categoria) {
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
