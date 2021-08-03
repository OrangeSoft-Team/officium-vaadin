package com.proyecto.desarrollo.entrevistas.infraestructura.persistencia;

import com.proyecto.desarrollo.comunes.infraestructura.persistencia.PersistenciaPropuestaEntrevistas;
import com.proyecto.desarrollo.helpers.infraestructura.http.ManejadorHttp;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class PropuestaEntrevistaAdaptadorSpring implements PersistenciaPropuestaEntrevistas {

    private String urlApi = "https://www.officium-spring.herokuapp.com/api/staff/entrevista/";

    @Override
    public String consultaPropuestaEntrevista(String uuidSolicitud) {
        try {
            URL url = new URL(this.urlApi + uuidSolicitud);
            String response = ManejadorHttp.realizar_peticion_get(url);
            return response;
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Boolean proponerEntrevista(String uuid) {
        try {
            URL url = new URL(this.urlApi + uuid);
            String response = ManejadorHttp.realizar_peticion_put(null,url);
            if (response.equals("201"))
                return true;
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean cancelarEntrevista(String uuid) {
        try {
            URL url = new URL(this.urlApi + uuid + "/cancelar");
            String response = ManejadorHttp.realizar_peticion_put(null,url);
            if (response.equals("201"))
                return true;
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return false;
    }
}
