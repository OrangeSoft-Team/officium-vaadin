package com.proyecto.desarrollo.empleados.infraestructura.persistencia;

import com.proyecto.desarrollo.empleados.aplicacion.persistencia.PersistenciaEmpleado;
import com.proyecto.desarrollo.empleados.infraestructura.DTO.entrada.EmpleadoDetalleEntradaDTO;
import com.proyecto.desarrollo.empleados.infraestructura.DTO.entrada.EmpleadoEntradaDTO;
import com.proyecto.desarrollo.empleados.infraestructura.DTO.salida.EmpleadoDetalleSalidaDTO;
import com.proyecto.desarrollo.helpers.infraestructura.http.ManejadorHttp;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

public class PersistenciaEmpleadoNest implements PersistenciaEmpleado {

    private String url_base = new String("https://officium-nest.herokuapp.com");

    @Override
    public ArrayList<EmpleadoEntradaDTO> obtener_lista_empleados() throws IOException, ParseException {
        ArrayList<EmpleadoEntradaDTO> lista_empleados = new ArrayList<EmpleadoEntradaDTO>();

        URL url = new URL(this.url_base + "/api/staff/empleados");
        String respuesta_string = ManejadorHttp.realizar_peticion_get(url);

        JSONParser parser = new JSONParser();
        JSONArray json = (JSONArray) parser.parse(respuesta_string);
        json.forEach(item -> {
            JSONObject item_jsonobj = (JSONObject) item;
            lista_empleados.add(new EmpleadoEntradaDTO(item_jsonobj.get("uuid").toString() , item_jsonobj.get("primerNombre").toString() , item_jsonobj.get("primerApellido").toString() , item_jsonobj.get("correo").toString() , item_jsonobj.get("estatus").toString() , item_jsonobj.get("genero").toString()));
        });

        return lista_empleados;
    }

    @Override
    public EmpleadoDetalleEntradaDTO obtener_detalle_empleado(EmpleadoDetalleSalidaDTO credenciales) throws IOException {
        return null;
    }



}
