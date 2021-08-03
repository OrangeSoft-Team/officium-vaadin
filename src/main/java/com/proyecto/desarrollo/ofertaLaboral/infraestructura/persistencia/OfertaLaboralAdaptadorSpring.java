package com.proyecto.desarrollo.ofertaLaboral.infraestructura.persistencia;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.proyecto.desarrollo.comunes.infraestructura.persistencia.PersistenciaOfertaLaboral;
import com.proyecto.desarrollo.helpers.infraestructura.http.ManejadorHttp;
import com.proyecto.desarrollo.ofertaLaboral.infraestructura.DTO.salida.OfertaLaboralCreacion;
import com.proyecto.desarrollo.ofertaLaboral.infraestructura.DTO.salida.OfertaLaboralModificacion;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class OfertaLaboralAdaptadorSpring implements PersistenciaOfertaLaboral {

    private String urlApi = "https://www.officium-spring.herokuapp.com/api/staff/ofertas_laborales";

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
        JSONObject json = new JSONObject();
        json.put("titulo" , oferta.getTitulo());
        json.put("descripcion" , oferta.getDescripcion());
        json.put("cargo" , oferta.getCargo());
        json.put("sueldo" , oferta.getSueldo());
        json.put("duracionEstimadaValor" , oferta.getDuracionEstimadaValor());
        json.put("duracionEstimadaEscala" , oferta.getDuracionEstimadaEscala());
        json.put("turnoTrabajo" , oferta.getTurnoTrabajo());
        json.put("numeroVacantes" , oferta.getNumeroVacantes());
        json.put("idEmpresa" , oferta.getIdEmpresa());
        json.put("requisitosEspeciales" , oferta.getRequisitosEspeciales());
        json.put("habilidades" , oferta.getHabilidades());
        String response = ManejadorHttp.realizar_peticion_post(json, url);
        /*Revisar*/
        if (response.equals("201"))
            return true;
        return false;
    }

    @Override
    public Boolean cancelarOferta(String uuid) throws IOException, ParseException {
        URL url = new URL(this.urlApi + "/" + uuid + "/cancelar");
        String response = ManejadorHttp.realizar_peticion_put(null, url);
        if (response.equals("201"))
            return true;
        return false;
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
        json.put("duracionEstimadaEscala" , oferta.getDuracionEstimadaEscala());
        json.put("turnoTrabajo" , oferta.getTurnoTrabajo());
        json.put("numeroVacantes" , oferta.getNumeroVacantes());
        json.put("requisitosEspeciales" , oferta.getRequisitosEspeciales());
        json.put("habilidades" , oferta.getHabilidades());
        String response = ManejadorHttp.realizar_peticion_put(json, url);
        /*Revisar*/
        if (response.equals("201"))
            return true;
        return false;
    }
}
