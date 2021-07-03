package com.proyecto.desarrollo.ofertaLaboral.aplicacion;

import com.proyecto.desarrollo.ofertaLaboral.dominio.OfertaLaboral;

public class EventoOfertaLaboral {

    private OfertaLaboral ofertaLaboral;

    public EventoOfertaLaboral(OfertaLaboral ofertaLaboral) {
        this.ofertaLaboral = ofertaLaboral;
    }

    public OfertaLaboral getOfertaLaboral(){
        return this.ofertaLaboral;
    }
}
