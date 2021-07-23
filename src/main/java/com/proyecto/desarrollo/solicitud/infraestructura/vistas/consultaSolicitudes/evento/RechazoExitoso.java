package com.proyecto.desarrollo.solicitud.infraestructura.vistas.consultaSolicitudes.evento;

import com.proyecto.desarrollo.solicitud.infraestructura.vistas.consultaSolicitudes.ConsultarSolicitudes_vista;

public class RechazoExitoso extends EventoSolicitudLaboral{
    public RechazoExitoso(ConsultarSolicitudes_vista source) {
        super(source, true);
    }
}
