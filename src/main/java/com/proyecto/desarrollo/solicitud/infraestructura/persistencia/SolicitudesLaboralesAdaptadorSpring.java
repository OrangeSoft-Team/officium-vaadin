package com.proyecto.desarrollo.solicitud.infraestructura.persistencia;

import com.proyecto.desarrollo.comunes.infraestructura.persistencia.PersistenciaSolicitudes;
import com.proyecto.desarrollo.helpers.infraestructura.http.ManejadorHttp;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class SolicitudesLaboralesAdaptadorSpring implements PersistenciaSolicitudes {

    private String urlApi = "https://www.officium-spring.herokuapp.com/api/staff/postulaciones";

    @Override
    public String obtenerSolicitudes() throws IOException, ParseException {
        URL url = new URL(this.urlApi);
        return ManejadorHttp.realizar_peticion_get(url);
    }

    @Override
    public String obtenerDetalle(String uuid) throws IOException, ParseException {
        URL url = new URL(this.urlApi + "/" + uuid);
        return ManejadorHttp.realizar_peticion_get(url);
    }

    @Override
    public boolean aceptarSolicitud(String uuid) throws MalformedURLException {
        URL url = new URL(this.urlApi + "/" + uuid + "/aceptar");
        try {
            String response = ManejadorHttp.realizar_peticion_put(null, url);
            if (response.equals("201"))
                return true;
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean rechazarSolicitud(String uuid) throws IOException {
        URL url = new URL(this.urlApi + "/" + uuid + "/rechazar");
        try {
            String response = ManejadorHttp.realizar_peticion_put(null, url);
            if (response.equals("201"))
                return true;
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return false;
    }
}
