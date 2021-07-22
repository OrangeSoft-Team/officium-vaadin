package com.proyecto.desarrollo.solicitud.infraestructura.vistas.consultaSolicitudes.evento;

import com.proyecto.desarrollo.solicitud.infraestructura.vistas.consultaSolicitudes.ConsultarSolicitudes_vista;

public class AprobadoFallido extends EventoSolicitudLaboral{
    public AprobadoFallido(ConsultarSolicitudes_vista source) {
        super(source, false);
    }
}
