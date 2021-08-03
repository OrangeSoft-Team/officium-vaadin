package com.proyecto.desarrollo.empleados.infraestructura.vistas;

import com.proyecto.desarrollo.empleados.infraestructura.vistas.controladores.Empleados_controlador;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.BeforeEnterEvent;
import com.vaadin.flow.router.BeforeEnterObserver;
import com.vaadin.flow.router.PageTitle;
import org.json.simple.parser.ParseException;

import java.awt.*;

@PageTitle("Detalle Empleado")
public class EmpleadoDetalle_vista extends Div implements BeforeEnterObserver {

    TextField p;

    /*este metodo se ejecuta despues del contrsuctor y lo que hace es rellenar los campos*/
    @Override
    public void beforeEnter(BeforeEnterEvent event) {
        p.setValue(event.getRouteParameters().get("empleadoID").get());
    }

    public EmpleadoDetalle_vista(Empleados_controlador controlador) {
        p = new TextField();
        add(p);
    }
}
