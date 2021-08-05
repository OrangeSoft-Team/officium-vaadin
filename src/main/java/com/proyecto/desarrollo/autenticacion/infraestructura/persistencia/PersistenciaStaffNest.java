package com.proyecto.desarrollo.autenticacion.infraestructura.persistencia;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.common.collect.Lists;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.UserRecord;
import com.proyecto.desarrollo.autenticacion.aplicacion.persistencia.PersistenciaStaff;
import com.proyecto.desarrollo.autenticacion.dominio.excepciones.AutenticacionInvalidaExcepcion;
import com.proyecto.desarrollo.autenticacion.infraestructura.DTO.entrada.DatosBasicosUsuarioEntradaDTO;
import com.proyecto.desarrollo.autenticacion.infraestructura.DTO.entrada.UsuarioAutenticadoFirebaseEntradaDTO;
import com.proyecto.desarrollo.autenticacion.infraestructura.DTO.entrada.UsuarioAutenticadoNestEntradaDTO;
import com.proyecto.desarrollo.autenticacion.infraestructura.DTO.salida.DatosBasicosUsuarioSalidaDTO;
import com.proyecto.desarrollo.autenticacion.infraestructura.DTO.salida.UsuarioAutenticadoFirebaseSalidaDTO;
import com.proyecto.desarrollo.autenticacion.infraestructura.DTO.salida.UsuarioAutenticadoNestSalidaDTO;
import com.proyecto.desarrollo.helpers.infraestructura.http.ManejadorHttp;

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

    public UsuarioAutenticadoFirebaseEntradaDTO obtener_token(UsuarioAutenticadoFirebaseSalidaDTO credenciales) throws AutenticacionInvalidaExcepcion, IOException, ParseException {

        URL url = new URL("https://identitytoolkit.googleapis.com/v1/accounts:signInWithPassword?key=AIzaSyAlpmRnWovaKQHDx57oW62H5veuv-xCbvk");

        JSONObject json_peticion=new JSONObject();
        json_peticion.put("email" , credenciales.getCorreo());
        json_peticion.put("password" , credenciales.getContrasena());
        json_peticion.put("returnSecureToken" , true);

        String respuesta_string = ManejadorHttp.realizar_peticion_post_inicio_sesion(json_peticion , url);

        JSONParser parser = new JSONParser();
        JSONObject json = (JSONObject) parser.parse(respuesta_string);
        System.out.println(json.get("localId"));



        UsuarioAutenticadoFirebaseEntradaDTO respuesta = new UsuarioAutenticadoFirebaseEntradaDTO(json.get("localId").toString());
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
