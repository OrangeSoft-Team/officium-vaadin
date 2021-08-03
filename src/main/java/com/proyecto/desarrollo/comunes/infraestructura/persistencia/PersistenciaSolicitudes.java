package com.proyecto.desarrollo.comunes.infraestructura.persistencia;

import org.json.simple.parser.ParseException;

import java.io.IOException;

public interface PersistenciaSolicitudes {

    public String obtenerSolicitudes() throws IOException, ParseException;

    public String obtenerDetalle(String uuid) throws IOException, ParseException;

    public boolean aceptarSolicitud(String uuid) throws IOException, ParseException;

    public boolean rechazarSolicitud(String uuid) throws IOException;
}
