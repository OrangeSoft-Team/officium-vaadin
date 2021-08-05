package com.proyecto.desarrollo.comunes.infraestructura.persistencia.entrada;

import com.proyecto.desarrollo.comunes.infraestructura.persistencia.PersistenciaHabilidades;
import com.proyecto.desarrollo.helpers.infraestructura.http.ManejadorHttp;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class HabilidadesAdaptadorSpring implements PersistenciaHabilidades {

    private String urlApi = "https://officium-nest.herokuapp.com/api/habilidades";

    @Override
    public String getHabilidadesOfertasLaborales() {
        try {
            URL url = new URL(this.urlApi);
            return ManejadorHttp.realizar_peticion_get(url);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
}
