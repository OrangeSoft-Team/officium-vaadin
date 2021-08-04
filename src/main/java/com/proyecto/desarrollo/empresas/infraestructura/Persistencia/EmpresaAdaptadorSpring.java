package com.proyecto.desarrollo.empresas.infraestructura.Persistencia;

import com.proyecto.desarrollo.comunes.infraestructura.persistencia.PersistenciaEmpresas;
import com.proyecto.desarrollo.helpers.infraestructura.http.ManejadorHttp;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class EmpresaAdaptadorSpring implements PersistenciaEmpresas {

    private String urlApi = "http://localhost:8081/api/staff/empresas/nombres";

    @Override
    public String getEmpresasOfertaLaboral() {
        try {
            URL url = new URL(this.urlApi);
            return ManejadorHttp.realizar_peticion_get(url);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return "";
    }
}
