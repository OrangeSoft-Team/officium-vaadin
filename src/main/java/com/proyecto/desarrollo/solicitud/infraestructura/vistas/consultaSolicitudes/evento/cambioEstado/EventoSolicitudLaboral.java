package com.proyecto.desarrollo.solicitud.infraestructura.vistas.consultaSolicitudes.evento.cambioEstado;

import com.proyecto.desarrollo.solicitud.dominio.eventos.SolicitudEvento;
import com.proyecto.desarrollo.solicitud.infraestructura.vistas.consultaSolicitudes.ConsultarSolicitudes_vista;
import com.vaadin.flow.component.ComponentEvent;

public abstract class EventoSolicitudLaboral extends ComponentEvent<ConsultarSolicitudes_vista> {

    private SolicitudEvento creado;

    public EventoSolicitudLaboral(ConsultarSolicitudes_vista source, boolean exito) {
        super(source, true);
        this.creado = new SolicitudEvento(exito);
    }

    public SolicitudEvento getCreado() {
        return creado;
    }
}
