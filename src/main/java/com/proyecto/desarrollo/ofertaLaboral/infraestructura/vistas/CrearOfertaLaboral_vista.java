package com.proyecto.desarrollo.ofertaLaboral.infraestructura.vistas;

import com.proyecto.desarrollo.empresas.infraestructura.DTO.entrada.ConsultarEmpresasParaCreacion;
import com.proyecto.desarrollo.ofertaLaboral.dominio.OfertaLaboral;
import com.proyecto.desarrollo.ofertaLaboral.infraestructura.vistas.controladores.ServicioCrearOfertaLaboral;
import com.proyecto.desarrollo.comunes.infraestructura.layout.MainLayout;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.select.Select;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouterLink;
import org.json.simple.parser.ParseException;


@Route(value = "crear-ofertas-laboral", layout = MainLayout.class)
@PageTitle("Crear Ofertas Laboral")
public class CrearOfertaLaboral_vista extends Div{


    private TextField titulo;

    private TextArea descripcion;

    private TextField cargo;

    private TextField sueldo;

    private TextField duracion;

    private Select<String> escala;

    private Select<String> turno;

    private TextField vacantes;

    private Select<ConsultarEmpresasParaCreacion> empresas;

    private Button submitt;

    private Button cancelar;

    private ServicioCrearOfertaLaboral controlador;

