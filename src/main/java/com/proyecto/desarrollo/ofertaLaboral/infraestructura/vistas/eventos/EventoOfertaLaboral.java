package com.proyecto.desarrollo.ofertaLaboral.infraestructura.vistas.eventos;

import com.proyecto.desarrollo.ofertaLaboral.dominio.OfertaLaboral;
import com.proyecto.desarrollo.ofertaLaboral.infraestructura.vistas.CrearOfertaLaboral_vista;
import com.vaadin.flow.component.ComponentEvent;

public abstract class EventoOfertaLaboral extends ComponentEvent<CrearOfertaLaboral_vista> {

    private com.proyecto.desarrollo.ofertaLaboral.aplicacion.EventoOfertaLaboral contenido;


    public EventoOfertaLaboral(CrearOfertaLaboral_vista source, OfertaLaboral oferta) {
        super(source, false);
        contenido = new com.proyecto.desarrollo.ofertaLaboral.aplicacion.EventoOfertaLaboral(oferta);
    }

    public OfertaLaboral getContenido() {
        return contenido.getOfertaLaboral();
    }
}
