package com.proyecto.desarrollo.ofertaLaboral.infraestructura.vistas.consultarOfertas.evento;

import com.proyecto.desarrollo.ofertaLaboral.aplicacion.eventos.ConfirmacionCreacionEvento;
import com.proyecto.desarrollo.ofertaLaboral.infraestructura.vistas.consultarOfertas.OfertasTrabajo_vista;
import com.proyecto.desarrollo.ofertaLaboral.infraestructura.vistas.crearOferta.CrearOfertaLaboral_vista;
import com.vaadin.flow.component.ComponentEvent;

public abstract class EventoConfirmacionCreacion  extends ComponentEvent<OfertasTrabajo_vista> {

    private ConfirmacionCreacionEvento exito;

    public EventoConfirmacionCreacion(OfertasTrabajo_vista source, boolean exito) {
        super(source, false);
        this.exito = new ConfirmacionCreacionEvento(exito);
    }

    public ConfirmacionCreacionEvento getExito() {
        return exito;
    }
}
