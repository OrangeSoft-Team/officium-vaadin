package com.proyecto.desarrollo.comunes.infraestructura.persistencia.entrada;

import com.proyecto.desarrollo.comunes.infraestructura.persistencia.PersistenciaHabilidades;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class HabilidadesArchivoPersistencia implements PersistenciaHabilidades {

    @Override
    public String getHabilidadesOfertasLaborales() {
        String contenido;
        contenido = "";
        try{
            contenido = Files.readString(Paths.get("src/main/resources/json/habilidades.json"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return contenido;
    }
}
