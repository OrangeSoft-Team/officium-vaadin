package com.proyecto.desarrollo.ofertaLaboral.infraestructura.vistas.consultarOfertas.eventos.filtrarEstado;

import com.proyecto.desarrollo.ofertaLaboral.infraestructura.vistas.consultarOfertas.OfertasTrabajo_vista;

public class EstadoActivo extends EventoAplicarFiltroEstado{
    public EstadoActivo(OfertasTrabajo_vista source) {
        super(source, "PUBLICADO");
    }
}
