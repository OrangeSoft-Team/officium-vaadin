package com.proyecto.desarrollo.ofertaLaboral.infraestructura.vistas.consultarOfertas.eventos.cancelarOferta;

import com.proyecto.desarrollo.ofertaLaboral.aplicacion.eventos.CancelarOfertaEvento;
import com.proyecto.desarrollo.ofertaLaboral.infraestructura.vistas.consultarOfertas.OfertasTrabajo_vista;
import com.vaadin.flow.component.ComponentEvent;

public class EventoCancelarOferta extends ComponentEvent<OfertasTrabajo_vista> {

    private CancelarOfertaEvento uuid;

    public EventoCancelarOferta(OfertasTrabajo_vista source, String uuid) {
        super(source, true);
        this.uuid = new CancelarOfertaEvento(uuid);
    }

    public String getUuid() {
        return this.uuid.getUuid();
    }
}
