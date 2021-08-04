package com.proyecto.desarrollo.empleados.infraestructura.vistas;

import com.proyecto.desarrollo.comunes.infraestructura.DTOs.HabilidadDTO;
import com.proyecto.desarrollo.empleados.infraestructura.DTO.entrada.EmpleadoDetalleEntradaDTO;
import com.proyecto.desarrollo.empleados.infraestructura.DTO.entrada.EmpleadoEntradaDTO;
import com.proyecto.desarrollo.empleados.infraestructura.vistas.controladores.Empleados_controlador;
import com.proyecto.desarrollo.ofertaLaboral.infraestructura.vistas.consultarOfertas.OfertasTrabajo_vista;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.details.Details;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.*;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.select.Select;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.BeforeEnterEvent;
import com.vaadin.flow.router.BeforeEnterObserver;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.RouterLink;
import org.json.simple.parser.ParseException;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

@PageTitle("Detalle Empleado")
public class EmpleadoDetalle_vista extends Div implements BeforeEnterObserver {

    Empleados_controlador controlador;
    EmpleadoDetalleEntradaDTO detalle_empleado_informacion;


    /*este metodo se ejecuta despues del contrsuctor y lo que hace es rellenar los campos*/
    @Override
    public void beforeEnter(BeforeEnterEvent event) {
        try {
            String uuid_empleado = event.getRouteParameters().get("empleadoID").get();
            detalle_empleado_informacion = controlador.obtener_detalle_empleado(uuid_empleado);


            setHeightFull();
            setClassName("ofertaDetalle");

            /*Se crea un contenedor para el contenido*/
            VerticalLayout contenedor = new VerticalLayout();
            contenedor.setClassName("spacer");

            /*Se crea un Div que se mostrará como una carta*/
            Div card = new Div();
            card.setClassName("card form");

            /*Titulo de la carta*/
            VerticalLayout encabezado = new VerticalLayout();
            encabezado.setClassName("encabezado");
            Div contenedorHeader = new Div();
            H2 tituloPag = new H2("Detalle Empleado");
            encabezado.setAlignItems(FlexComponent.Alignment.CENTER);
            encabezado.add(tituloPag);


            /*Div que tendra el contenido de la Card*/
            Div contenido = new Div();
            contenido.setClassName("espacio");


            /*Form que contendra los campos*/
            FormLayout detalleOferta = new FormLayout();
            detalleOferta.setMaxWidth("80em");

            /*Contenido del form*/
            TextField primerNombre = new TextField();
            primerNombre.setMaxLength(80);
            primerNombre.setLabel("Primer Nombre");
            primerNombre.setReadOnly(true);
            if (detalle_empleado_informacion.getPrimerNombre() != null){
                primerNombre.setValue(detalle_empleado_informacion.getPrimerNombre());
            }

            TextField segundoNombre = new TextField();
            segundoNombre.setMaxLength(80);
            segundoNombre.setLabel("Segundo Nombre");
            segundoNombre.setReadOnly(true);
            if (detalle_empleado_informacion.getSegundoNombre() != null) {
                segundoNombre.setValue(detalle_empleado_informacion.getSegundoNombre());
            }

            TextField primerApellido = new TextField();
            primerApellido.setMaxLength(80);
            primerApellido.setLabel("Primer Apellido");
            primerApellido.setReadOnly(true);
            if (detalle_empleado_informacion.getPrimerApellido() != null) {
                primerApellido.setValue(detalle_empleado_informacion.getPrimerApellido());
            }

            TextField segundoApellido = new TextField();
            segundoApellido.setMaxLength(80);
            segundoApellido.setLabel("Segundo Apellido");
            segundoApellido.setReadOnly(true);
            if (detalle_empleado_informacion.getSegundoApellido() != null) {
                segundoApellido.setValue(detalle_empleado_informacion.getSegundoApellido());
            }

            TextField correo = new TextField();
            correo.setMaxLength(80);
            correo.setLabel("Correo");
            correo.setReadOnly(true);
            if (detalle_empleado_informacion.getCorreo() != null) {
                correo.setValue(detalle_empleado_informacion.getCorreo());
            }

            TextField estatus = new TextField();
            estatus.setMaxLength(80);
            estatus.setLabel("Estatus");
            estatus.setReadOnly(true);
                if (detalle_empleado_informacion.getEstatus() != null) {
                    estatus.setValue(detalle_empleado_informacion.getEstatus());
                }

            TextField genero = new TextField();
            genero.setMaxLength(80);
            genero.setLabel("Genero");
            genero.setReadOnly(true);
            if (detalle_empleado_informacion.getGenero() != null) {
                genero.setValue(detalle_empleado_informacion.getGenero());
            }

            TextField fechaNacimiento = new TextField();
            fechaNacimiento.setMaxLength(80);
            fechaNacimiento.setLabel("Fecha Nacimiento");
            fechaNacimiento.setReadOnly(true);
            if (detalle_empleado_informacion.getFechaNacimiento() != null) {
                fechaNacimiento.setValue(detalle_empleado_informacion.getFechaNacimiento());
            }

            TextField calleUno = new TextField();
            calleUno.setMaxLength(80);
            calleUno.setLabel("Calle Uno");
            calleUno.setReadOnly(true);
            if (detalle_empleado_informacion.getCalleUno() != null) {
                calleUno.setValue(detalle_empleado_informacion.getCalleUno());
            }

            TextField calleDos = new TextField();
            calleDos.setMaxLength(80);
            calleDos.setLabel("Calle Dos");
            calleDos.setReadOnly(true);
            if (detalle_empleado_informacion.getCalleDos() != null) {
                calleDos.setValue(detalle_empleado_informacion.getCalleDos());
            }

            TextField codigoPostal = new TextField();
            codigoPostal.setMaxLength(80);
            codigoPostal.setLabel("Código Postal");
            codigoPostal.setReadOnly(true);
            if (detalle_empleado_informacion.getCodigoPostal() != null) {
                codigoPostal.setValue(detalle_empleado_informacion.getCodigoPostal());
            }

            TextField nombrePais = new TextField();
            nombrePais.setMaxLength(80);
            nombrePais.setLabel("País");
            nombrePais.setReadOnly(true);
            if (detalle_empleado_informacion.getNombrePais() != null) {
                nombrePais.setValue(detalle_empleado_informacion.getNombrePais());
            }

            TextField nombreEstado = new TextField();
            nombreEstado.setMaxLength(80);
            nombreEstado.setLabel("Estado");
            nombreEstado.setReadOnly(true);
            if (detalle_empleado_informacion.getNombreEstado() != null) {
                nombreEstado.setValue(detalle_empleado_informacion.getNombreEstado());
            }

            TextField nombreCiudad = new TextField();
            nombreCiudad.setMaxLength(80);
            nombreCiudad.setLabel("Ciudad");
            nombreCiudad.setReadOnly(true);
            if (detalle_empleado_informacion.getNombreCiudad() != null) {
                nombreCiudad.setValue(detalle_empleado_informacion.getNombreCiudad());
            }

            /*Añadir los componentes del form al form*/
            detalleOferta.add(primerNombre, segundoNombre, primerApellido, segundoApellido, correo, estatus, genero, fechaNacimiento, calleUno, calleDos, codigoPostal, nombrePais, nombreCiudad);
            /*Redistribucion responsive*/
            detalleOferta.setResponsiveSteps(
                    new FormLayout.ResponsiveStep("1px",1),
                    new FormLayout.ResponsiveStep("600px",2),
                    new FormLayout.ResponsiveStep("700px",3)
            );
            /*Añadir el contenido*/
            contenido.add(detalleOferta);



            Div detalleHabilidades = new Div();
            Div agrupador_texto_habilidades = new Div();
            detalle_empleado_informacion.getHabilidades().forEach(habilidad -> {
                agrupador_texto_habilidades.add(new Paragraph(habilidad.getNombre() + " --- " + habilidad.getCategoria()));
            });
            Details habilidadescom = new Details("Habilidades", agrupador_texto_habilidades);
            detalleHabilidades.add(habilidadescom);
            contenido.add(detalleHabilidades);


            Div detalleExperiencias = new Div();
            Div agrupador_texto_experiencias = new Div();
            detalle_empleado_informacion.getExperiencias().forEach(experiencia -> {
                agrupador_texto_experiencias.add(new Paragraph(experiencia.getCargo() + " --- " + experiencia.getNombreEmpresa() + " --- " + experiencia.getFechaInicio() + " hasta " + experiencia.getFechaFin()));
            });
            Details experienciascom = new Details("Experiencia Laboral", agrupador_texto_experiencias);
            detalleExperiencias.add(experienciascom);
            contenido.add(detalleExperiencias);



            /*Boton*/
            Div enviar = new Div();
            enviar.setWidthFull();
            Div inner = new Div();
            inner.setWidth("250px");
            inner.setClassName("botonera");

            Button cancelar = new com.vaadin.flow.component.button.Button("Regresar");
            cancelar.setClassName("cancelar-detalle");
            /*Esto es para volver a la vista incial*/
            RouterLink volver = new RouterLink("", ListaEmpleados_vista.class);
            volver.getElement().appendChild(cancelar.getElement());

            Button enviarModificacion = new Button("Enviar", buttonClickEvent -> {

            });
            enviarModificacion.setVisible(false);
            enviarModificacion.setClassName("enviar-modificacion");

            inner.add(volver,enviarModificacion);
            enviar.add(inner);

            /*Añadir todo al card*/
            card.add(encabezado,contenido,enviar);

            contenedor.add(card);

            /*Añadir todo al contenedor*/
            add(contenedor);



        }
        catch (Exception e){
            Notification.show(e.getMessage());
        }
    }

    public EmpleadoDetalle_vista() {
        controlador = new Empleados_controlador();

    }



}
