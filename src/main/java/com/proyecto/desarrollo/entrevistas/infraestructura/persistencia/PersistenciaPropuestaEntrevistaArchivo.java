package com.proyecto.desarrollo.entrevistas.infraestructura.persistencia;

import com.proyecto.desarrollo.comunes.infraestructura.persistencia.PersistenciaPropuestaEntrevistas;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class PersistenciaPropuestaEntrevistaArchivo implements PersistenciaPropuestaEntrevistas {

    @Override
    public String consultaPropuestaEntrevista(String uuidSolicitud) {
        String contenido;
        contenido = "";
        try{
            contenido = Files.readString(Paths.get("src/main/resources/json/entrevistas/propuestasEntrevistas.json"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return contenido;
    }

}
