package com.proyecto.desarrollo.ofertaLaboral.infraestructura.vistas.detallesOferta;

import com.proyecto.desarrollo.comunes.infraestructura.persistencia.PersistenciaOfertaLaboral;
import com.proyecto.desarrollo.ofertaLaboral.aplicacion.OfertaLaboralMapper;
import com.proyecto.desarrollo.ofertaLaboral.infraestructura.DTO.entrada.OfertaLaboralDetalleDTO;
import com.proyecto.desarrollo.ofertaLaboral.infraestructura.persistencia.OfertasLaboralArchivoPersistencia;
import org.json.simple.parser.ParseException;

public class ServicioDetalleOfertaLaboral {

    private OfertaLaboralDetalleDTO oferta;

    public OfertaLaboralDetalleDTO obtenerOferta(String uuid) throws ParseException {
        PersistenciaOfertaLaboral adaptador = new OfertasLaboralArchivoPersistencia();
        OfertaLaboralMapper mapper = new OfertaLaboralMapper();
        this.oferta = mapper.jsonToDetalle(adaptador.obtenerDetalles(uuid));
        return this.oferta;
    }
}
