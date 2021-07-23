package com.proyecto.desarrollo.ofertaLaboral.dominio.valueObjects;

public class Habilidades {

    private String id;

    private String nombre;

    private String categoria;

    public Habilidades(String id, String nombre, String categoria) {
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
