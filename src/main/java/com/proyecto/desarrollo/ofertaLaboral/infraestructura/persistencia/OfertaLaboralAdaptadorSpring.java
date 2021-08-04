package com.proyecto.desarrollo.ofertaLaboral.infraestructura.persistencia;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.proyecto.desarrollo.comunes.infraestructura.persistencia.PersistenciaOfertaLaboral;
import com.proyecto.desarrollo.helpers.infraestructura.http.ManejadorHttp;
import com.proyecto.desarrollo.ofertaLaboral.infraestructura.DTO.salida.OfertaLaboralCreacion;
import com.proyecto.desarrollo.ofertaLaboral.infraestructura.DTO.salida.OfertaLaboralModificacion;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.Locale;

public class OfertaLaboralAdaptadorSpring implements PersistenciaOfertaLaboral {

    private String urlApi = "http://localhost:8081/api/staff/ofertas_laborales";

    @Override
    public String obtenerOfertasLaborales() throws IOException, ParseException {
        URL url = new URL(this.urlApi);
        return ManejadorHttp.realizar_peticion_get(url);
    }

    @Override
    public String obtenerDetalles(String uuid) throws IOException, ParseException {
        URL url = new URL(this.urlApi + "/" + uuid);
        return ManejadorHttp.realizar_peticion_get(url);
    }

    @Override
    public Boolean crearOferta(OfertaLaboralCreacion oferta) throws IOException, ParseException {
        URL url = new URL(this.urlApi);
        ObjectMapper mapper = new ObjectMapper();
        JSONObject jsonObject;
        String jsonString = mapper.writeValueAsString(oferta);
        JSONParser parser = new JSONParser();
        jsonObject = (JSONObject) parser.parse(jsonString);
        FileWriter writer = new FileWriter("src/main/resources/json/creacion.json");
        writer.write(String.valueOf(jsonString));
        writer.close();
        try {
            String response = ManejadorHttp.realizar_peticion_post(jsonObject, url);
        }catch (IOException e) {
            return false;
        }catch (ParseException e) {
            return false;
        }
        return true;
    }

    @Override
    public Boolean cancelarOferta(String uuid) throws IOException, ParseException {
        URL url = new URL(this.urlApi + "/" + uuid + "/cancelar");
        try {
            String response = ManejadorHttp.realizar_peticion_post(null, url);
        }catch (IOException e) {
            return false;
        }catch (ParseException e) {
            return false;
        }
        return true;
    }

    @Override
    public boolean modificarOferta(String uuid, OfertaLaboralModificacion oferta) throws IOException, ParseException {
        URL url = new URL(this.urlApi);
        JSONObject json = new JSONObject();
        json.put("titulo" , oferta.getTitulo());
        json.put("cargo" , oferta.getCargo());
        json.put("sueldo" , oferta.getSueldo());
        json.put("descripcion" , oferta.getDescripcion());
        json.put("duracionEstimadaValor" , oferta.getDuracionEstimadaValor());
        json.put("duracionEstimadaEscala" , oferta.getDuracionEstimadaEscala().toUpperCase(Locale.ROOT));
        json.put("turnoTrabajo" , oferta.getTurnoTrabajo());
        json.put("numeroVacantes" , oferta.getNumeroVacantes());
        json.put("requisitosEspeciales" , oferta.getRequisitosEspeciales());
        json.put("habilidades" , oferta.getHabilidades());
        String response = ManejadorHttp.realizar_peticion_put(json, url);
        /*Revisar*/
        return false;
    }
}
