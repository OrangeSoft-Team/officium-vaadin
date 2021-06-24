package com.proyecto.desarrollo.ui.vistas.ofertasTrabajo;

import com.proyecto.desarrollo.backend.entidades.ofertaLaboral.dominio.OfertaLaboral;
import com.proyecto.desarrollo.backend.entidades.ofertaLaboral.dominio.valueObjects.Titulo;
import com.proyecto.desarrollo.backend.servicios.ServicioOfertaLaboral;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.PageTitle;
import com.proyecto.desarrollo.ui.vistas.layout.MainLayout;

@Route(value = "ofertas-trabajo", layout = MainLayout.class)
@PageTitle("Ofertas de Trabajo")
public class OfertasTrabajo_vista extends Div {

    /*Grid de Ofertas Laborales*/
    Grid<OfertaLaboral> grid = new Grid(OfertaLaboral.class);
    private Button boton;


    public OfertasTrabajo_vista() {
        addClassName("oferta-laboral-vista");

        add(grid);
    }

    private void configurarGrid() {
        grid.addClassName("ofertas-laborales");
        grid.removeAllColumns();

    }

}
