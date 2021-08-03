package com.proyecto.desarrollo.empleados.infraestructura.vistas;

import com.proyecto.desarrollo.empleados.infraestructura.DTO.entrada.EmpleadoEntradaDTO;
import com.proyecto.desarrollo.empleados.infraestructura.vistas.controladores.Empleados_controlador;
import com.proyecto.desarrollo.ofertaLaboral.infraestructura.DTO.entrada.OfertaLaboralConsultaDTO;
import com.proyecto.desarrollo.ofertaLaboral.infraestructura.vistas.detallesOferta.DetallesOfertaLaboral;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.H4;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.value.ValueChangeMode;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.RouteParameters;

import java.util.ArrayList;
import java.util.List;

@PageTitle("Empleados")
public class ListaEmpleados_vista extends Div {

    Grid<EmpleadoEntradaDTO> grid = new Grid(EmpleadoEntradaDTO.class);
    List<EmpleadoEntradaDTO> lista_empleados_completa = new ArrayList<EmpleadoEntradaDTO>();

    public ListaEmpleados_vista(Empleados_controlador controlador) {

        try {
            lista_empleados_completa = controlador.obtener_lista_empleados();

            addClassName("oferta-laboral-vista");
            addClassName("contenido");
            setHeightFull();

            HorizontalLayout filtros = new HorizontalLayout();
            filtros.setClassName("filtro");
            filtros.setWidthFull();

            Div contenedorTitulo = new Div();
            contenedorTitulo.setWidth("50px");
            H4 tituloFiltro = new H4("Filtros: ");
            tituloFiltro.setClassName("titulo-filtro");
            contenedorTitulo.add(tituloFiltro);

            Div botonera = this.generar_filtros();

            filtros.add(contenedorTitulo, botonera);


            this.configurar_grid();
            grid.setItems(lista_empleados_completa);
            grid.setClassName("grid");
            add(filtros, grid);
        }
        catch (Exception e){
            Notification.show(e.getMessage());
        }

    }

    private void configurar_grid(){
        grid.setHeight("40em");
        grid.addClassName("ofertas-laborales");
        grid.removeColumnByKey("uuid");
        grid.setColumns("primerNombre", "primerApellido" , "correo" , "estatus" , "genero");
        grid.addComponentColumn(item -> this.crear_botones_item(item.getUuid())).setHeader("Acciones").setWidth("16em");
    }

    private Div crear_botones_item(String uuid){
        Div botones = new Div();
        Button detalle = new Button("Detalle",buttonClickEvent -> {
            getUI().ifPresent(ui -> ui.navigate(EmpleadoDetalle_vista.class, new RouteParameters("empleadoID", uuid)));
        });
        detalle.setClassName("detalle-oferta");
        botones.add(detalle);
        return botones;
    }

    private Div generar_filtros(){
        TextField filtro_buscar_por_correo = new TextField("Buscar por correo");
        filtro_buscar_por_correo.setValueChangeMode(ValueChangeMode.EAGER);

        filtro_buscar_por_correo.addValueChangeListener(event -> {

            String subcadena = filtro_buscar_por_correo.getValue();
            List<EmpleadoEntradaDTO> lista_empleados_con_filtro = new ArrayList<EmpleadoEntradaDTO>();
            this.lista_empleados_completa.forEach(empleado -> {
                if(empleado.getCorreo().contains(subcadena)){
                    lista_empleados_con_filtro.add(empleado);
                }
            });
            grid.setItems(lista_empleados_con_filtro);

        });

        Div divestados = new Div();
        divestados.setClassName("estados");
        divestados.add(filtro_buscar_por_correo);

        Div botonera = new Div();
        botonera.setClassName("botonera-consulta");
        botonera.setWidth("90%");
        botonera.add(divestados);

        return botonera;
    }

}
