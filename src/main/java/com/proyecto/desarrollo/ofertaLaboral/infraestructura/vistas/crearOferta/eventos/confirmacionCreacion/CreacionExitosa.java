package com.proyecto.desarrollo.ofertaLaboral.infraestructura.vistas.crearOferta.eventos.confirmacionCreacion;

import com.proyecto.desarrollo.ofertaLaboral.infraestructura.vistas.consultarOfertas.OfertasTrabajo_vista;
import com.proyecto.desarrollo.ofertaLaboral.infraestructura.vistas.crearOferta.CrearOfertaLaboral_vista;

public class CreacionExitosa extends EventoConfirmacionCreacion{

    public CreacionExitosa(CrearOfertaLaboral_vista source) {
        super(source, true);
    }

}
