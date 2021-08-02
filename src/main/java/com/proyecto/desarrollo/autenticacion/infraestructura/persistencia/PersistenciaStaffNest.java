package com.proyecto.desarrollo.autenticacion.infraestructura.persistencia;

import com.proyecto.desarrollo.autenticacion.aplicacion.persistencia.PersistenciaStaff;
import com.proyecto.desarrollo.autenticacion.dominio.excepciones.AutenticacionInvalidaExcepcion;
import com.proyecto.desarrollo.autenticacion.infraestructura.DTO.entrada.UsuarioAutenticadoFirebaseEntradaDTO;
import com.proyecto.desarrollo.autenticacion.infraestructura.DTO.entrada.UsuarioAutenticadoNestEntradaDTO;
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
import org.json.simple.parser.ParseException;

import java.io.*;
import java.net.*;


import java.nio.charset.StandardCharsets;
import java.util.*;

public class PersistenciaStaffNest implements PersistenciaStaff {
    private String url_base = new String("http://officium-nest.ddns.net:2000");


    @Override
    public String obtenerStaffs(){
        return null;
    }

    @Override
    public UsuarioAutenticadoFirebaseEntradaDTO obtener_token(UsuarioAutenticadoFirebaseSalidaDTO credenciales) throws AutenticacionInvalidaExcepcion{
        UsuarioAutenticadoFirebaseEntradaDTO respuesta = new UsuarioAutenticadoFirebaseEntradaDTO("uidpr");
        return respuesta;
    }

    @Override
    public UsuarioAutenticadoNestEntradaDTO obtener_staff(UsuarioAutenticadoNestSalidaDTO credenciales) throws IOException, ParseException {

//        URL url = new URL(this.url_base + "/api/staff/auth");
//
//        JSONObject json_peticion=new JSONObject();
//        json_peticion.put("correoElectronico","stafftest@test.com");
//        json_peticion.put("token","1");
//
//        JSONObject json_respuesta = ManejadorHttp.realizar_peticion_post(json_peticion , url);

        UsuarioAutenticadoNestEntradaDTO respuesta = new UsuarioAutenticadoNestEntradaDTO("Juan" , "Perez");
        return respuesta;

    }
}
