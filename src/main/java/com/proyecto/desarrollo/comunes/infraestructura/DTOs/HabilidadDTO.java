package com.proyecto.desarrollo.comunes.infraestructura.DTOs;

public class HabilidadDTO {

    private String id;

    private String nombre;

    private String categoria;

    public HabilidadDTO(String id, String nombre, String categoria) {
        this.id = id;
        this.nombre = nombre;
        this.categoria = categoria;
    }

    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCategoria() {
        return categoria;
    }
}