    public CrearOfertaLaboral_vista() throws ParseException {
        controlador = new ServicioCrearOfertaLaboral();

        setHeightFull();
        addClassName("contenido");

        VerticalLayout contenedor = new VerticalLayout();
        contenedor.setClassName("space");

        Div card = new Div();
        card.setClassName("card form");

        HorizontalLayout encabezado = new HorizontalLayout();
        encabezado.setClassName("encabezado");
        encabezado.add(new H3("Crear Oferta Laboral"));
        encabezado.setWidthFull();


        Div contenido = new Div();


        FormLayout crearOferta = new FormLayout();
        crearOferta.setMaxWidth("80em");

        titulo = new TextField();
        titulo.setMaxLength(80);
        titulo.setHelperText("Maximo 80 caracteres");
        titulo.addValueChangeListener(e-> {
            if (listoParaEnviar() && !sueldo.isInvalid() && !duracion.isInvalid() && !vacantes.isInvalid()) submitt.setEnabled(true);
        });
        titulo.setLabel("Titulo");
        titulo.setPlaceholder("Se busca Conserje");

        descripcion = new TextArea();
        descripcion.setMaxLength(512);
        descripcion.setHelperText("Maximo 512 caracteres");
        descripcion.addValueChangeListener(e-> {
            if (listoParaEnviar() && !sueldo.isInvalid() && !duracion.isInvalid() && !vacantes.isInvalid()) submitt.setEnabled(true);
        });
        descripcion.setLabel("Descripción");
        descripcion.setPlaceholder("Se solicita personal de limpieza para la empresa Orangesoft");

        cargo = new TextField();
        cargo.setMaxLength(40);
        cargo.setHelperText("Maximo 40 caracteres");
        cargo.addValueChangeListener(e-> {
            if (listoParaEnviar() && !sueldo.isInvalid() && !duracion.isInvalid() && !vacantes.isInvalid()) submitt.setEnabled(true);
        });
        cargo.setLabel("Cargo");
        cargo.setPlaceholder("Conserje");


        sueldo = new TextField();
        sueldo.setPattern("^([0-9]*[.])?[0-9]{2}$");
        sueldo.setMaxLength(9);
        sueldo.setHelperText("Maximo 2 decimales y 1000000.   Ej: 5012.00");
        sueldo.addValueChangeListener(e-> {
            if (listoParaEnviar() && !sueldo.isInvalid() && !duracion.isInvalid() && !vacantes.isInvalid()) submitt.setEnabled(true);
            System.out.println(!sueldo.isInvalid());
        });
        sueldo.setLabel("Sueldo($)");
        sueldo.setPlaceholder("800");

        duracion = new TextField();
        duracion.setMaxLength(2);
        duracion.setHelperText("Maximo 99");
        duracion.addValueChangeListener(e-> {
            if (listoParaEnviar() && !sueldo.isInvalid() && !duracion.isInvalid() && !vacantes.isInvalid()) submitt.setEnabled(true);
        });
        duracion.setPattern("[1-9]?[0-9]");
        duracion.setLabel("Duracion");
        duracion.setPlaceholder("5");

        escala = new Select<>();
        escala.addValueChangeListener(e-> {
            if (listoParaEnviar() && !sueldo.isInvalid() && !duracion.isInvalid() && !vacantes.isInvalid()) submitt.setEnabled(true);
        });
        escala.setItems("hora","dia","mes","año");

        turno = new Select<>();
        turno.addValueChangeListener(e-> {
            if (listoParaEnviar() && !sueldo.isInvalid() && !duracion.isInvalid() && !vacantes.isInvalid()) submitt.setEnabled(true);
        });
        turno.setItems("diurno","nocturno","mixto");
        turno.setLabel("Turno de trabajo");
        turno.setWidth("3em");

        vacantes = new TextField();
        vacantes.setMaxLength(2);
        vacantes.setHelperText("Maximo 99");
        vacantes.addValueChangeListener(e-> {
            if (listoParaEnviar() && !sueldo.isInvalid() && !duracion.isInvalid() && !vacantes.isInvalid()) submitt.setEnabled(true);
        });
        vacantes.setLabel("Cantidad de puestos disponibles");
        vacantes.setPattern("[1-9]?[0-9]");
        vacantes.setPlaceholder("3");

        empresas = new Select<>();
        empresas.setLabel("Empresa a la que pertenece");
        empresas.setItemLabelGenerator(ConsultarEmpresasParaCreacion::getNombre);
        empresas.setItems(controlador.obtenerEmpresas());

        /*Falta el ID de la empresa*/
        crearOferta.add(titulo, cargo,sueldo,duracion,escala,turno,vacantes,empresas,descripcion);

        contenido.add(crearOferta);
        contenido.setClassName("espacio");


        Div enviar = new Div();
        enviar.setWidthFull();
        Div inner = new Div();
        inner.setWidth("250px");
        inner.setClassName("enviar");
        submitt = new Button("Crear");
        submitt.setClassName("btonEnviar");
        submitt.addClickListener(e -> crear());
        submitt.setEnabled(false);
        cancelar = new Button("Cancelar");

        cancelar.setClassName("cancelar buttonsSpace");
        RouterLink routerLink = new RouterLink("",OfertasTrabajo_vista.class);
        routerLink.getElement().appendChild(cancelar.getElement());
        inner.add(routerLink,submitt);
        enviar.add(inner);


        card.add(encabezado,contenido,enviar);
        contenedor.add(card);

        crearOferta.setResponsiveSteps(
                new FormLayout.ResponsiveStep("1px",1),
                new FormLayout.ResponsiveStep("600px",2),
                new FormLayout.ResponsiveStep("700px",3)
        );

        add(contenedor);
    }

    private void crear() {
        OfertaLaboral ofertaCreada = controlador.generarOferta(this.titulo.getValue(),this.descripcion.getValue(),this.cargo.getValue(),Float.parseFloat(this.sueldo.getValue()),Integer.parseInt(this.duracion.getValue()),this.escala.getValue(),this.turno.getValue(), Integer.parseInt(this.vacantes.getValue()),this.empresas.getValue().getUUID());
        if(controlador.ofertaValida(ofertaCreada)) {
            controlador.crearOferta(ofertaCreada);
            this.submitt.getUI().ifPresent(ui -> ui.navigate(OfertasTrabajo_vista.class));
        }
    }

    private boolean listoParaEnviar(){
        if (this.titulo.isEmpty() || this.descripcion.isEmpty() || this.cargo.isEmpty() || this.sueldo.isEmpty() || this.duracion.isEmpty() || this.escala.isEmpty() || this.turno.isEmpty() || this.vacantes.isEmpty())
            return false;
        return true;
    }


}
