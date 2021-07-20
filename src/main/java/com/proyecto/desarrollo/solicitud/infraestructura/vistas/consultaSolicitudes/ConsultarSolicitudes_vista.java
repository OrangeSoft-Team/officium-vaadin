package com.proyecto.desarrollo.solicitud.infraestructura.vistas.consultaSolicitudes;


import com.proyecto.desarrollo.ofertaLaboral.infraestructura.vistas.detallesOferta.DetallesOfertaLaboral;
import com.proyecto.desarrollo.solicitud.infraestructura.DTO.SolicitudLaboralDTO;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
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
        grid.setColumns("tituloOferta","cargoOferta","nombreEmpresa","nombreEmpleado");
        /* Se crea el boton de detalle, todavia no se ha implementado la interfaz asi que se deja comentado
        grid.addComponentColumn(item ->crearBotonDetalle()).setHeader("Acciones");
         */
    }

    private void agregarItemsAlGrid() throws IOException, ParseException {
        grid.setItems(controlador.obtenerSolicitudes());
    }
}
