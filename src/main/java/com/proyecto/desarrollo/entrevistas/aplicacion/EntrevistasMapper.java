package com.proyecto.desarrollo.entrevistas.aplicacion;

import com.proyecto.desarrollo.entrevistas.infraestructura.DTOs.entrada.ConsultaPropuestaEntrevistaDTO;
import com.proyecto.desarrollo.entrevistas.infraestructura.DTOs.salida.CrearPropuestaEntrevistaDTO;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class EntrevistasMapper {

    private int contador;


    /*Metodo para mappear de json a un DTO de consulta de propuesta*/
    public ConsultaPropuestaEntrevistaDTO jsonToPropuesta(String contenido) throws ParseException {
        JSONParser parser = new JSONParser();
        Object obj = parser.parse(contenido);
        JSONObject propuestaEntrevista = (JSONObject) obj;
        return parsearPropuesta(propuestaEntrevista);
    }

    private ConsultaPropuestaEntrevistaDTO parsearPropuesta(JSONObject propuesta){
        return new ConsultaPropuestaEntrevistaDTO(
                (String) propuesta.get("uuid"),
                (String) propuesta.get("fechaPautada"),
                (String) propuesta.get("asunto"),
                (String) propuesta.get("estatus"),
                (String) propuesta.get("vinculo")
        );
    }

    public CrearPropuestaEntrevistaDTO crearPropuesta(String fecha){
        return new CrearPropuestaEntrevistaDTO(fecha);
    }
}
