package com.proyecto.desarrollo.autenticacion.infraestructura.persistencia;

import com.proyecto.desarrollo.autenticacion.aplicacion.persistencia.PersistenciaStaff;
import com.proyecto.desarrollo.autenticacion.dominio.excepciones.AutenticacionInvalidaExcepcion;
import com.proyecto.desarrollo.autenticacion.infraestructura.DTO.entrada.DatosBasicosUsuarioEntradaDTO;
import com.proyecto.desarrollo.autenticacion.infraestructura.DTO.entrada.UsuarioAutenticadoFirebaseEntradaDTO;
import com.proyecto.desarrollo.autenticacion.infraestructura.DTO.entrada.UsuarioAutenticadoNestEntradaDTO;
import com.proyecto.desarrollo.autenticacion.infraestructura.DTO.salida.DatosBasicosUsuarioSalidaDTO;
import com.proyecto.desarrollo.autenticacion.infraestructura.DTO.salida.UsuarioAutenticadoFirebaseSalidaDTO;
import com.proyecto.desarrollo.autenticacion.infraestructura.DTO.salida.UsuarioAutenticadoNestSalidaDTO;
import com.proyecto.desarrollo.helpers.infraestructura.http.ManejadorHttp;
import org.apache.commons.io.IOUtils;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;
import java.net.*;


import java.nio.charset.StandardCharsets;
import java.util.*;

public class PersistenciaStaffNest implements PersistenciaStaff {
    private String url_base = new String("https://officium-nest.herokuapp.com");


    @Override
    public String obtenerStaffs(){
        return null;
    }

    @Override
    public UsuarioAutenticadoFirebaseEntradaDTO obtener_token(UsuarioAutenticadoFirebaseSalidaDTO credenciales) throws AutenticacionInvalidaExcepcion{
        UsuarioAutenticadoFirebaseEntradaDTO respuesta = new UsuarioAutenticadoFirebaseEntradaDTO("0OMPgbyAyaNoyNk2");
        return respuesta;
    }

    @Override
    public UsuarioAutenticadoNestEntradaDTO obtener_staff(UsuarioAutenticadoNestSalidaDTO credenciales) throws IOException, ParseException {

        URL url = new URL(this.url_base + "/api/staff/auth");

        JSONObject json_peticion=new JSONObject();
        json_peticion.put("correoElectronico" , credenciales.getCorreo());
        json_peticion.put("token" , credenciales.getToken());

        String respuesta_string = ManejadorHttp.realizar_peticion_post_inicio_sesion(json_peticion , url);

        JSONParser parser = new JSONParser();
        JSONObject json = (JSONObject) parser.parse(respuesta_string);

        UsuarioAutenticadoNestEntradaDTO respuesta = new UsuarioAutenticadoNestEntradaDTO(json.get("primerNombre").toString() , json.get("primerApellido").toString());

        return respuesta;

    }

    @Override
    public DatosBasicosUsuarioEntradaDTO obtener_datos_basicos() throws IOException, ParseException {

        URL url = new URL(this.url_base + "/api/staff/perfil");
        String respuesta_string = ManejadorHttp.realizar_peticion_get(url);
        JSONParser parser = new JSONParser();
        JSONObject json = (JSONObject) parser.parse(respuesta_string);
        DatosBasicosUsuarioEntradaDTO respuesta = new DatosBasicosUsuarioEntradaDTO(json.get("primerNombre").toString() , json.get("primerApellido").toString() , json.get("cargo").toString() , json.get("correoElectronico").toString());

//        DatosBasicosUsuarioEntradaDTO respuesta = new DatosBasicosUsuarioEntradaDTO("Jose" , "Perez" , "cargo" , "correo");
        return respuesta;
    }

    @Override
    public Boolean ingresar_datos_basicos(DatosBasicosUsuarioSalidaDTO peticion) throws IOException, ParseException{
        URL url = new URL(this.url_base + "/api/staff/perfil");

        JSONObject json_peticion=new JSONObject();
        json_peticion.put("primerNombre" , peticion.getPrimer_nombre());
        json_peticion.put("primerApellido" , peticion.getPrimer_apellido());
        json_peticion.put("cargo" , peticion.getCargo());

        ManejadorHttp.realizar_peticion_put(json_peticion , url);
        return true;
    }


}
