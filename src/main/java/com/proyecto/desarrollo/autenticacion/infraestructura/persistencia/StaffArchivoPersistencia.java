package com.proyecto.desarrollo.autenticacion.infraestructura.persistencia;

import com.google.gson.Gson;
import com.proyecto.desarrollo.autenticacion.aplicacion.persistencia.PersistenciaStaff;
import com.proyecto.desarrollo.autenticacion.dominio.Staff;
import com.proyecto.desarrollo.autenticacion.dominio.valueObjects.Contrasena;
import com.proyecto.desarrollo.autenticacion.dominio.valueObjects.NombreUsuario;
import elemental.json.Json;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;

public class StaffArchivoPersistencia implements PersistenciaStaff {

    public String obtenerStaffs() throws IOException{
        return "hola";
    }

    public Staff obtenerStaffPorNombreUsuario(NombreUsuario nombreUsuario_buscar) {

        String usuario_s = "";

        try{
            usuario_s = Files.readString(Paths.get("src/main/resources/json/staff.json"));
        } catch (IOException e) {
            e.printStackTrace();
        }


        Map jsonJavaRootObject = new Gson().fromJson(usuario_s, Map.class);
        JSONObject prueba = new JSONObject(jsonJavaRootObject);
        String usuario_encontrado = (String) prueba.get("nombreusuario");
        String contrasena_encontrada = (String) prueba.get("contrasena");

        NombreUsuario retorno_nombreusuario = new NombreUsuario((String) prueba.get("nombreusuario"));
        Contrasena contrasena = new Contrasena((String) prueba.get("contrasena"));

        if (!nombreUsuario_buscar.comparar(usuario_encontrado)){
            return null;
        }
        else{
            return new Staff( retorno_nombreusuario , contrasena);
        }
    }

}
