package com.proyecto.desarrollo.solicitud.infraestructura.vistas.consultaSolicitudes.evento.cambioEstado;

import com.proyecto.desarrollo.solicitud.infraestructura.vistas.consultaSolicitudes.ConsultarSolicitudes_vista;

public class RechazoFallido extends  EventoSolicitudLaboral{
    public RechazoFallido(ConsultarSolicitudes_vista source) {
        super(source, false);
    }
}
