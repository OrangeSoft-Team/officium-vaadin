package com.proyecto.desarrollo.ofertaLaboral.dominio.eventos;

public class CancelarOfertaEvento {

    private String uuid;

    public String getUuid() {
        return uuid;
    }

    public CancelarOfertaEvento(String uuid) {
        this.uuid = uuid;
    }
}
