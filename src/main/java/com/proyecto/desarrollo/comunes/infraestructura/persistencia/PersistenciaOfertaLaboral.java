package com.proyecto.desarrollo.comunes.infraestructura.persistencia;

import com.proyecto.desarrollo.ofertaLaboral.infraestructura.DTO.salida.OfertaLaboralCreacion;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface PersistenciaOfertaLaboral {

    public String obtenerOfertasLaborales() throws IOException;

    public String obtenerDetalles();

    public Boolean crearOferta(OfertaLaboralCreacion oferta);
}
