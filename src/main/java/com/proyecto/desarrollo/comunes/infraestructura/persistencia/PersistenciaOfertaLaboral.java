package com.proyecto.desarrollo.comunes.infraestructura.persistencia;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.proyecto.desarrollo.ofertaLaboral.infraestructura.DTO.salida.OfertaLaboralCreacion;
import com.proyecto.desarrollo.ofertaLaboral.infraestructura.DTO.salida.OfertaLaboralModificacion;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;

public interface PersistenciaOfertaLaboral {

    public String obtenerOfertasLaborales() throws IOException, ParseException;

    public String obtenerDetalles(String uuid) throws IOException, ParseException;

    public Boolean crearOferta(OfertaLaboralCreacion oferta) throws IOException, ParseException;

    public Boolean cancelarOferta(String uuid) throws IOException, ParseException;

    boolean modificarOferta(String uuid, OfertaLaboralModificacion oferta) throws IOException, ParseException;
}