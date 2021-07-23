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

    @Test
    public void testAprobacion() throws IOException, ParseException {
        /*El criterio para saber si funcionó el adaptador es que retorne verdadero, ya que no se retornara ningun tipo de información*/
        if (!adaptador.aceptarSolicitud("1")){
            fail("Ocurrio un fallo al momento de hacer la aprobación");
        }
        System.out.println("Solicitud aprobada exitosamente");
    }

    @Test
    public void testRechazo() throws IOException, ParseException {
        /*El criterio para saber si funcionó el adaptador es que retorne verdadero, ya que no se retornara ningun tipo de información*/
        if (!adaptador.rechazarSolicitud("1")){
            fail("Ocurrio un fallo al momento de hacer la aprobación");
        }
        System.out.println("Solicitud rechazada exitosamente");
    }
}
