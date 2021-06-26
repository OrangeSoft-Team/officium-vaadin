package com.proyecto.desarrollo.ui.vistas.ofertasTrabajo;

import com.proyecto.desarrollo.backend.entidades.ofertaLaboral.infraestructura.ClasesParaVaadin.OfertaLaboralGridVaadin;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.PageTitle;
import com.proyecto.desarrollo.ui.vistas.layout.MainLayout;

@Route(value = "ofertas-trabajo", layout = MainLayout.class)
@PageTitle("Ofertas de Trabajo")
public class OfertasTrabajo_vista extends Div {

    /*Grid de Ofertas Laborales*/
    Grid<OfertaLaboralGridVaadin> grid = new Grid(OfertaLaboralGridVaadin.class);
    private Button agregar;


    public OfertasTrabajo_vista() {
        agregar = new Button("Agregar nueva oferta");
        addClassName("oferta-laboral-vista");
        configurarGrid();
        add(agregar,grid);
    }

    private void configurarGrid() {
        grid.addClassName("ofertas-laborales");
        grid.removeColumnByKey("id");
        grid.setColumns("titulo", "cargo","sueldo","duracion","turnoTrabajo","numeroVacantes", "fechaPublicacion");
        /* To do cuando se implemente los detalles de una oferta laboral
        grid.addColumn(OfertaLaboralGridVaadin -> {
            Button modificar = new Button("Modificar");
            habria que colocar el listener para lanzar el modificar
            return modificar;
        }).setHeader("Acciones");
        */
    }

}
