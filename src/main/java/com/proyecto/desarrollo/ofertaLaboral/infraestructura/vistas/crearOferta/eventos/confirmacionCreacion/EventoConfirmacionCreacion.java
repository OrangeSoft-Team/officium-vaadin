package com.proyecto.desarrollo.ofertaLaboral.infraestructura.vistas.crearOferta.eventos.confirmacionCreacion;

import com.proyecto.desarrollo.ofertaLaboral.aplicacion.eventos.ConfirmacionCreacionEvento;
import com.proyecto.desarrollo.ofertaLaboral.infraestructura.vistas.consultarOfertas.OfertasTrabajo_vista;
import com.proyecto.desarrollo.ofertaLaboral.infraestructura.vistas.crearOferta.CrearOfertaLaboral_vista;
import com.vaadin.flow.component.ComponentEvent;

public abstract class EventoConfirmacionCreacion  extends ComponentEvent<CrearOfertaLaboral_vista> {

    private ConfirmacionCreacionEvento exito;

    public EventoConfirmacionCreacion(CrearOfertaLaboral_vista source, boolean exito) {
        super(source, false);
        this.exito = new ConfirmacionCreacionEvento(exito);
    }

    public ConfirmacionCreacionEvento getExito() {
        return exito;
    }
}
