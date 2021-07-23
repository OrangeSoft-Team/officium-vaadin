package com.proyecto.desarrollo.solicitud.aplicacion.eventos;

public class SolicitudEvento {

    private boolean creado;

    public SolicitudEvento(boolean creado) {
        this.creado = creado;
    }

    public boolean isCreado() {
        return creado;
    }
}
