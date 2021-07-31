package com.proyecto.desarrollo.mensaje.infraestructura;

import com.proyecto.desarrollo.autenticacion.infraestructura.vistas.eventos.AutenticacionFallidaEventoVaadin;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.notification.Notification;

public class Mensaje extends Div {

    public Mensaje() {
    }

    public void enviar_notificacion_alerta(String mensaje){
        Notification.show(mensaje);
    }

}
