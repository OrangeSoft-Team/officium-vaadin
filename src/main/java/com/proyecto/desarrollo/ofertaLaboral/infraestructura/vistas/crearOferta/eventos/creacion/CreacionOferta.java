package com.proyecto.desarrollo.ofertaLaboral.infraestructura.vistas.crearOferta.eventos.creacion;

import com.proyecto.desarrollo.ofertaLaboral.dominio.OfertaLaboral;
import com.proyecto.desarrollo.ofertaLaboral.infraestructura.vistas.crearOferta.CrearOfertaLaboral_vista;

public class CreacionOferta extends EventoOfertaLaboral {

    public CreacionOferta(CrearOfertaLaboral_vista source, OfertaLaboral oferta) {
        super(source, oferta);
    }
}
