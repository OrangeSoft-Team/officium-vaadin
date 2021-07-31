package com.proyecto.desarrollo.entrevistas.infraestructura.vistas.modal;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import org.json.simple.parser.ParseException;

public class ConsultarPropuestaEntrevistaModal extends Dialog{

    private ServicioConsultarPropuestaModal controlador;

    private TextField fecha;

    private TextField asunto;

    private TextField estado;

    private TextField vinculo;

    private Div botonera;

    private String uuidSolicitud;

    private Button proponer;

    private Button cancelar;

    public ConsultarPropuestaEntrevistaModal(String uuid){
        /*Se instancia el controlador*/
        this.controlador = new ServicioConsultarPropuestaModal();
        this.uuidSolicitud = uuid;
        /*Se definen alto y ancho*/
        setHeight("27em");
        setWidth("43em");

        /**/
        Div contenedorTitulo = new Div();
        H2 titulo = new H2("Detalle Entrevista");
        titulo.setWidth("225px");
        titulo.setClassName("titulo-entrevista-modal");
        contenedorTitulo.add(titulo);

        VerticalLayout contenedorContenido = new VerticalLayout();

        HorizontalLayout campos = new HorizontalLayout();
        fecha = new TextField();
        fecha.setReadOnly(true);
        fecha.setClassName("fecha-entrevista");
        fecha.setClassName("campo-entrevista");
        fecha.setWidth("200px");
        fecha.setLabel("Fecha programada");

        asunto = new TextField();
        asunto.setReadOnly(true);
        asunto.setClassName("asunto-entrevista");
        asunto.setLabel("Asunto");
        asunto.setWidthFull();

        estado = new TextField();
        estado.setReadOnly(true);
        estado.setWidth("200px");
        estado.setClassName("estado-entrevista");
        estado.setLabel("Estado de la entrevista");

        campos.add(fecha,estado);

        vinculo = new TextField();
        vinculo.setReadOnly(true);
        vinculo.setClassName("vinculo-entrevista");
        vinculo.setWidthFull();
        vinculo.setLabel("Enlace de la entrevista");

        contenedorContenido.add(campos,asunto,vinculo);

        add(contenedorTitulo,contenedorContenido);
    }

    public void buscarEntrevista(String uuid) {
        try {
            controlador.obtenerPropuesta(uuid);
            rellenarInformacion();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    private void rellenarInformacion() throws ParseException {
        /*En caso de que no se tenga una entrevista propuesta*/
        if (controlador.getPropuesta().getUuid() == null){
         Div anuncio = new Div();
         Paragraph contenido = new Paragraph("Actualmente no se ha propuesto una entrevista, si quiere proponer una entrevista haga click al boton \"Proponer\"");
         anuncio.add(contenido);
         add(contenido,generarBotonera());
        }
        else {
            this.fecha.setValue(controlador.getPropuesta().getFechaPautada());
            this.asunto.setValue(controlador.getPropuesta().getAsunto());
            this.estado.setValue(controlador.getPropuesta().getEstatus());
            this.vinculo.setValue(controlador.getPropuesta().getVinculo());
            add(generarBotonera());
        }
    }

    private Div generarBotonera(){
        botonera = new Div();
        botonera.setClassName("botonera-entrevista");

        Button cerrar = new Button("Volver", buttonClickEvent -> {
            this.close();
        });
        cerrar.setClassName("cerrar-modal");

        if(controlador.getPropuesta().getUuid() != null){
            botonera.setWidth("200px");
            cancelar = new Button("Cancelar",buttonClickEvent -> {
                if(controlador.cancelarEntrevista(this.uuidSolicitud)) {
                    try {
                        cargarNuevoModal();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
            cancelar.setClassName("cancelar-entrevista");
            botonera.add(cancelar,cerrar);
        }
        else{
            setHeight("32em");
            botonera.setWidth("176px");
            proponer = new Button("Proponer",buttonClickEvent ->{
                if(controlador.proponerEntrevista(this.uuidSolicitud)) {
                    try {
                        cargarNuevoModal();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
            proponer.setClassName("proponer-entrevista");
            botonera.add(proponer,cerrar);
        }
        return botonera;
    }

    private void cargarNuevoModal(){
        ConsultarPropuestaEntrevistaModal modal = new ConsultarPropuestaEntrevistaModal(this.uuidSolicitud);
        close();
        modal.open();
        modal.buscarEntrevista(this.uuidSolicitud);
    }

    public ServicioConsultarPropuestaModal getControlador() {
        return controlador;
    }
}
