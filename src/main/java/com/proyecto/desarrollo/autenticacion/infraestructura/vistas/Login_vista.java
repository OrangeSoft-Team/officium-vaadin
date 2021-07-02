package com.proyecto.desarrollo.autenticacion.infraestructura.vistas;

import com.proyecto.desarrollo.autenticacion.aplicacion.servicios.Autenticar_servicio;
import com.proyecto.desarrollo.autenticacion.dominio.excepciones.AutenticacionInvalidaExcepcion;
import com.proyecto.desarrollo.empresas.infraestructura.vista.Empresas_vista;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.PageTitle;
import com.proyecto.desarrollo.comunes.infraestructura.layout.MainLayout;
import com.vaadin.flow.router.RouteAlias;
import com.vaadin.flow.router.RouteConfiguration;

@Route("login")
@PageTitle("Login | Vaadin CRM")

public class Login_vista extends Div {


    public Login_vista(Autenticar_servicio autenticar_servicio) {
        setId("login-vista");
        var username = new TextField("Username");
        var password = new PasswordField("Password");
        add(
                new H1("Welcome"),
                username,
                password,
                new Button("Login" , event -> {
                    try{
                      autenticar_servicio.autenticar(username.getValue() , password.getValue());
                        UI.getCurrent().navigate("empresas");
                    }
                    catch (AutenticacionInvalidaExcepcion e){
                        Notification.show(e.getMessage());
                    }
                })
        );
    }

}
