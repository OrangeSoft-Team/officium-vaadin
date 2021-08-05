package com.proyecto.desarrollo.solicitud.infraestructura.persistencia;

import com.proyecto.desarrollo.comunes.infraestructura.persistencia.PersistenciaSolicitudes;
import com.proyecto.desarrollo.helpers.infraestructura.http.ManejadorHttp;
import com.proyecto.desarrollo.helpers.infraestructura.http.ManejadorHttpSpring;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;

public class SolicitudesLaboralesAdaptadorSpring implements PersistenciaSolicitudes {

    private String urlApi = "https://officium-spring.herokuapp.com/api/staff/postulaciones";
    private String tokenSpring;

    public SolicitudesLaboralesAdaptadorSpring() {
        try{
            this.tokenSpring = Files.readString(Paths.get("src/main/resources/springAuthToken/token.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public String obtenerSolicitudes() throws IOException, ParseException {
        URL url = new URL(this.urlApi);
        return ManejadorHttpSpring.realizar_peticion_get(url,tokenSpring);
    }

    @Override
    public String obtenerDetalle(String uuid) throws IOException, ParseException {
        URL url = new URL(this.urlApi + "/" + uuid);
        return ManejadorHttpSpring.realizar_peticion_get(url,tokenSpring);
    }

    @Override
    public boolean aceptarSolicitud(String uuid) throws MalformedURLException {
        URL url = new URL(this.urlApi + "/" + uuid + "/aceptar");
        try {
            String response = ManejadorHttpSpring.realizar_peticion_put(null, url,tokenSpring);
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
            String response = ManejadorHttpSpring.realizar_peticion_put(null, url,tokenSpring);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return false;
    }
}
