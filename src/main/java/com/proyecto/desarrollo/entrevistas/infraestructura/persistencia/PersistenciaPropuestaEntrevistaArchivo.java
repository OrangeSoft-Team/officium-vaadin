package com.proyecto.desarrollo.entrevistas.infraestructura.persistencia;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.proyecto.desarrollo.comunes.infraestructura.persistencia.PersistenciaPropuestaEntrevistas;
import com.proyecto.desarrollo.entrevistas.infraestructura.DTOs.entrada.ConsultaPropuestaEntrevistaDTO;

import java.io.FileWriter;
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

    @Override
    public Boolean proponerEntrevista(String uuid) {
        ConsultaPropuestaEntrevistaDTO propuesta = new ConsultaPropuestaEntrevistaDTO("1","15/10/2021","Entrevista para Trabajo de conserje","activo","http:://probando.com");
        try{
            ObjectMapper mapper = new ObjectMapper();
            FileWriter writer = new FileWriter("src/main/resources/json/entrevistas/propuestasEntrevistas.json");
            String json = mapper.writeValueAsString(propuesta);
            writer.write(json);
            writer.close();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean cancelarEntrevista(String uuid) {
        ConsultaPropuestaEntrevistaDTO propuesta = new ConsultaPropuestaEntrevistaDTO(null,null,null,null,null);
        try{
            ObjectMapper mapper = new ObjectMapper();
            FileWriter writer = new FileWriter("src/main/resources/json/entrevistas/propuestasEntrevistas.json");
            String json = mapper.writeValueAsString(propuesta);
            writer.write(json);
            writer.close();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return true;
    }

}
