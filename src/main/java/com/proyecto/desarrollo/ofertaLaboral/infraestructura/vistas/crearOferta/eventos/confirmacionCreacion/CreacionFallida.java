package com.proyecto.desarrollo.ofertaLaboral.infraestructura.vistas.crearOferta.eventos.confirmacionCreacion;

import com.proyecto.desarrollo.ofertaLaboral.infraestructura.vistas.crearOferta.CrearOfertaLaboral_vista;

public class CreacionFallida extends EventoConfirmacionCreacion{

    public CreacionFallida(CrearOfertaLaboral_vista source) {
        super(source, false);
    }

}
