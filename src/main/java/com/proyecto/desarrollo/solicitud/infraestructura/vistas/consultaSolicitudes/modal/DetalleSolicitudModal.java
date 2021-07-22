package com.proyecto.desarrollo.solicitud.infraestructura.vistas.consultaSolicitudes.modal;

import com.proyecto.desarrollo.solicitud.infraestructura.DTO.DetalleSolicitudLaboralDTO;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.component.textfield.TextField;

public class DetalleSolicitudModal extends Dialog {

    private DetalleSolicitudLaboralDTO detalle;

    public DetalleSolicitudModal(DetalleSolicitudLaboralDTO detalle) {
        this.detalle = detalle;
        configurarDialog();
        this.addDialogCloseActionListener(e->{this.close();});
        this.setId("dialog-detalle");
    }

    private void configurarDialog() {
        /*Se configuran dimensiones*/
        this.setWidth("50em");
        this.setHeight("25em");

        /*Se crean y añaden componentes*/
        Div encabezado = new Div();
        H3 titulo = new H3("Solicitud #" + this.detalle.getUuid());
        titulo.setClassName("titulo-detalle-solicitud");
        encabezado.setClassName("header titulo-width");
        encabezado.add(titulo);

        Div contenido = new Div();

        Div contenedorTituloCargo = new Div();
        TextField tituloSol = new TextField();
        tituloSol.setValue(this.detalle.getTituloOferta());
        tituloSol.setLabel("Titulo");
        tituloSol.setWidth("350px");
        tituloSol.setReadOnly(true);
        tituloSol.setClassName("modal-space");

        TextField cargoSol = new TextField();
        cargoSol.setValue(this.detalle.getCargoOferta());
        cargoSol.setLabel("Cargo");
        cargoSol.setWidth("350px");
        cargoSol.setReadOnly(true);
        contenedorTituloCargo.add(tituloSol,cargoSol);

        Div contenedorEmpleadoEmpleador = new Div();
        TextField nombreEmp = new TextField();
        nombreEmp.setValue(this.detalle.getNombreEmpleado());
        nombreEmp.setLabel("Nombre empleado");
        nombreEmp.setWidth("350px");
        nombreEmp.setReadOnly(true);
        nombreEmp.setClassName("modal-space");

        TextField nombreEmpresa = new TextField();
        nombreEmpresa.setValue(this.detalle.getNombreEmpresa());
        nombreEmpresa.setLabel("Nombre empresa");
        nombreEmpresa.setWidth("350px");
        nombreEmpresa.setReadOnly(true);
        contenedorEmpleadoEmpleador.add(nombreEmp,nombreEmpresa);

        Div contenedorComentario = new Div();
        TextArea comentario = new TextArea();
        comentario.setLabel("Comentario");
        if (this.detalle.getComentario() != null){
            comentario.setValue(this.detalle.getComentario());
        }
        comentario.setWidth("740px");
        comentario.setReadOnly(true);
        contenedorComentario.add(comentario);

        Div botonera = new Div();
        Button cerrar = new Button("Cerrar",e->{close();});
        cerrar.addClassName("cerrar-boton-detalle");

        Button aprobar = new Button("Aprobar");
        aprobar.setClassName("aceptar-solicitud-boton");

        Button rechazar = new Button("Rechazar");
        rechazar.setClassName("rechazar-solicitud-boton");

        botonera.setWidth("265px");
        botonera.setClassName("botonera top-space");
        botonera.add(aprobar,rechazar,cerrar);

        contenido.add(contenedorTituloCargo, contenedorEmpleadoEmpleador,contenedorComentario,botonera);
        this.add(encabezado,contenido);
    }
}
