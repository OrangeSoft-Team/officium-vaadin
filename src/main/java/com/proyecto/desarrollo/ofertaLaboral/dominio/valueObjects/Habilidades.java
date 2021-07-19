package com.proyecto.desarrollo.ofertaLaboral.dominio.valueObjects;

public class Habilidades {

    private String uuid;

    private String nombre;

    private String categoria;

    public Habilidades(String id, String nombre, String categoria) {
        this.uuid = id;
        this.nombre = nombre;
        this.categoria = categoria;
    }

    public String getId() {
        return uuid;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCategoria() {
        return categoria;
    }
}
