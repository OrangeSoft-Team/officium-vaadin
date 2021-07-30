package com.proyecto.desarrollo.ofertaLaboral.infraestructura.vistas.crearOferta.eventos.creacion;

import com.proyecto.desarrollo.ofertaLaboral.dominio.eventos.OfertaLaboralEvento;
import com.proyecto.desarrollo.ofertaLaboral.dominio.OfertaLaboral;
import com.proyecto.desarrollo.ofertaLaboral.infraestructura.vistas.crearOferta.CrearOfertaLaboral_vista;
import com.vaadin.flow.component.ComponentEvent;


public abstract class EventoOfertaLaboral extends ComponentEvent<CrearOfertaLaboral_vista> {

    private OfertaLaboralEvento contenido;


    public EventoOfertaLaboral(CrearOfertaLaboral_vista source, OfertaLaboral oferta) {
        super(source, false);
        contenido = new OfertaLaboralEvento(oferta);
    }

    public OfertaLaboral getContenido() {
        return contenido.getOfertaLaboral();
    }
}
