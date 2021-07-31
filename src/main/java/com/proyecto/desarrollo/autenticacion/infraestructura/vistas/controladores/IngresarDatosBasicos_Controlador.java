package com.proyecto.desarrollo.autenticacion.infraestructura.vistas.controladores;

import com.proyecto.desarrollo.autenticacion.dominio.Staff;
import com.proyecto.desarrollo.autenticacion.dominio.valueObjects.Nombre;
import com.vaadin.flow.server.VaadinSession;
import org.springframework.stereotype.Service;

@Service
public class IngresarDatosBasicos_Controlador {
    public IngresarDatosBasicos_Controlador() {
    }

    public Staff ObtenerDatosStaff(){
        return VaadinSession.getCurrent().getAttribute(Staff.class);
    }
}
