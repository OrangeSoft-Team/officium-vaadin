package com.proyecto.desarrollo.comunes.aplicacion;

import com.proyecto.desarrollo.comunes.infraestructura.DTOs.HabilidadDTO;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class HabilidadesMapper {

    private int cont;

    public HabilidadDTO[] jsonToHabilidadesDTO(String contenido) throws ParseException {
        cont = 0;
        JSONParser parser = new JSONParser();
        Object obj = parser.parse(contenido);
        JSONArray habilidades = (JSONArray) obj;
        HabilidadDTO[] habilidadesObtenidaas = new HabilidadDTO[habilidades.size()];
        habilidades.forEach(habi -> {
            habilidadesObtenidaas[cont] = parsearHabilidad((JSONObject) habi);
            cont++;
        });
        return habilidadesObtenidaas;
    }

    public HabilidadDTO parsearHabilidad(JSONObject habilidadJson){
        return new HabilidadDTO(
                (String) habilidadJson.get("uuid"),
                (String) habilidadJson.get("nombre"),
                (String) habilidadJson.get("categoria")
        );
    }
}
