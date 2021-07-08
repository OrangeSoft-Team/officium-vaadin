package com.proyecto.desarrollo.ofertaLaboral.infraestructura.vistas.consultarOfertas.evento;

import com.proyecto.desarrollo.ofertaLaboral.infraestructura.vistas.consultarOfertas.OfertasTrabajo_vista;

public class CreacionExitosa extends EventoConfirmacionCreacion{

    public CreacionExitosa(OfertasTrabajo_vista source, boolean exito) {
        super(source, exito);
    }

}
