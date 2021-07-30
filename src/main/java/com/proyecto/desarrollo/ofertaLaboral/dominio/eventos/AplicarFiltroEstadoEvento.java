package com.proyecto.desarrollo.ofertaLaboral.dominio.eventos;

public class AplicarFiltroEstadoEvento {
    private String estado;

    public AplicarFiltroEstadoEvento(String estado) {
        this.estado = estado;
    }

    public String getEstado() {
        return estado;
    }
}
