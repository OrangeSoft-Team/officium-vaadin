package com.proyecto.desarrollo.ofertaLaboral.infraestructura.vistas.consultarOfertas;

import com.proyecto.desarrollo.ofertaLaboral.aplicacion.FiltrosOfertaLaboral;
import com.proyecto.desarrollo.ofertaLaboral.aplicacion.OfertaLaboralMapper;
import com.proyecto.desarrollo.comunes.infraestructura.persistencia.PersistenciaOfertaLaboral;
import com.proyecto.desarrollo.ofertaLaboral.infraestructura.DTO.entrada.OfertaLaboralConsultaDTO;
import com.proyecto.desarrollo.ofertaLaboral.infraestructura.persistencia.OfertasLaboralArchivoPersistencia;
import org.springframework.stereotype.Service;
import org.json.simple.parser.ParseException;

import java.io.*;

@Service
public class ServicioOfertaLaboral {

    private OfertaLaboralConsultaDTO[] ofertasLaborales;
    private int cont;
    private OfertaLaboralMapper mapper = new OfertaLaboralMapper();
    private PersistenciaOfertaLaboral adaptador;

    public OfertaLaboralConsultaDTO[] obtenerData() throws IOException, ParseException {
        /*Se crear una instancia del adaptador*/
        adaptador = new OfertasLaboralArchivoPersistencia();
        /*Se obtiene un json del adaptador*/
        String stringDeOfertas = adaptador.obtenerOfertasLaborales();
        /*Se pasa el Json al mapper para crear las intancias de ofertasLaborales*/
        this.ofertasLaborales = mapper.jsonToGrid(stringDeOfertas);
        return ofertasLaborales;
    }

    public OfertaLaboralConsultaDTO[] filtrar(String estado){
        FiltrosOfertaLaboral filtrados = new FiltrosOfertaLaboral();
        return filtrados.filtarPorEstado(estado,this.ofertasLaborales);
    }

    public OfertaLaboralConsultaDTO[] getOfertasLaborales() {
        return ofertasLaborales;
    }
}