package com.proyecto.desarrollo.comunes.infraestructura.persistencia;

import com.proyecto.desarrollo.ofertaLaboral.infraestructura.DTO.salida.OfertaLaboralCreacion;
import com.proyecto.desarrollo.ofertaLaboral.infraestructura.DTO.salida.OfertaLaboralModificacion;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface PersistenciaOfertaLaboral {

    public String obtenerOfertasLaborales() throws IOException;

    public String obtenerDetalles(String uuid);

    public Boolean crearOferta(OfertaLaboralCreacion oferta);

    public Boolean cancelarOferta(String uuid) throws IOException, ParseException;

    boolean modificarOferta(String uuid, OfertaLaboralModificacion oferta);
}