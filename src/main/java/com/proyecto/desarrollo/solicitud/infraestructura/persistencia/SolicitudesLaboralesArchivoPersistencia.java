package com.proyecto.desarrollo.solicitud.infraestructura.persistencia;

import com.proyecto.desarrollo.comunes.infraestructura.persistencia.PersistenciaSolicitudes;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class SolicitudesLaboralesArchivoPersistencia implements PersistenciaSolicitudes {

    @Override
    public String obtenerSolicitudes() throws IOException {
        String contenido;
        contenido = "";
        try{
            contenido = Files.readString(Paths.get("src/main/resources/json/solicitudesLaborales/solicitudesLaborales.json"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return contenido;
    }

    @Override
    public String obtenerDetalle() throws IOException {
        String contenido;
        contenido = "";
        try{
            contenido = Files.readString(Paths.get("src/main/resources/json/solicitudesLaborales/detalleSolicitudLaboral.json"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return contenido;
    }


}
