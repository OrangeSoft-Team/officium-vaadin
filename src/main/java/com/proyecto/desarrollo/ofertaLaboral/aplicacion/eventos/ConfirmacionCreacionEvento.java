package com.proyecto.desarrollo.ofertaLaboral.aplicacion.eventos;

public class ConfirmacionCreacionEvento {

    private Boolean creacionExitosa;

    public ConfirmacionCreacionEvento(Boolean creacionExitosa) {
        this.creacionExitosa = creacionExitosa;
    }

    public Boolean getCreacionExitosa() {
        return creacionExitosa;
    }
}
