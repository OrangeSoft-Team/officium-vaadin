package com.proyecto.desarrollo.autenticacion.infraestructura.vistas;


import com.proyecto.desarrollo.autenticacion.dominio.excepciones.AutenticacionInvalidaExcepcion;
import com.proyecto.desarrollo.autenticacion.infraestructura.vistas.controladores.Login_controlador;
import com.proyecto.desarrollo.autenticacion.infraestructura.vistas.eventos.AutenticacionFallidaEventoVaadin;
import com.proyecto.desarrollo.mensaje.infraestructura.Mensaje;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.RouteAlias;


@Route("login")
@RouteAlias(value = "")
@PageTitle("Login | Officium")
@CssImport("./css/login.css")
public class Login_vista extends Div {

    Mensaje mensajero;


    public Login_vista(Login_controlador login_controlador) {
        setId("login-vista");

        this.mensajero = new Mensaje();

        var imagen = new Image("images/logoNormal.png", "Desarrollo logo");
        imagen.setWidth("300px");
        var titulo = new H2("Staff Member");
        var correo = new TextField("Correo");
        var password = new PasswordField("Contraseña");
        var boton = new Button("Iniciar Sesión" , event -> {
            try{
                login_controlador.autenticar(correo.getValue() , password.getValue());
                UI.getCurrent().navigate("ofertas_trabajo");
            }
            catch (AutenticacionInvalidaExcepcion e){
                fireEvent(new AutenticacionFallidaEventoVaadin(this));
//                Notification.show(e.getMessage());
            }
        });
        boton.addClassName("login-boton");

        addClassName("login-vista");
        setHeightFull();

        Div divimagen = new Div();
        divimagen.add(imagen);

        Div divtitulo = new Div();
        divtitulo.add(titulo);

        Div divcorreo = new Div();
        divcorreo.add(correo);

        Div divpassword = new Div();
        divpassword.add(password);

        Div divboton = new Div();
        divboton.add(boton);

        VerticalLayout contenedor_general = new VerticalLayout();
        contenedor_general.add(divimagen, divtitulo , divcorreo , divpassword , divboton);
        contenedor_general.addClassName("contenedor_general");

        add(
                contenedor_general
        );

        addListener(AutenticacionFallidaEventoVaadin.class , this::enviarNotificacion);

    }


    private void enviarNotificacion(AutenticacionFallidaEventoVaadin evento){
        String mensaje = evento.getContenido();
        this.mensajero.enviar_notificacion_alerta(mensaje);
    }


}
