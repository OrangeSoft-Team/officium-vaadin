package com.proyecto.desarrollo.solicitud.infraestructura.vistas.consultaSolicitudes;

import com.proyecto.desarrollo.comunes.infraestructura.persistencia.PersistenciaSolicitudes;
import com.proyecto.desarrollo.solicitud.aplicacion.SolicitudMapper;
import com.proyecto.desarrollo.solicitud.infraestructura.DTO.DetalleSolicitudLaboralDTO;
import com.proyecto.desarrollo.solicitud.infraestructura.DTO.SolicitudLaboralDTO;
import com.proyecto.desarrollo.solicitud.infraestructura.persistencia.SolicitudesLaboralesAdaptadorSpring;
import com.proyecto.desarrollo.solicitud.infraestructura.persistencia.SolicitudesLaboralesArchivoPersistencia;
import org.json.simple.parser.ParseException;

import java.io.IOException;

public class ServicioConsultarSolicitudes {

    private SolicitudLaboralDTO[] solicitudes;

    private PersistenciaSolicitudes adaptador;

    private SolicitudMapper mapperSolicitud;

    private SolicitudLaboralDTO[] solicitudesOrdenadas;

    public ServicioConsultarSolicitudes() {
        /*Se instancia el adaptador*/
        this.adaptador = new SolicitudesLaboralesArchivoPersistencia();
        /*Se instancia un mapper para las solicitudes*/
        this.mapperSolicitud = new SolicitudMapper();
    }

    public SolicitudLaboralDTO[] obtenerSolicitudes() throws IOException, ParseException {
        String contenido = this.adaptador.obtenerSolicitudes();
        if (contenido.equals(""))
            return null;
        /*Se obtiene del adaptador un json con las solicitudes y luego se mappean a un array de SolicitudLaboralDTO*/
        else {
            this.solicitudes = this.mapperSolicitud.jsonToGrid(this.adaptador.obtenerSolicitudes());
        }
        return ordenar();
    }

    public DetalleSolicitudLaboralDTO obtenerDetalle(String uuid) throws IOException, ParseException {
        return this.mapperSolicitud.jsonToDetalle(this.adaptador.obtenerDetalle(uuid));
    }

    public Boolean aceptarSolicitud(String uuid) throws IOException, ParseException {
        return this.adaptador.aceptarSolicitud(uuid);
    }

    public Boolean rechazarSolicitud(String uuid) throws IOException {
        return this.adaptador.rechazarSolicitud(uuid);
    }

    public int solicitudesPendiente(int contador){
        int indice = contador;
        for (int i = 0 ; i < solicitudes.length; i++){
            if(solicitudes[i].getEstatus().equals("pendiente")){
                this.solicitudesOrdenadas[indice] = solicitudes[i];
                indice++;
            }
        }
        return indice;
    }

    private int solicitudesAprobadas(int contador) {
        int indice = contador;
        for (int i = 0 ; i < solicitudes.length; i++){
            if(solicitudes[i].getEstatus().equals("aprobado")){
                this.solicitudesOrdenadas[indice] = solicitudes[i];
                indice++;
            }
        }
        return indice;
    }

    private void solicitudesRechazadas(int contador) {
        int indice = contador;
        for (int i = 0 ; i < solicitudes.length; i++){
            if(solicitudes[i].getEstatus().equals("rechazado")){
                this.solicitudesOrdenadas[indice] = solicitudes[i];
                indice++;
            }
        }
    }


    public SolicitudLaboralDTO[] ordenar(){
        this.solicitudesOrdenadas = new SolicitudLaboralDTO[this.solicitudes.length];
        int contador = 0;
        /*Busca las ofertas pendientes y devuelvo un indice en el array*/
        contador = solicitudesPendiente(contador);
        contador = solicitudesAprobadas(contador);
        solicitudesRechazadas(contador);
        return solicitudesOrdenadas;
    }
}
