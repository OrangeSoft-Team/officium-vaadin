package com.proyecto.desarrollo.solicitud.infraestructura.vistas.consultaSolicitudes;

import com.proyecto.desarrollo.comunes.infraestructura.persistencia.PersistenciaSolicitudes;
import com.proyecto.desarrollo.solicitud.aplicacion.SolicitudMapper;
import com.proyecto.desarrollo.solicitud.infraestructura.DTO.DetalleSolicitudLaboralDTO;
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
        this.solicitudes =this.mapperSolicitud.jsonToGrid(this.adaptador.obtenerSolicitudes());
        return solicitudesPendiente();
    }

    public DetalleSolicitudLaboralDTO obtenerDetalle(String uuid) throws IOException, ParseException {
        return this.mapperSolicitud.jsonToDetalle(this.adaptador.obtenerDetalle());
    }

    public Boolean aceptarSolicitud(String uuid) throws IOException {
        return this.adaptador.aceptarSolicitud(uuid);
    }

    public int contarEstadoPendiente(){
        int contador = 0;
        for (int i = 0 ; i < solicitudes.length; i++){
            if(solicitudes[i].getEstatus().equals("pendiente")){
                contador++;
            }
        }
        return contador;
    }

    public SolicitudLaboralDTO[] solicitudesPendiente(){
        SolicitudLaboralDTO[] pendientes = new SolicitudLaboralDTO[contarEstadoPendiente()];
        int indice = 0;
        for (int i = 0 ; i < solicitudes.length; i++){
            if(solicitudes[i].getEstatus().equals("pendiente")){
                pendientes[indice] = solicitudes[i];
                indice++;
            }
        }
        return pendientes;
    }
}
