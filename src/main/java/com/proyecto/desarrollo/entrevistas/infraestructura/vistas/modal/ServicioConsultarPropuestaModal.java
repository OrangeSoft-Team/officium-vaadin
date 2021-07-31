package com.proyecto.desarrollo.entrevistas.infraestructura.vistas.modal;

import com.proyecto.desarrollo.comunes.infraestructura.persistencia.PersistenciaPropuestaEntrevistas;
import com.proyecto.desarrollo.entrevistas.aplicacion.EntrevistasMapper;
import com.proyecto.desarrollo.entrevistas.infraestructura.DTOs.entrada.ConsultaPropuestaEntrevistaDTO;
import com.proyecto.desarrollo.entrevistas.infraestructura.persistencia.PersistenciaPropuestaEntrevistaArchivo;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.notification.NotificationVariant;
import org.json.simple.parser.ParseException;

public class ServicioConsultarPropuestaModal {

    private ConsultaPropuestaEntrevistaDTO propuesta;

    private PersistenciaPropuestaEntrevistas adaptador;

    private EntrevistasMapper mapper;

    public ServicioConsultarPropuestaModal() {
        this.adaptador = new PersistenciaPropuestaEntrevistaArchivo();
        this.mapper = new EntrevistasMapper();
    }

    public void obtenerPropuesta(String uuid) throws ParseException {
        this.propuesta = mapper.jsonToPropuesta(adaptador.consultaPropuestaEntrevista(uuid));
    }

    public ConsultaPropuestaEntrevistaDTO getPropuesta() {
        return propuesta;
    }

    public Boolean proponerEntrevista(String uuid) {
        if (adaptador.proponerEntrevista(uuid)) {
            Notification notificacion = new Notification("Entrevista propuesta exitosamente");
            notificacion.setPosition(Notification.Position.TOP_CENTER);
            notificacion.addThemeVariants(NotificationVariant.LUMO_SUCCESS);
            notificacion.setDuration(3000);
            notificacion.open();
            return true;
        }
        Notification notificacion = new Notification("Fallo al proponer entrevista");
        notificacion.setPosition(Notification.Position.TOP_CENTER);
        notificacion.setDuration(3000);
        notificacion.addThemeVariants(NotificationVariant.LUMO_ERROR);
        notificacion.open();
        return false;
    }

    public Boolean proponerEntrevista(String uuid, Boolean test){
        if (adaptador.proponerEntrevista(uuid))
            return  true;
        return false;
    }

    public Boolean cancelarEntrevista(String uuid){
        if (adaptador.cancelarEntrevista(uuid)) {
            Notification notificacion = new Notification("Entrevista cancelada exitosamente");
            notificacion.setPosition(Notification.Position.TOP_CENTER);
            notificacion.addThemeVariants(NotificationVariant.LUMO_SUCCESS);
            notificacion.setDuration(3000);
            notificacion.open();
            return true;
        }
        Notification notificacion = new Notification("Fallo al cancelar entrevista");
        notificacion.setPosition(Notification.Position.TOP_CENTER);
        notificacion.addThemeVariants(NotificationVariant.LUMO_ERROR);
        notificacion.setDuration(3000);
        notificacion.open();
        return false;
    }

    public Boolean cancelarEntrevista(String uuid,Boolean test){
        if (adaptador.cancelarEntrevista(uuid))
            return true;
        return false;
    }
}

