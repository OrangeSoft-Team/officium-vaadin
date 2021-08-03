package com.proyecto.desarrollo.autenticacion.infraestructura.vistas.controladores;

import com.proyecto.desarrollo.autenticacion.aplicacion.servicios.Perfil_servicio;
import com.proyecto.desarrollo.autenticacion.dominio.Staff;
import com.proyecto.desarrollo.autenticacion.dominio.valueObjects.Nombre;
import com.vaadin.flow.server.VaadinSession;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class IngresarDatosBasicos_Controlador {
    private Perfil_servicio perfil_servicio;
    public IngresarDatosBasicos_Controlador() {
        this.perfil_servicio = new Perfil_servicio();
    }

    public Staff ObtenerDatosStaff() throws IOException, ParseException {
        Staff staff = perfil_servicio.obtener_staff();
        return staff;
    }

    public Boolean ingresar_datos_basicos(String primer_nombre, String primer_apellido, String cargo) throws IOException, ParseException {
        Boolean ingreso_exitoso = perfil_servicio.ingresar_datos_basicos(primer_nombre, primer_apellido, cargo);
        return ingreso_exitoso;
    }
}
