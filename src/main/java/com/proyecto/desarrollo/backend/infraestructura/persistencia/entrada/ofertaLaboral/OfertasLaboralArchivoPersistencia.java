package com.proyecto.desarrollo.backend.infraestructura.persistencia.entrada.ofertaLaboral;

import com.proyecto.desarrollo.backend.entidades.ofertaLaboral.aplicacion.PersistenciaOfertaLaboral;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class OfertasLaboralArchivoPersistencia implements PersistenciaOfertaLaboral {

    public String obtenerOfertasLaborales() throws IOException {
        String contenido;
        contenido = "";
        try{
           contenido = Files.readString(Paths.get("src/main/resources/json/ofertasLaborales.json"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return contenido;
    }
}
