package com.proyecto.desarrollo.ofertaLaboral.infraestructura.vistas.consultarOfertas.eventos;

import com.proyecto.desarrollo.ofertaLaboral.infraestructura.vistas.consultarOfertas.OfertasTrabajo_vista;

public class EstadoInactivo extends EventoAplicarFiltroEstado{

    public EstadoInactivo(OfertasTrabajo_vista source) {
        super(source,"inactivo");
    }

}
