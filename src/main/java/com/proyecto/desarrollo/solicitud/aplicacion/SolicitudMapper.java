package com.proyecto.desarrollo.solicitud.aplicacion;

import com.proyecto.desarrollo.ofertaLaboral.infraestructura.DTO.entrada.OfertaLaboralConsultaDTO;
import com.proyecto.desarrollo.solicitud.infraestructura.DTO.SolicitudLaboralDTO;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class SolicitudMapper {

    private SolicitudLaboralDTO[] solicitudesObtenidas;
    private int cont;

    public SolicitudLaboralDTO[] jsonToGrid(String contenido) throws ParseException {
        cont = 0;
        /*Se instancia un parser*/
        JSONParser parser = new JSONParser();
        /*Se parsea el contenido del Json*/
        Object obj = parser.parse(contenido);
        /*Se obtienen las solicitudes del json*/
        JSONArray solicitudes = (JSONArray) obj;
        /*Se crea una instancia un array de SolicitudLaboralDTO con el tamaño de las solicitudes que se obtuvieron del json*/
        this.solicitudesObtenidas = new SolicitudLaboralDTO[solicitudes.size()];
        /*Se llena el array de solicitudes*/
        solicitudes.forEach(sol -> parsearSolicitudes((JSONObject) sol));
        return this.solicitudesObtenidas;

    }

    private void parsearSolicitudes(JSONObject sol) {
        this.solicitudesObtenidas[cont] = new SolicitudLaboralDTO(
                (String) sol.get("uuid"),
                (String) sol.get("tituloOferta"),
                (String) sol.get("cargoOferta"),
                (String) sol.get("estado"),
                (String) sol.get("nombreEmpresa"),
                (String) sol.get("nombreEmpleado")
        );
        cont++;
    }
}
