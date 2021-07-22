package com.proyecto.desarrollo.solicitud.infraestructura.persistencia;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.proyecto.desarrollo.comunes.infraestructura.persistencia.PersistenciaSolicitudes;
import com.proyecto.desarrollo.solicitud.aplicacion.SolicitudMapper;
import com.proyecto.desarrollo.solicitud.infraestructura.DTO.SolicitudLaboralDTO;
import org.json.simple.parser.ParseException;

import java.io.FileWriter;
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

    @Override
    public boolean aceptarSolicitud(String uuid) throws IOException {
        SolicitudMapper mapper = new SolicitudMapper();
        try{
            SolicitudLaboralDTO[] solicitudes = mapper.jsonToGrid(obtenerSolicitudes());
            for (int i = 0;i< solicitudes.length;i++){
                if (solicitudes[i].getUuid().equals(uuid)){
                    solicitudes[i].setEstatus("aprobado");
                    FileWriter writer = new FileWriter("src/main/resources/json/solicitudesLaborales/solicitudesLaborales.json");
                    ObjectMapper mapperJson = new ObjectMapper();
                    String json = mapperJson.writeValueAsString(solicitudes);
                    writer.write(json);
                    writer.close();
                    return true;
                }
            }
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
        return false;
    }


}
