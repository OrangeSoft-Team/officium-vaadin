package com.proyecto.desarrollo.solicitud.infraestructura.persistencia;

import com.proyecto.desarrollo.comunes.infraestructura.persistencia.PersistenciaSolicitudes;
import com.proyecto.desarrollo.solicitud.aplicacion.SolicitudMapper;
import com.proyecto.desarrollo.solicitud.infraestructura.DTO.SolicitudLaboralDTO;
import org.json.simple.parser.ParseException;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.fail;

public class SolicitudesLaboralesArchivoPersistenciaTest {

    private SolicitudMapper mapper;
    private SolicitudLaboralDTO[] solicitudes;
    private PersistenciaSolicitudes adaptador;

    @Before
    public void instanciarAtributos(){
        mapper = new SolicitudMapper();
        adaptador = new SolicitudesLaboralesArchivoPersistencia();
    }

    @Test
    public void testConsulta() throws IOException, ParseException {
        this.solicitudes = mapper.jsonToGrid(adaptador.obtenerSolicitudes());
        /*El criterio para saber si funcionó el adaptador es que retornó informacion, ya que se esta en un ambiente de desarrollo, siempre se tendra un dato*/
        if (solicitudes.length == 0){
            fail("No se retornaron ningunas solicitudes");
        }
    }
}
