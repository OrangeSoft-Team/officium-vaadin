package com.proyecto.desarrollo.autenticacion.infraestructura.vistas;

import com.proyecto.desarrollo.autenticacion.dominio.Staff;
import com.proyecto.desarrollo.autenticacion.dominio.excepciones.AutenticacionInvalidaExcepcion;
import com.proyecto.desarrollo.autenticacion.infraestructura.vistas.controladores.IngresarDatosBasicos_Controlador;
import com.proyecto.desarrollo.autenticacion.infraestructura.vistas.eventos.AutenticacionFallidaEventoVaadin;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;

@PageTitle("Editar Perfil")
public class IngresarDatosBasicos extends Div {
    private Staff staff;
    public IngresarDatosBasicos(){

        try {
            IngresarDatosBasicos_Controlador controlador = new IngresarDatosBasicos_Controlador();
            staff = controlador.ObtenerDatosStaff();

            var correo = new TextField("Correo");
            correo.setReadOnly(true);
            if (staff.getCorreo() != null) {
                correo.setValue(staff.getCorreo().getCorreoElectronico());
            }

            var primer_nombre = new TextField("Primer Nombre");
            if (staff.getPrimer_nombre() != null) {
                primer_nombre.setValue(staff.getPrimer_nombre().getNombre());
            }

            var primer_apellido = new TextField("Primer Apellido");
            if (staff.getPrimer_apellido() != null) {
                primer_apellido.setValue(staff.getPrimer_apellido().getNombre());
            }

            var cargo = new TextField("Cargo");
            if (staff.getCargo() != null) {
                cargo.setValue(staff.getCargo().getCargo());
            }

            var boton = new Button("Modificar", event -> {
                try {
                    Boolean ingreso_exitoso = controlador.ingresar_datos_basicos(primer_nombre.getValue(), primer_apellido.getValue(), cargo.getValue());
                    if (ingreso_exitoso) {
                        Notification.show("Datos modificados con éxito");
                        UI.getCurrent().navigate("ingresar_datos_basicos");
                    } else {
                        Notification.show("Error con la modificación de los datos");
                    }
                }
                catch (Exception e){
                    Notification.show("Error general. Por favor contacte con la empresa");
                }
            });

            Div divcorreo = new Div();
            divcorreo.add(correo);
            Div divprimer_nombre = new Div();
            divprimer_nombre.add(primer_nombre);
            Div divprimer_apellido = new Div();
            divprimer_apellido.add(primer_apellido);
            Div divcargo = new Div();
            divcargo.add(cargo);
            Div divboton = new Div();
            divboton.add(boton);


            VerticalLayout contenedor_general = new VerticalLayout();
            contenedor_general.add(divcorreo, divprimer_nombre, divprimer_apellido, divcargo, divboton);
            contenedor_general.setAlignItems(FlexComponent.Alignment.CENTER);


            add(
                    contenedor_general
            );

        }
        catch (Exception e){
            e.printStackTrace();
            Notification.show("Error general. Por favor contacte con la empresa");
        }

    }
}
