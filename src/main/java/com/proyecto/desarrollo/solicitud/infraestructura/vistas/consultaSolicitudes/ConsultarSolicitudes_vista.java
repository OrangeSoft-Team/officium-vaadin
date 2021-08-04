package com.proyecto.desarrollo.solicitud.infraestructura.vistas.consultaSolicitudes;


import com.proyecto.desarrollo.entrevistas.infraestructura.vistas.modal.ConsultarPropuestaEntrevistaModal;
import com.proyecto.desarrollo.solicitud.infraestructura.DTO.SolicitudLaboralDTO;
import com.proyecto.desarrollo.solicitud.infraestructura.vistas.consultaSolicitudes.evento.cambioEstado.AprobadoExitoso;
import com.proyecto.desarrollo.solicitud.infraestructura.vistas.consultaSolicitudes.evento.cambioEstado.AprobadoFallido;
import com.proyecto.desarrollo.solicitud.infraestructura.vistas.consultaSolicitudes.evento.cambioEstado.RechazoExitoso;
import com.proyecto.desarrollo.solicitud.infraestructura.vistas.consultaSolicitudes.evento.cambioEstado.RechazoFallido;
import com.proyecto.desarrollo.solicitud.infraestructura.vistas.consultaSolicitudes.modal.DetalleSolicitudModal;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.notification.NotificationVariant;
import com.vaadin.flow.router.PageTitle;
import org.json.simple.parser.ParseException;

import java.io.IOException;

@PageTitle("Solicitudes Laborales")
public class ConsultarSolicitudes_vista extends Div {

    private ServicioConsultarSolicitudes controlador = new ServicioConsultarSolicitudes();
    private SolicitudLaboralDTO[] solicitudes;
    private Grid<SolicitudLaboralDTO> grid = new Grid<>(SolicitudLaboralDTO.class);

    public ConsultarSolicitudes_vista() throws IOException, ParseException {
        /*Inicialmente se crean los componentes que se mostraran en la vista*/
        colocarComponentes();
        /*Se configura el layout del grid*/
        configurarGrid();
        /*Se cargan los datos que se mostraran en el grid*/
        agregarItemsAlGrid();
        /*Se agregan listeners para escuchar a los eventos*/
        agregarListeners();
    }

    private void colocarComponentes() {
        addClassName("contenido");
        setHeightFull();
        Div spacer = new Div();
        spacer.setClassName("consulta-solicitudes-spacer");
        add(spacer,grid);
    }

    private void configurarGrid() {
        grid.setClassName("grid-solicitudes-laborales");
        grid.setHeight("40em");
        grid.setColumns("tituloOferta","estatus","cargoOferta","nombreEmpresa","nombreEmpleado");
        grid.getColumnByKey("cargoOferta").setWidth("10px");
        /* Se crea el boton de detalle, todavia no se ha implementado la interfaz asi que se deja comentado*/
        grid.addComponentColumn(item ->{
            if(item.getEstatus().equals("aprobado"))
                return crearBotoneraEntrevista(item.getUuid());
            else if(item.getEstatus().equals("rechazado"))
                return new Div();
            return crearBotoneraEstados(item.getUuid());
        }).setHeader("Acciones");
    }

    private Component crearBotoneraEstados(String uuid) {
        Div botonera = new Div();

        Button aprobar = new Button("Aprobar",e->{
            try {
                /*Si la aprobación fue exitosa, se dispara un evento de exito*/
                if (controlador.aceptarSolicitud(uuid)){
                    fireEvent(new AprobadoExitoso(this));
                }
                /*Si la aprobación no fue exitosa, se dispara un evento de fracaso*/
                else {
                    fireEvent(new AprobadoFallido(this));
                }
            } catch (IOException | ParseException ioException) {
                ioException.printStackTrace();
            }
        });
        aprobar.setClassName("aceptar-solicitud-boton");

        Button rechazar = new Button("Rechazar", e->{
            try {
                /*Si la aprobación fue exitosa, se dispara un evento de exito*/
                if (controlador.rechazarSolicitud(uuid)){
                    fireEvent(new RechazoExitoso(this));
                }
                /*Si la aprobación no fue exitosa, se dispara un evento de fracaso*/
                else {
                    fireEvent(new RechazoFallido(this));
                }
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        });
        rechazar.setClassName("rechazar-solicitud-boton");


        Button detalle = new Button("Detalle");
        detalle.setClassName("detalle-solicitud-boton");
        detalle.addClickListener(e->{
            try {
                DetalleSolicitudModal detalleModal = new DetalleSolicitudModal(controlador.obtenerDetalle(uuid));
                detalleModal.open();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            } catch (ParseException parseException) {
                parseException.printStackTrace();
            }
        });


        botonera.add(aprobar,rechazar,detalle);
        return botonera;
    }

    private Div crearBotoneraEntrevista(String uuid){
        Div botonera = new Div();

        Button entrevista = new Button("Entrevista",e->{
            ConsultarPropuestaEntrevistaModal modalEntrevista = new ConsultarPropuestaEntrevistaModal(uuid);
            modalEntrevista.buscarEntrevista(uuid);
            modalEntrevista.open();
        });
        entrevista.setClassName("boton-entrevista");
        botonera.add(entrevista);
        return botonera;
    }

    private void agregarListeners(){
            addListener(AprobadoExitoso.class, this::aprobadoExitoso);
            addListener(AprobadoFallido.class, this::aprobadoFallido);
            addListener(RechazoExitoso.class, this::rechazoExitoso);
        addListener(RechazoFallido.class, this::rechazoFallido);
    }

    private void aprobadoExitoso(AprobadoExitoso evento){
        Notification notificacion = new Notification("Solicitud aprobada exitosamente",3000);
        notificacion.setPosition(Notification.Position.TOP_CENTER);
        notificacion.addThemeVariants(NotificationVariant.LUMO_SUCCESS);
        notificacion.open();
        try {
            agregarItemsAlGrid();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    private void aprobadoFallido(AprobadoFallido evento){
        Notification notificacion = new Notification("Fallo al aprobar la solicitud",3000);
        notificacion.setPosition(Notification.Position.TOP_CENTER);
        notificacion.addThemeVariants(NotificationVariant.LUMO_ERROR);
        notificacion.open();
    }

    private void rechazoExitoso(RechazoExitoso evento){
        Notification notificacion = new Notification("Solicitud rechazada exitosamente",3000);
        notificacion.setPosition(Notification.Position.TOP_CENTER);
        notificacion.addThemeVariants(NotificationVariant.LUMO_SUCCESS);
        notificacion.open();
        try {
            agregarItemsAlGrid();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    private void rechazoFallido(RechazoFallido evento){
        Notification notificacion = new Notification("Fallo al rechazar la solicitud",3000);
        notificacion.setPosition(Notification.Position.TOP_CENTER);
        notificacion.addThemeVariants(NotificationVariant.LUMO_ERROR);
        notificacion.open();
    }

    private void agregarItemsAlGrid() throws IOException, ParseException {
        if (!(controlador.obtenerSolicitudes() == null))
            grid.setItems(controlador.obtenerSolicitudes());
    }
}
