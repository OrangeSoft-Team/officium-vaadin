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
import com.vaadin.flow.router.RouteAlias;


@Route("login")
@RouteAlias(value = "")
@PageTitle("Login | Officium")

public class Login_vista extends Div {


    public Login_vista(Login_controlador login_controlador) {
        setId("login-vista");
        var titulo = new H1("Bienvenid@!");
        var username = new TextField("Username");
        var password = new PasswordField("Password");
        var boton = new Button("Login" , event -> {
            try{
                login_controlador.autenticar(username.getValue() , password.getValue());
                UI.getCurrent().navigate("ofertas_trabajo");
            }
            catch (AutenticacionInvalidaExcepcion e){
                Notification.show(e.getMessage());
            }
        });
        add(
                titulo,
                username,
                password,
                boton
        );
    }

}
