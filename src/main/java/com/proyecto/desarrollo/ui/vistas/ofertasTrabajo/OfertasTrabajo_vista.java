package com.proyecto.desarrollo.ui.vistas.ofertasTrabajo;


import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.PageTitle;
import com.proyecto.desarrollo.ui.vistas.layout.MainLayout;

@Route(value = "", layout = MainLayout.class)
@PageTitle("Ofertas de Trabajo")
public class OfertasTrabajo_vista extends Div {

    Button boton;

    public OfertasTrabajo_vista(){
        boton = new Button("hola");
        add(boton);
    }
}
