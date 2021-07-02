package com.proyecto.desarrollo.autenticacion.infraestructura.vistas;


import com.proyecto.desarrollo.autenticacion.dominio.excepciones.AutenticacionInvalidaExcepcion;
import com.proyecto.desarrollo.autenticacion.infraestructura.vistas.controladores.Login_controlador;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.PageTitle;


@Route("login")
@PageTitle("Login | Vaadin CRM")

public class Login_vista extends Div {


    public Login_vista(Login_controlador login_controlador) {
        setId("login-vista");
        var username = new TextField("Username");
        var password = new PasswordField("Password");
        add(
                new H1("Welcome"),
                username,
                password,
                new Button("Login" , event -> {
                    try{
                        login_controlador.autenticar(username.getValue() , password.getValue());
                        UI.getCurrent().navigate("empresas");
                    }
                    catch (AutenticacionInvalidaExcepcion e){
                        Notification.show(e.getMessage());
                    }
                })
        );
    }

}
