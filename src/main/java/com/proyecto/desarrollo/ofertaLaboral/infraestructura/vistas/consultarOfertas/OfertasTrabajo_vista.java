package com.proyecto.desarrollo.ofertaLaboral.infraestructura.vistas.consultarOfertas;

import com.proyecto.desarrollo.ofertaLaboral.infraestructura.DTO.entrada.OfertaLaboralConsultaDTO;
import com.proyecto.desarrollo.ofertaLaboral.infraestructura.vistas.consultarOfertas.eventos.cancelarOferta.EventoCancelarOferta;
import com.proyecto.desarrollo.ofertaLaboral.infraestructura.vistas.consultarOfertas.eventos.filtrarEstado.EstadoActivo;
import com.proyecto.desarrollo.ofertaLaboral.infraestructura.vistas.consultarOfertas.eventos.filtrarEstado.EstadoInactivo;
import com.proyecto.desarrollo.ofertaLaboral.infraestructura.vistas.detallesOferta.DetallesOfertaLaboral;
import com.proyecto.desarrollo.ofertaLaboral.infraestructura.vistas.crearOferta.CrearOfertaLaboral_vista;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H4;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.notification.NotificationVariant;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.RouteParameters;
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
        addListener(EventoCancelarOferta.class,this::cancelarOferta);
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
        if (controlador.obtenerData() != null)
            grid.setItems(controlador.obtenerData());
        grid.setClassName("grid");
        add(filtros,grid);
    }

    private void configurarGrid() {
        grid.setHeight("40em");
        grid.addClassName("ofertas-laborales");
        grid.removeColumnByKey("uuid");
        grid.addColumn(item ->new Text(item.getDuracion())).setHeader("duracion");
        grid.setColumns("titulo", "cargo","sueldo","duracion","turnoTrabajo","numeroVacantes", "fechaPublicacion","nombreEmpresa");
        grid.addComponentColumn(item ->crearBotonera(item.getUuid(),item.getEstatus())).setHeader("Acciones").setWidth("16em");
    }

    private Div crearBotonera(String uuid,String estatus) {
        Div botones = new Div();
        Button detalle = new Button("Detalle",buttonClickEvent -> {
            /*todo colocar el id de la oferta detalle por parametro */
            getUI().ifPresent(ui -> ui.navigate(DetallesOfertaLaboral.class, new RouteParameters("ofertaID",uuid)));
        });
        detalle.setClassName("detalle-oferta");
        Button cancelar = new Button("Cancelar",buttonClickEvent -> {
            fireEvent(new EventoCancelarOferta(this,uuid));
        });
        cancelar.setClassName("cancelar-oferta");


        Button duplicar = new Button("Duplicar",buttonClickEvent -> {
            try {
                if (controlador.duplicarOferta(uuid)){
                    Notification notificacion = new Notification("Oferta duplicada exitosamente",3000);
                    notificacion.setPosition(Notification.Position.TOP_CENTER);
                    notificacion.addThemeVariants(NotificationVariant.LUMO_SUCCESS);
                    notificacion.open();
                    actualizar(this.controlador.obtenerData());
                }
                else{
                    Notification notificacion = new Notification("Fallo al cancelar la Oferta",3000);
                    notificacion.setPosition(Notification.Position.TOP_CENTER);
                    notificacion.addThemeVariants(NotificationVariant.LUMO_ERROR);
                    notificacion.open();
                }
            } catch (ParseException | IOException e) {
                e.printStackTrace();
            }
        });
        duplicar.setClassName("duplicar-oferta");

        if (estatus.equals("inactivo"))
            botones.add(detalle,duplicar);
        else
            botones.add(detalle,cancelar,duplicar);
        return botones;
    }

    private Div botoneraEstados(){
        Div estados = new Div();
        estados.setClassName("estados");

        /*Boton de ofertas activas*/
        Button activo = new Button("Ofertas Publicadas");
        activo.setClassName("ofertas-activas");

        /*Boton de ofertas inactivas*/
        Button inactivo = new Button("Ofertas Canceladas");
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
                actualizar(controlador.filtrarFechaPubli(filtroFecha.getValue().format(DateTimeFormatter.ofPattern("YYYY/MM/dd"))));
                System.out.println(filtroFecha.getValue().format(DateTimeFormatter.ofPattern("YYYY-MM-dd")));
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
            if (!filtroFecha.isEmpty()) filtroFecha.clear();
            if (!filtroEmpresa.isEmpty()) filtroEmpresa.clear();
        });

        inactivo.addClickListener(e-> {
            /*Si el boton de filtrado por activo esta activado, se le quita el css al boton*/
            if (activo.hasClassName("consulta-activos")){
                activo.removeClassName("consulta-activos");
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
            if (!filtroFecha.isEmpty()) filtroFecha.clear();
            if (!filtroEmpresa.isEmpty()) filtroEmpresa.clear();
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

    private void cancelarOferta(EventoCancelarOferta evento){

            if (controlador.cancelarOferta(evento.getUuid())){
                Notification notificacion = new Notification("Oferta cancelada exitosamente",3000);
                notificacion.setPosition(Notification.Position.TOP_CENTER);
                notificacion.addThemeVariants(NotificationVariant.LUMO_SUCCESS);
                notificacion.open();
                try {
                    actualizar(controlador.obtenerData());
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
            else{
                Notification notificacion = new Notification("Fallo al cancelar la Oferta",3000);
                notificacion.setPosition(Notification.Position.TOP_CENTER);
                notificacion.addThemeVariants(NotificationVariant.LUMO_ERROR);
                notificacion.open();
            }
    }
}
