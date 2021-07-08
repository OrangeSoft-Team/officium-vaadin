package com.proyecto.desarrollo.ofertaLaboral.infraestructura.vistas.detallesOferta;

import com.proyecto.desarrollo.comunes.infraestructura.persistencia.PersistenciaOfertaLaboral;
import com.proyecto.desarrollo.ofertaLaboral.aplicacion.OfertaLaboralMapper;
import com.proyecto.desarrollo.ofertaLaboral.infraestructura.DTO.entrada.OfertaLaboralDetalleDTO;
import com.proyecto.desarrollo.ofertaLaboral.infraestructura.persistencia.OfertasLaboralArchivoPersistencia;
import org.json.simple.parser.ParseException;

public class ServicioDetalleOfertaLaboral {

    private OfertaLaboralDetalleDTO oferta;

    public OfertaLaboralDetalleDTO obtenerOferta() throws ParseException {
        PersistenciaOfertaLaboral adaptador = new OfertasLaboralArchivoPersistencia();
        OfertaLaboralMapper mapper = new OfertaLaboralMapper();
        this.oferta = mapper.jsonToDetalle(adaptador.obtenerDetalles());
        /*Oferta = new OfertaLaboralDetalleVaadin("1","Se busca Conserje","20/10/2020","25/10/2020","Vendedor",(float)700.16,4,"dia","Se busca un conserje para que labore en la empresa Orangesoft durante el dia", "diurno",8,"1","Orangesoft","Av Principal Juan Carlos Perez frente al mirador");*/
        return this.oferta;
    }
}
