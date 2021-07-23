package com.proyecto.desarrollo.solicitud.infraestructura.vistas.consultaSolicitudes.evento;

import com.proyecto.desarrollo.solicitud.infraestructura.vistas.consultaSolicitudes.ConsultarSolicitudes_vista;

public class AprobadoExitoso extends EventoSolicitudLaboral{

    public AprobadoExitoso(ConsultarSolicitudes_vista source) {
        super(source, true);
    }

}
