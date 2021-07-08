package com.proyecto.desarrollo.ofertaLaboral.infraestructura.vistas.detallesOferta;

import com.proyecto.desarrollo.empresas.infraestructura.DTO.entrada.ConsultarEmpresasParaCreacionDTO;
import com.proyecto.desarrollo.ofertaLaboral.infraestructura.DTO.entrada.OfertaLaboralDetalleDTO;
import com.proyecto.desarrollo.ofertaLaboral.infraestructura.vistas.consultarOfertas.OfertasTrabajo_vista;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.select.Select;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.RouterLink;
import org.json.simple.parser.ParseException;

//@Route(value = "detalle-oferta", layout = MainLayout.class)
@PageTitle("Detalles de Oferta Laboral")
public class DetallesOfertaLaboral extends Div {

    private TextField titulo;

    private TextArea descripcion;

    private TextField cargo;

    private TextField sueldo;

    private TextField duracion;

    private Select<String> escala;

    private Select<String> turno;

    private TextField vacantes;

    private TextField empresasActual;

    private Select<ConsultarEmpresasParaCreacionDTO> empresasDisponibles;

    private TextField fechaPublicacion;

    private TextField fechaModiciacion;

    private TextField direccinEmpresa;

    private Button modificar;

    private Button cancelar;

    private ServicioDetalleOfertaLaboral controlador;

    private OfertaLaboralDetalleDTO ofertaDetallada;

    public DetallesOfertaLaboral() throws ParseException {
        controlador = new ServicioDetalleOfertaLaboral();
        ofertaDetallada = controlador.obtenerOferta();
        setHeightFull();
        setClassName("ofertaDetalle");

        /*Se crea un contenedor para el contenido*/
        VerticalLayout contenedor = new VerticalLayout();
        contenedor.setClassName("spacer");

        /*Se crea un Div que se mostrará como una carta*/
        Div card = new Div();
        card.setClassName("card form");

        /*Titulo de la carta*/
        Div encabezado = new Div();
        encabezado.setClassName("encabezado");
        Div contenedorHeader = new Div(new H3("Detalles Oferta Laboral"));
        contenedorHeader.setWidth("240px");
        contenedorHeader.setClassName("header");
        encabezado.add(contenedorHeader);


        /*Div que tendra el contenido de la Card*/
        Div contenido = new Div();
        contenido.setClassName("espacio");

        /*Form que contendra los campos*/
        FormLayout detalleOferta = new FormLayout();
        detalleOferta.setMaxWidth("80em");

        /*Contenido del form*/
        /*Titulo*/
        titulo = new TextField();
        titulo.setMaxLength(80);
        titulo.setLabel("Titulo");
        titulo.setValue(this.ofertaDetallada.getTitulo());
        titulo.setReadOnly(true);

        /*Cargo*/
        cargo = new TextField();
        cargo.setMaxLength(40);
        cargo.setLabel("Cargo");
        cargo.setValue(this.ofertaDetallada.getCargo());
        cargo.setReadOnly(true);

        /*Sueldo*/
        sueldo = new TextField();
        sueldo.setPattern("^([0-9]*[.])?[0-9]{2}$");
        sueldo.setMaxLength(9);
        sueldo.setLabel("Sueldo($)");
        sueldo.setValue(Float.toString(this.ofertaDetallada.getSueldo()));
        sueldo.setReadOnly(true);

        /*Duracion Valor*/
        duracion = new TextField();
        duracion.setMaxLength(2);
        duracion.setPattern("[1-9]?[0-9]");
        duracion.setLabel("Duracion");
        duracion.setValue(Integer.toString(this.ofertaDetallada.getDuracionValor()));
        duracion.setReadOnly(true);

        /*Duracion Escala*/
        escala = new Select<>();
        escala.setItems("hora","dia","mes","año");
        escala.setValue(this.ofertaDetallada.getDuracionEscala());
        escala.setReadOnly(true);
        escala.setLabel("Duracion");

        /*Turno Trabajo*/
        turno = new Select<>();
        turno.setItems("diurno","nocturno","mixto");
        turno.setLabel("Turno de trabajo");
        turno.setValue(this.ofertaDetallada.getTurnoTrabajo());
        turno.setReadOnly(true);

        /*Puestos Disponibles*/
        vacantes = new TextField();
        vacantes.setMaxLength(2);
        vacantes.setLabel("Cantidad de puestos disponibles");
        vacantes.setPattern("[1-9]?[0-9]");
        vacantes.setValue(Integer.toString(this.ofertaDetallada.getNumeroVacantes()));
        vacantes.setReadOnly(true);

        /*Empresa a la que pertenece*/
        empresasActual = new TextField();
        empresasActual.setReadOnly(true);
        empresasActual.setValue(this.ofertaDetallada.getNombreEmpresa());

        /*Descripcion*/
        descripcion = new TextArea();
        descripcion.setMaxLength(512);
        descripcion.setLabel("Descripción");
        descripcion.setReadOnly(true);
        descripcion.setValue(this.ofertaDetallada.getDescripcion());

        /*Fecha Publicacion*/
        fechaPublicacion = new TextField();
        fechaPublicacion.setLabel("Fecha publicación");
        fechaPublicacion.setValue(this.ofertaDetallada.getFechaPublicacion());
        fechaPublicacion.setReadOnly(true);

        /*Fecha Modificacion*/
        fechaModiciacion = new TextField();
        fechaModiciacion.setLabel("Fecha Modificación");
        fechaModiciacion.setValue(this.ofertaDetallada.getFechaModificacion());
        fechaModiciacion.setReadOnly(true);

        /*Añadir los componentes del form al form*/
        detalleOferta.add(titulo,cargo,sueldo,duracion,escala,turno,vacantes,empresasActual,descripcion);
        /*Redistribucion responsive*/
        detalleOferta.setResponsiveSteps(
                new FormLayout.ResponsiveStep("1px",1),
                new FormLayout.ResponsiveStep("600px",2),
                new FormLayout.ResponsiveStep("700px",3)
        );

        /*Boton*/
        Div enviar = new Div();
        enviar.setWidthFull();
        Div inner = new Div();
        inner.setWidth("250px");
        inner.setClassName("botonera");
        cancelar = new Button("Cancelar");
        cancelar.setClassName("cancelar-detalle");
        /*Esto es para volver a la vista incial*/
        RouterLink volver = new RouterLink("", OfertasTrabajo_vista.class);
        volver.getElement().appendChild(cancelar.getElement());
        inner.add(volver);
        enviar.add(inner);

        /*Añadir el contenido*/
        contenido.add(detalleOferta);
        /*Añadir todo al card*/
        card.add(encabezado,contenido,enviar);

        contenedor.add(card);

        /*Añadir todo al contenedor*/
        add(contenedor);
    }
}
