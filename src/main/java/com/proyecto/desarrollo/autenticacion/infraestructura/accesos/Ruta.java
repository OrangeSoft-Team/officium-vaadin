package com.proyecto.desarrollo.autenticacion.infraestructura.accesos;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;

public class Ruta {
    private String ruta;
    private String nombre;
    private Class<? extends Component> vista;

    public Ruta(String ruta, String nombre, Class<? extends Component> vista) {
        this.ruta = ruta;
        this.nombre = nombre;
        this.vista = vista;
    }

    public String getRuta() {
        return ruta;
    }

    public String getNombre() {
        return nombre;
    }

    public Class<? extends Component> getVista() {
        return vista;
    }
}
