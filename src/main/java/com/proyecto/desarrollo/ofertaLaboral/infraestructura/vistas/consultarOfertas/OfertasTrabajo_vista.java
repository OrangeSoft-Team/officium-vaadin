package com.proyecto.desarrollo.ofertaLaboral.infraestructura.vistas.consultarOfertas;

import com.proyecto.desarrollo.ofertaLaboral.infraestructura.DTO.entrada.OfertaLaboralConsultaDTO;
import com.proyecto.desarrollo.ofertaLaboral.infraestructura.vistas.detallesOferta.DetallesOfertaLaboral;
import com.proyecto.desarrollo.ofertaLaboral.infraestructura.vistas.crearOferta.CrearOfertaLaboral_vista;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.RouterLink;
import org.json.simple.parser.ParseException;

import java.io.IOException;

//@Route(value = "ofertas_trabajo", layout = MainLayout.class)
@PageTitle("Ofertas Laboral")
public class OfertasTrabajo_vista extends Div {

    /*Grid de Ofertas Laborales*/
    Grid<OfertaLaboralConsultaDTO> grid = new Grid(OfertaLaboralConsultaDTO.class);
    private ServicioOfertaLaboral controlador;


    public OfertasTrabajo_vista() throws IOException, ParseException {
        addClassName("contenido");
        setHeightFull();
        /*Instanciar un controlador*/
        controlador = new ServicioOfertaLaboral();

        /*Crear un div donde estara el boton de crear*/
        Div agregar = new Div();
        Div inner = new Div();
        inner.setWidth("200px");
        inner.addClassName("agregarOferta");
        Button boton = new Button("Crear oferta laboral");
        boton.setClassName("crear");
        RouterLink crear = new RouterLink("", CrearOfertaLaboral_vista.class);
        crear.getElement().appendChild(boton.getElement());
        inner.add(crear);
        agregar.add(inner);

        addClassName("oferta-laboral-vista");
        /*Metodo para configurar las columnas que se mostraran en el grid*/
        configurarGrid();
        grid.setItems(controlador.obtenerData());
        grid.setClassName("grid");
        add(agregar,grid);

    }

    private void configurarGrid() {
        grid.setHeight("40em");
        grid.addClassName("ofertas-laborales");
        grid.removeColumnByKey("id");
        grid.setColumns("titulo", "cargo","sueldo","duracion","turnoTrabajo","numeroVacantes", "fechaPublicacion");
        grid.addComponentColumn(item ->crearBotonDetalle()).setHeader("Acciones");
    }

    private Button crearBotonDetalle() {
        Button boton = new Button("Detalle",buttonClickEvent -> {
            /*todo colocar el id de la oferta detalle por parametro */
            getUI().ifPresent(ui -> ui.navigate(DetallesOfertaLaboral.class));
        });
        return boton;
    }


}
