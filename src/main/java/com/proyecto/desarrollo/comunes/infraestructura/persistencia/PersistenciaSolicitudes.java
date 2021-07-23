package com.proyecto.desarrollo.comunes.infraestructura.persistencia;

import java.io.IOException;

public interface PersistenciaSolicitudes {

    public String obtenerSolicitudes() throws IOException;

    public String obtenerDetalle() throws IOException;

    public boolean aceptarSolicitud(String uuid) throws IOException;

    public boolean rechazarSolicitud(String uuid) throws IOException;
}
