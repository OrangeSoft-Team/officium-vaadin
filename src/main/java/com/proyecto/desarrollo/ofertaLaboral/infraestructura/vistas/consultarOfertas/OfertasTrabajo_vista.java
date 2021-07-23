package com.proyecto.desarrollo.ofertaLaboral.infraestructura.vistas.consultarOfertas;

import com.proyecto.desarrollo.ofertaLaboral.infraestructura.DTO.entrada.OfertaLaboralConsultaDTO;
import com.proyecto.desarrollo.ofertaLaboral.infraestructura.vistas.consultarOfertas.eventos.EstadoActivo;
import com.proyecto.desarrollo.ofertaLaboral.infraestructura.vistas.consultarOfertas.eventos.EstadoInactivo;
import com.proyecto.desarrollo.ofertaLaboral.infraestructura.vistas.consultarOfertas.eventos.EventoAplicarFiltroEstado;
import com.proyecto.desarrollo.ofertaLaboral.infraestructura.vistas.detallesOferta.DetallesOfertaLaboral;
import com.proyecto.desarrollo.ofertaLaboral.infraestructura.vistas.crearOferta.CrearOfertaLaboral_vista;
import com.vaadin.flow.component.FocusNotifier;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H4;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.RouterLink;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.time.format.DateTimeFormatter;

//@Route(value = "ofertas_trabajo", layout = MainLayout.class)
@PageTitle("Ofertas Laboral")
public class OfertasTrabajo_vista extends Div {

    /*Grid de Ofertas Laborales*/
    Grid<OfertaLaboralConsultaDTO> grid = new Grid(OfertaLaboralConsultaDTO.class);
    private ServicioOfertaLaboral controlador;


    public OfertasTrabajo_vista() throws IOException, ParseException{
        addClassName("contenido");
        setHeightFull();
        addClassName("oferta-laboral-vista");
        configurarVista();
        addListener(EstadoActivo.class,this::filtrarActivo);
        addListener(EstadoInactivo.class,this::filtrarInactivo);
    }

    private void configurarVista() throws IOException, ParseException{
        /*Instanciar un controlador*/
        controlador = new ServicioOfertaLaboral();

        /*Crear un div donde estaran los filtros*/
        HorizontalLayout filtros = new HorizontalLayout();
        filtros.setClassName("filtro");
        filtros.setWidthFull();

        Div botonera = new Div();
        botonera.setClassName("botonera-consulta");
        botonera.setWidth("90%");

        Div estados = botoneraEstados();

        Div contenedorTitulo = new Div();
        contenedorTitulo.setWidth("50px");
        H4 tituloFiltro = new H4("Filtros: ");
        tituloFiltro.setClassName("titulo-filtro");
        contenedorTitulo.add(tituloFiltro);

        botonera.add(estados);
        filtros.add(contenedorTitulo,botonera);

        /*Metodo para configurar las columnas que se mostraran en el grid*/
        configurarGrid();
        grid.setItems(controlador.obtenerData());
        grid.setClassName("grid");
        add(filtros,grid);
    }

    private void configurarGrid() {
        grid.setHeight("40em");
        grid.addClassName("ofertas-laborales");
        grid.removeColumnByKey("id");
        grid.setColumns("titulo", "cargo","sueldo","duracion","turnoTrabajo","numeroVacantes", "fechaPublicacion","nombreEmpresa");
        grid.addComponentColumn(item ->crearBotonDetalle()).setHeader("Acciones");
    }

    private Button crearBotonDetalle() {
        Button boton = new Button("Detalle",buttonClickEvent -> {
            /*todo colocar el id de la oferta detalle por parametro */
            getUI().ifPresent(ui -> ui.navigate(DetallesOfertaLaboral.class));
        });
        return boton;
    }

