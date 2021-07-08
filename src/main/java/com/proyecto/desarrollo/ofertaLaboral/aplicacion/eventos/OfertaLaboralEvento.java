package com.proyecto.desarrollo.ofertaLaboral.aplicacion.eventos;

import com.proyecto.desarrollo.ofertaLaboral.dominio.OfertaLaboral;

public class OfertaLaboralEvento {

    private OfertaLaboral ofertaLaboral;

    public OfertaLaboralEvento(OfertaLaboral ofertaLaboral) {
        this.ofertaLaboral = ofertaLaboral;
    }

    public OfertaLaboral getOfertaLaboral(){
        return this.ofertaLaboral;
    }
}
