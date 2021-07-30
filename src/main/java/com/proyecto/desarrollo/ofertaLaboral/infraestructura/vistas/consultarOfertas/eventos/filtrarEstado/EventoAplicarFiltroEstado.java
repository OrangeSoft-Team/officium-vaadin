package com.proyecto.desarrollo.ofertaLaboral.infraestructura.vistas.consultarOfertas.eventos.filtrarEstado;

import com.proyecto.desarrollo.ofertaLaboral.dominio.eventos.AplicarFiltroEstadoEvento;
import com.proyecto.desarrollo.ofertaLaboral.infraestructura.vistas.consultarOfertas.OfertasTrabajo_vista;
import com.vaadin.flow.component.ComponentEvent;

public abstract class EventoAplicarFiltroEstado extends ComponentEvent<OfertasTrabajo_vista> {

    private AplicarFiltroEstadoEvento estado;

    public EventoAplicarFiltroEstado(OfertasTrabajo_vista source, String estado) {
        super(source, false);
        this.estado = new AplicarFiltroEstadoEvento(estado);
    }

    public String getEstado() {
        return estado.getEstado();
    }
}