    private Div botoneraEstados(){
        Div estados = new Div();
        estados.setClassName("estados");

        /*Boton de ofertas activas*/
        Button activo = new Button("Ofertas Activas");
        activo.setClassName("ofertas-activas");

        /*Boton de ofertas inactivas*/
        Button inactivo = new Button("Ofertas Inactivas");
        inactivo.setClassName("ofertas-inactivas");

        /*Filtro por nombre de empresa*/
        TextField filtroEmpresa = new TextField();
        DatePicker filtroFecha = new DatePicker();
        filtroEmpresa.setLabel("Nombre de Empresa");
        filtroEmpresa.setWidth("11em");
        filtroEmpresa.addValueChangeListener(e->{
            actualizar(controlador.filtrarEmpresa(filtroEmpresa.getValue()));
            /*Quita el css de los botones por si alguno esta encendido*/
            if (inactivo.hasClassName("consulta-inactivos")){
                inactivo.removeClassName("consulta-inactivos");
            }
            if (activo.hasClassName("consulta-activos")){
                activo.removeClassName("consulta-activos");
            }
        });
        filtroEmpresa.addFocusListener(e->{
                filtroFecha.clear();
        });

        filtroFecha.setClassName("filtro-fecha");
        filtroFecha.setLabel("Fecha de publicación");
        filtroFecha.setClearButtonVisible(true);
        filtroFecha.setPlaceholder("DD/MM/YYYY");
        filtroFecha.addFocusListener(e->{
            filtroEmpresa.setValue("");
        });
        filtroFecha.addValueChangeListener(e->{
            if (filtroFecha.isEmpty()) {
                actualizar(controlador.getOfertasLaborales());
            }
            else {
                actualizar(controlador.filtrarFechaPubli(filtroFecha.getValue().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))));
                if (inactivo.hasClassName("consulta-inactivos")) {
                    inactivo.removeClassName("consulta-inactivos");
                }
                if (activo.hasClassName("consulta-activos")) {
                    activo.removeClassName("consulta-activos");
                }
            }
        });

        RouterLink crear = botoneraCrearOferta();
        estados.add(activo, inactivo,filtroEmpresa,filtroFecha,crear);

        /*Se agrega el listener para disparar el evento en caso de hacer click*/
        activo.addClickListener(e-> {
            /*Si el boton de filtrado por inactivo esta activado, se le quita el css al boton*/
            if (inactivo.hasClassName("consulta-inactivos")){
                inactivo.removeClassName("consulta-inactivos");
                /*Se borran los filtros*/
                filtroFecha.clear();
                filtroEmpresa.setValue("");
            }
            /*Si el filtro ya estaba aplicado se elimina el filtro y se le quita el css al boton*/
            if (activo.hasClassName("consulta-activos")){
                activo.removeClassName("consulta-activos");
                quitarFiltro();
            }
            /*Si no se cumple la condicion anterior se  aplica el filtro por estado activo*/
            else {
                activo.addClassName("consulta-activos");
                fireEvent(new EstadoActivo(this));
            }
        });

        inactivo.addClickListener(e-> {
            /*Si el boton de filtrado por activo esta activado, se le quita el css al boton*/
            if (activo.hasClassName("consulta-activos")){
                activo.removeClassName("consulta-activos");
                /*Se borran los filtros*/
                filtroFecha.clear();
                filtroEmpresa.setValue("");
            }
            /*Si el filtro ya estaba aplicado se elimina el filtro y se le quita el css al boton*/
            if (inactivo.hasClassName("consulta-inactivos")){
                inactivo.removeClassName("consulta-inactivos");
                quitarFiltro();
            }
            /*Si no se cumple la condicion anterior se  aplica el filtro por estado activo*/
            else {
                inactivo.addClassName("consulta-inactivos");
                fireEvent(new EstadoInactivo(this));
            }
        });

        return estados;
    }

    private RouterLink botoneraCrearOferta(){
        /*Se crea el boton*/
        Button boton = new Button("Crear oferta laboral");
        boton.setClassName("crear");

        /*Se crea la redirección*/
        RouterLink crear = new RouterLink("", CrearOfertaLaboral_vista.class);
        crear.getElement().appendChild(boton.getElement());

        return crear;
    }

    /*Filtra por activos*/
    private void filtrarActivo(EstadoActivo event){
        actualizar(controlador.filtrar(event.getEstado()));
    }

    /*Filtra por inactivos*/
    private void filtrarInactivo(EstadoInactivo event){
        actualizar(controlador.filtrar(event.getEstado()));
    }

    /*Quita los filtros*/
    private void quitarFiltro(){
        actualizar(controlador.getOfertasLaborales());
    }

    private void actualizar(OfertaLaboralConsultaDTO[] ofertas){
        grid.setItems(ofertas);
    }
}
