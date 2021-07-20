package com.proyecto.desarrollo.solicitud.infraestructura.vistas.consultaSolicitudes;

import com.proyecto.desarrollo.comunes.infraestructura.persistencia.PersistenciaSolicitudes;
import com.proyecto.desarrollo.solicitud.aplicacion.SolicitudMapper;
import com.proyecto.desarrollo.solicitud.infraestructura.DTO.SolicitudLaboralDTO;
import com.proyecto.desarrollo.solicitud.infraestructura.persistencia.SolicitudesLaboralesArchivoPersistencia;
import org.json.simple.parser.ParseException;

import java.io.IOException;

public class ServicioConsultarSolicitudes {

    private SolicitudLaboralDTO[] solicitudes;

    private PersistenciaSolicitudes adaptador;

    private SolicitudMapper mapperSolicitud;

    public ServicioConsultarSolicitudes() {
        /*Se instancia el adaptador*/
        this.adaptador = new SolicitudesLaboralesArchivoPersistencia();
        /*Se instancia un mapper para las solicitudes*/
        this.mapperSolicitud = new SolicitudMapper();
    }

    public SolicitudLaboralDTO[] obtenerSolicitudes() throws IOException, ParseException {
        /*Se obtiene del adaptador un json con las solicitudes y luego se mappean a un array de SolicitudLaboralDTO*/
        return this.mapperSolicitud.jsonToGrid(this.adaptador.obtenerSolicitudes());
    }
}
