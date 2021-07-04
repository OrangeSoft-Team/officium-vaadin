package com.proyecto.desarrollo.autenticacion.infraestructura.vistas;


import com.proyecto.desarrollo.autenticacion.dominio.excepciones.AutenticacionInvalidaExcepcion;
import com.proyecto.desarrollo.autenticacion.infraestructura.vistas.controladores.Login_controlador;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.RouteAlias;
import com.vaadin.flow.theme.Theme;


@Route("login")
@RouteAlias(value = "")
@PageTitle("Login | Officium")
//@Theme(themeFolder = "login")
@CssImport("./css/login.css")
public class Login_vista extends Div {


    public Login_vista(Login_controlador login_controlador) {
        setId("login-vista");


        var imagen = new Image("images/logoNormal.png", "Desarrollo logo");
        imagen.setWidth("300px");
        var titulo = new H1("¡Bienvenid@!");
        var username = new TextField("Username");
        var password = new PasswordField("Password");
        var boton = new Button("Iniciar Sesión" , event -> {
            try{
                login_controlador.autenticar(username.getValue() , password.getValue());
                UI.getCurrent().navigate("ofertas_trabajo");
            }
            catch (AutenticacionInvalidaExcepcion e){
                Notification.show(e.getMessage());
            }
        });
        boton.addClassName("login-boton");

        addClassName("login-vista");
        setHeightFull();

        Div divimagen = new Div();
        divimagen.add(imagen);

        Div divtitulo = new Div();
        divtitulo.add(titulo);

        Div divusername = new Div();
        divusername.add(username);

        Div divpassword = new Div();
        divpassword.add(password);

        Div divboton = new Div();
        divboton.add(boton);

        VerticalLayout contenedor_general = new VerticalLayout();
        contenedor_general.add(divimagen, divtitulo , divusername , divpassword , divboton);
//        contenedor_general.setHorizontalComponentAlignment(FlexComponent.Alignment.CENTER , divimagen, divtitulo , divusername , divpassword , divboton);
        contenedor_general.addClassName("contenedor_general");

        add(
                contenedor_general
        );
    }

}
