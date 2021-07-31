package com.proyecto.desarrollo.autenticacion.infraestructura.vistas.eventos;

import com.proyecto.desarrollo.autenticacion.infraestructura.vistas.Login_vista;
import com.vaadin.flow.component.ComponentEvent;

public class AutenticacionFallidaEventoVaadin extends ComponentEvent<Login_vista> {
    private String contenido = "Error en la autenticacion";
    public AutenticacionFallidaEventoVaadin(Login_vista source) {
        super(source, false);
    }

    public String getContenido() {
        return contenido;
    }
}

