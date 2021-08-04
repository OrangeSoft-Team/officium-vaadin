package com.proyecto.desarrollo.empleados.infraestructura.persistencia;

import com.proyecto.desarrollo.empleados.aplicacion.persistencia.PersistenciaEmpleado;
import com.proyecto.desarrollo.empleados.infraestructura.DTO.EmpleadoExperienciaDTO;
import com.proyecto.desarrollo.empleados.infraestructura.DTO.EmpleadoHabilidadDTO;
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
    public EmpleadoDetalleEntradaDTO obtener_detalle_empleado(EmpleadoDetalleSalidaDTO credenciales) throws IOException, ParseException {

        URL url = new URL(this.url_base + "/api/staff/empleados/" + credenciales.getUuid());
        String respuesta_string = ManejadorHttp.realizar_peticion_get(url);

        JSONParser parser = new JSONParser();
        JSONObject json = (JSONObject) parser.parse(respuesta_string);

        EmpleadoDetalleEntradaDTO empleado_detalle = new EmpleadoDetalleEntradaDTO();

        if (json.get("uuid") != null) {
            empleado_detalle.setUuid(json.get("uuid").toString());
        }
        if (json.get("primerNombre") != null) {
            empleado_detalle.setPrimerNombre(json.get("primerNombre").toString());
        }
        if (json.get("segundoNombre") != null) {
            empleado_detalle.setSegundoNombre(json.get("segundoNombre").toString());
        }
        if (json.get("primerApellido") != null) {
            empleado_detalle.setPrimerApellido(json.get("primerApellido").toString());
        }
        if (json.get("segundoApellido") != null) {
            empleado_detalle.setSegundoApellido(json.get("segundoApellido").toString());
        }
        if (json.get("correo") != null) {
            empleado_detalle.setCorreo(json.get("correo").toString());
        }
        if (json.get("genero") != null) {
            empleado_detalle.setGenero(json.get("genero").toString());
        }
        if (json.get("estatus") != null) {
            empleado_detalle.setEstatus(json.get("estatus").toString());
        }
        if (json.get("fechaNacimiento") != null) {
            empleado_detalle.setFechaNacimiento(json.get("fechaNacimiento").toString());
        }
        if (json.get("calleUno") != null) {
            empleado_detalle.setCalleUno(json.get("calleUno").toString());
        }
        if (json.get("calleDos") != null) {
            empleado_detalle.setCalleDos(json.get("calleDos").toString());
        }
        if (json.get("codigoPostal") != null) {
            empleado_detalle.setCodigoPostal(json.get("codigoPostal").toString());
        }
        if (json.get("nombrePais") != null) {
            empleado_detalle.setNombrePais(json.get("nombrePais").toString());
        }
        if (json.get("nombreEstado") != null) {
            empleado_detalle.setNombreEstado(json.get("nombreEstado").toString());
        }
        if (json.get("nombreCiudad") != null) {
            empleado_detalle.setNombreCiudad(json.get("nombreCiudad").toString());
        }


        ArrayList<EmpleadoHabilidadDTO> empleado_habilidades = new ArrayList<EmpleadoHabilidadDTO>();
        JSONArray json_habilidades = (JSONArray) parser.parse(json.get("habilidades").toString());
        json_habilidades.forEach(item -> {
            JSONObject j_habilidad = (JSONObject) item;
            empleado_habilidades.add( new EmpleadoHabilidadDTO(j_habilidad.get("uuid").toString() , j_habilidad.get("nombre").toString() , j_habilidad.get("categoria").toString()) );
        });
        empleado_detalle.setHabilidades(empleado_habilidades);


        ArrayList<EmpleadoExperienciaDTO> empleado_experiencia = new ArrayList<EmpleadoExperienciaDTO>();
        JSONArray json_experiencias = (JSONArray) parser.parse(json.get("experienciasLaborales").toString());
        json_experiencias.forEach(itemm -> {
            JSONObject j_experiencia = (JSONObject) itemm;
            empleado_experiencia.add(new EmpleadoExperienciaDTO(j_experiencia.get("uuid").toString() , j_experiencia.get("cargo").toString() , j_experiencia.get("nombreEmpresa").toString() , j_experiencia.get("fechaInicio").toString() , j_experiencia.get("fechaFin").toString()));
        });
        empleado_detalle.setExperiencias(empleado_experiencia);

        return empleado_detalle;


    }



}
