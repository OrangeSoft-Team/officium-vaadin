package com.proyecto.desarrollo.ofertaLaboral.infraestructura.vistas.detallesOferta;

import com.proyecto.desarrollo.comunes.infraestructura.DTOs.HabilidadDTO;
import com.proyecto.desarrollo.ofertaLaboral.dominio.OfertaLaboral;
import com.proyecto.desarrollo.ofertaLaboral.infraestructura.DTO.entrada.OfertaLaboralDetalleDTO;
import com.proyecto.desarrollo.ofertaLaboral.infraestructura.vistas.consultarOfertas.OfertasTrabajo_vista;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.select.Select;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.BeforeEnterEvent;
import com.vaadin.flow.router.BeforeEnterObserver;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.RouterLink;
import org.json.simple.parser.ParseException;

import java.io.IOException;

//@Route(value = "detalle-oferta", layout = MainLayout.class)
@PageTitle("Detalles de Oferta Laboral")
public class DetallesOfertaLaboral extends Div implements BeforeEnterObserver {

    private TextField titulo;

    private TextArea descripcion;

    private TextField cargo;

    private TextField sueldo;

    private TextField duracion;

    private Select<String> escala;

    private Select<String> turno;

    private TextField vacantes;

    private TextField empresasActual;

    private TextField fechaPublicacion;

    private TextField fechaModiciacion;

    private Button cancelar;

    private ServicioDetalleOfertaLaboral controlador;

    private OfertaLaboralDetalleDTO ofertaDetallada;

    private Select<HabilidadDTO> habilidades1;

    private Select<HabilidadDTO> habilidades2;

    private Select<HabilidadDTO> habilidades3;

    private HabilidadDTO[] habilidades;

    private HabilidadDTO[] habilidadesCompletas;

    private TextArea requisitosEspeciales;

    private Boolean edicion = false;

    private Button enviarModificacion;

    private H3 tituloPag;

    private Boolean modificacionExitosa = false;

    /*este metodo se ejecuta despues del contrsuctor y lo que hace es rellenar los campos*/
    @Override
    public void beforeEnter(BeforeEnterEvent event) {
        try {
            ofertaDetallada = controlador.obtenerOferta(event.getRouteParameters().get("ofertaID").get());
            rellenarInformacion();
        } catch (ParseException | IOException e) {
            e.printStackTrace();
        }
    }

    public DetallesOfertaLaboral() {
        controlador = new ServicioDetalleOfertaLaboral();
        setHeightFull();
        setClassName("ofertaDetalle");

        /*Se crea un contenedor para el contenido*/
        VerticalLayout contenedor = new VerticalLayout();
        contenedor.setClassName("spacer");

        /*Se crea un Div que se mostrará como una carta*/
        Div card = new Div();
        card.setClassName("card form");

        /*Titulo de la carta*/
        HorizontalLayout encabezado = new HorizontalLayout();
        encabezado.setClassName("encabezado");
        Div contenedorHeader = new Div();
        this.tituloPag = new H3("Detalles Oferta Laboral");
        contenedorHeader.add(this.tituloPag);
        contenedorHeader.setWidth("240px");
        contenedorHeader.setClassName("header");

        Div editarContenedor = new Div();
        Button editar = new Button("Editar", buttonClickEvent -> {
            convertirEditable();
        });
        editar.setClassName("boton-editar");
        editarContenedor.setClassName("editar");
        editarContenedor.setWidth("100px");
        editarContenedor.add(editar);

        encabezado.add(contenedorHeader,editarContenedor);


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
        titulo.setReadOnly(true);

        /*Cargo*/
        cargo = new TextField();
        cargo.setMaxLength(40);
        cargo.setLabel("Cargo");
        cargo.setReadOnly(true);

        /*Sueldo*/
        sueldo = new TextField();
        sueldo.setPattern("^([0-9]*[.])?[0-9]{2}$");
        sueldo.setMaxLength(9);
        sueldo.setLabel("Sueldo($)");
        sueldo.setReadOnly(true);

        /*Duracion Valor*/
        duracion = new TextField();
        duracion.setMaxLength(2);
        duracion.setPattern("[1-9]?[0-9]");
        duracion.setLabel("Duracion");
        duracion.setReadOnly(true);

        /*Duracion Escala*/
        escala = new Select<>();
        escala.setItems("hora","dia","mes","año");
        escala.setReadOnly(true);

        /*Turno Trabajo*/
        turno = new Select<>();
        turno.setItems("diurno","nocturno","mixto");
        turno.setLabel("Turno de trabajo");
        turno.setReadOnly(true);

        /*Puestos Disponibles*/
        vacantes = new TextField();
        vacantes.setMaxLength(2);
        vacantes.setLabel("Cantidad de puestos disponibles");
        vacantes.setPattern("[1-9]?[0-9]");
        vacantes.setReadOnly(true);

        /*Empresa a la que pertenece*/
        empresasActual = new TextField();
        empresasActual.setReadOnly(true);
        empresasActual.setLabel("Nombre de la Empresa");

        /*Descripcion*/
        descripcion = new TextArea();
        descripcion.setMaxLength(512);
        descripcion.setLabel("Descripción");
        descripcion.setReadOnly(true);

        /*Fecha Publicacion*/
        fechaPublicacion = new TextField();
        fechaPublicacion.setLabel("Fecha publicación");
        fechaPublicacion.setReadOnly(true);

        /*Fecha Modificacion*/
        fechaModiciacion = new TextField();
        fechaModiciacion.setLabel("Fecha Modificación");
        fechaModiciacion.setReadOnly(true);

        /*Habilidad 1*/
        habilidades1 = new Select<>();
        habilidades1.setLabel("Habilidades requeridas");
        habilidades1.setItemLabelGenerator(HabilidadDTO::getNombre);
        habilidades1.addValueChangeListener(e->{
            habilidades[0] = habilidades1.getValue();
        });
        habilidades1.setReadOnly(true);


        habilidades2 = new Select<>();
        habilidades2.setLabel("Habilidades requeridas (opcional)");
        habilidades2.setItemLabelGenerator(HabilidadDTO::getNombre);
        habilidades2.addValueChangeListener(e->{
            habilidades[1] = habilidades2.getValue();
        });
        habilidades2.setReadOnly(true);

        habilidades3 = new Select<>();
        habilidades3.setLabel("Habilidades requeridas (opcional)");
        habilidades3.setItemLabelGenerator(HabilidadDTO::getNombre);
        habilidades3.addValueChangeListener(e->{
            habilidades[2] = habilidades3.getValue();
        });
        habilidades3.setReadOnly(true);

        requisitosEspeciales = new TextArea();
        requisitosEspeciales.setLabel("Requisitos Adicionales (Opcional)");
        requisitosEspeciales.setMaxLength(256);
        requisitosEspeciales.setReadOnly(true);

        /*Añadir los componentes del form al form*/
        detalleOferta.add(titulo,cargo,sueldo,duracion,escala,turno,vacantes,fechaPublicacion,fechaModiciacion, habilidades1,habilidades2, habilidades3,descripcion,empresasActual,requisitosEspeciales);
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

        enviarModificacion = new Button("Enviar",buttonClickEvent -> {
            verificar(this.ofertaDetallada.getId(),false);
        });
        enviarModificacion.setVisible(false);
        enviarModificacion.setClassName("enviar-modificacion");

        inner.add(volver,enviarModificacion);
        enviar.add(inner);

        /*Añadir el contenido*/
        contenido.add(detalleOferta);
        /*Añadir todo al card*/
        card.add(encabezado,contenido,enviar);

        contenedor.add(card);

        /*Añadir todo al contenedor*/
        add(contenedor);
    }

    public DetallesOfertaLaboral(Boolean prueba){
        controlador = new ServicioDetalleOfertaLaboral();
        titulo = new TextField();
        titulo.setMaxLength(80);
        cargo = new TextField();
        cargo.setMaxLength(40);
        sueldo = new TextField();
        sueldo.setMaxLength(9);
        duracion = new TextField();
        duracion.setMaxLength(2);
        escala = new Select<>();
        escala.setItems("hora","dia","mes","año");
        turno = new Select<>();
        turno.setItems("diurno","nocturno","mixto");
        vacantes = new TextField();
        vacantes.setMaxLength(2);
        empresasActual = new TextField();
        fechaPublicacion = new TextField();
        fechaModiciacion = new TextField();
        descripcion = new TextArea();
        descripcion.setMaxLength(512);
        habilidades1 = new Select<>();
        habilidades1.setLabel("Habilidades requeridas");
        habilidades1.addValueChangeListener(e->{
            habilidades[0] = habilidades1.getValue();
        });
        habilidades2 = new Select<>();
        habilidades2.addValueChangeListener(e->{
            habilidades[1] = habilidades2.getValue();
        });
        habilidades3 = new Select<>();
        habilidades3.addValueChangeListener(e->{
            habilidades[2] = habilidades3.getValue();
        });
        requisitosEspeciales = new TextArea();
        requisitosEspeciales.setMaxLength(256);
        enviarModificacion = new Button("Enviar",buttonClickEvent -> {
            verificar(this.ofertaDetallada.getId(),prueba);
        });
    }

    private void rellenarInformacion() throws ParseException {
        habilidades = ofertaDetallada.getHabilidades();
        habilidadesCompletas = controlador.obtenerHabilidades();
        titulo.setValue(this.ofertaDetallada.getTitulo());
        cargo.setValue(this.ofertaDetallada.getCargo());
        sueldo.setValue(Float.toString(this.ofertaDetallada.getSueldo()));
        duracion.setValue(Integer.toString(this.ofertaDetallada.getDuracionValor()));
        escala.setValue(this.ofertaDetallada.getDuracionEscala());
        turno.setValue(this.ofertaDetallada.getTurnoTrabajo());
        vacantes.setValue(Integer.toString(this.ofertaDetallada.getNumeroVacantes()));
        empresasActual.setValue(this.ofertaDetallada.getNombreEmpresa());
        descripcion.setValue(this.ofertaDetallada.getDescripcion());
        fechaPublicacion.setValue(this.ofertaDetallada.getFechaPublicacion());
        fechaModiciacion.setValue(this.ofertaDetallada.getFechaModificacion());
        habilidades1.setItems(habilidadesCompletas);
        habilidades1.setValue(habilidadesCompletas[controlador.getHabilidad(habilidadesCompletas,habilidades[0].getId())]);
        habilidades2.setItems(habilidadesCompletas);
        if (habilidades.length >= 2){
            habilidades2.setValue(habilidadesCompletas[controlador.getHabilidad(habilidadesCompletas,habilidades[1].getId())]);
        }
        habilidades3.setItems(habilidadesCompletas);
        if (habilidades.length >= 3){
            habilidades3.setValue(habilidadesCompletas[controlador.getHabilidad(habilidadesCompletas,habilidades[2].getId())]);
        }
        requisitosEspeciales.setValue(this.ofertaDetallada.getRequerimientoEspecial());
    }

    private void convertirEditable(){
        if (!this.edicion) {
            this.tituloPag.setText("Editar oferta Laboral");
            this.titulo.setReadOnly(false);
            this.titulo.setHelperText("Maximo 80 caracteres");
            this.cargo.setReadOnly(false);
            this.cargo.setHelperText("Maximo 40 caracteres");
            this.sueldo.setReadOnly(false);
            this.sueldo.setHelperText("Maximo 1.000.000");
            this.duracion.setReadOnly(false);
            this.duracion.setHelperText("Maximo 99");
            this.escala.setReadOnly(false);
            this.turno.setReadOnly(false);
            this.vacantes.setReadOnly(false);
            this.vacantes.setHelperText("Maximo 99 vacantes");
            this.descripcion.setReadOnly(false);
            this.descripcion.setHelperText("Maximo 512 caracteres");
            this.habilidades1.setReadOnly(false);
            this.habilidades2.setReadOnly(false);
            this.habilidades3.setReadOnly(false);
            this.requisitosEspeciales.setReadOnly(false);
            this.requisitosEspeciales.setHelperText("Maximo 256 caracteres");
            this.enviarModificacion.setVisible(true);
            this.edicion = true;
        }
        else{
            this.tituloPag.setText("Detalles Oferta Laboral");
            this.titulo.setReadOnly(true);
            this.titulo.setHelperText(null);
            this.cargo.setReadOnly(true);
            this.cargo.setHelperText(null);
            this.sueldo.setReadOnly(true);
            this.sueldo.setHelperText(null);
            this.duracion.setReadOnly(true);
            this.duracion.setHelperText(null);
            this.escala.setReadOnly(true);
            this.turno.setReadOnly(true);
            this.vacantes.setReadOnly(true);
            this.vacantes.setHelperText(null);
            this.descripcion.setReadOnly(true);
            this.descripcion.setHelperText(null);
            this.habilidades1.setReadOnly(true);
            this.habilidades2.setReadOnly(true);
            this.habilidades3.setReadOnly(true);
            this.requisitosEspeciales.setReadOnly(true);
            this.requisitosEspeciales.setHelperText(null);
            this.enviarModificacion.setVisible(false);
            this.edicion = false;
        }
    }

    private void verificar(String uuid, Boolean prueba){
        HabilidadDTO[] verificacion;
        if (!habilidades2.isEmpty() && habilidades3.isEmpty()) {
            verificacion = new HabilidadDTO[2];
            verificacion[0] = habilidades1.getValue();
            verificacion[1] = habilidades2.getValue();
        }
        else if (!habilidades2.isEmpty() && !habilidades3.isEmpty()){
            verificacion = new HabilidadDTO[3];
            verificacion[0] = habilidades1.getValue();
            verificacion[1] = habilidades2.getValue();
            verificacion[2] = habilidades3.getValue();
        }
        else{
            verificacion = new HabilidadDTO[1];
            verificacion[0] = habilidades1.getValue();
        }
        OfertaLaboral modificacion = new OfertaLaboral(
                this.titulo.getValue(),
                this.descripcion.getValue(),
                this.cargo.getValue(),
                Float.parseFloat(this.sueldo.getValue()),
                Integer.parseInt(this.duracion.getValue()),
                this.escala.getValue(),
                this.turno.getValue(),
                Integer.parseInt(this.vacantes.getValue()),
                null,
                this.requisitosEspeciales.getValue(),
                verificacion);
        try {
            if (controlador.verificar(modificacion, uuid) && !prueba) {
                Notification notificacion = new Notification("Oferta modificada exitosamente");
                notificacion.setPosition(Notification.Position.TOP_CENTER);
                notificacion.setDuration(3000);
                notificacion.open();
                this.modificacionExitosa = true;
                getUI().ifPresent(ui -> ui.navigate(OfertasTrabajo_vista.class));
            } else if (controlador.verificar(modificacion, uuid) && !prueba) {
                Notification notificacion = new Notification("Oferta no modificada");
                notificacion.setPosition(Notification.Position.TOP_CENTER);
                notificacion.setDuration(3000);
                notificacion.open();
            }
            if (controlador.verificar(modificacion, uuid) && prueba) {
                this.modificacionExitosa = true;
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public OfertaLaboralDetalleDTO getOfertaDetallada() {
        return ofertaDetallada;
    }

    public void setOfertaDetallada(String uuid) {
        try {
            this.ofertaDetallada = controlador.obtenerOferta(uuid);
            rellenarInformacion();
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getTitulo() {
        return titulo.getValue();
    }

    public String getDescripcion() {
        return descripcion.getValue();
    }

    public String getCargo() {
        return cargo.getValue();
    }

    public String getSueldo() {
        return sueldo.getValue();
    }

    public String getDuracion() {
        return duracion.getValue();
    }

    public String getEscala() {
        return escala.getValue();
    }

    public String getTurno() {
        return turno.getValue();
    }

    public String getVacantes() {
        return vacantes.getValue();
    }

    public HabilidadDTO getHabilidades1() {
        return habilidades1.getValue();
    }

    public HabilidadDTO getHabilidades2() {
        return habilidades2.getValue();
    }

    public HabilidadDTO getHabilidades3() {
        return habilidades3.getValue();
    }

    public String getRequisitosEspeciales() {
        return requisitosEspeciales.getValue();
    }

    public Button getEnviarModificacion() {
        return enviarModificacion;
    }

    public void setTitulo(String titulo) {
        this.titulo.setValue(titulo);
    }

    public void setDescripcion(String descripcion) {
        this.descripcion.setValue(descripcion);
    }

    public void setCargo(String cargo) {
        this.cargo.setValue(cargo);
    }

    public void setSueldo(String sueldo) {
        this.sueldo.setValue(sueldo);
    }

    public void setDuracion(String duracion) {
        this.duracion.setValue(duracion);
    }

    public void setEscala(String escala) {
        this.escala.setValue(escala);
    }

    public void setTurno(String turno) {
        this.turno.setValue(turno);
    }

    public void setVacantes(String vacantes) {
        this.vacantes.setValue(vacantes);
    }

    public void setHabilidades1(HabilidadDTO habilidades1) {
        this.habilidades1.setValue(habilidades1);
    }

    public void setHabilidades2(HabilidadDTO habilidades2) {
        this.habilidades2.setValue(habilidades2);
    }

    public void setHabilidades3(HabilidadDTO habilidades3) {
        this.habilidades3.setValue(habilidades3);
    }

    public void setRequisitosEspeciales(String requisitosEspeciales) {
        this.requisitosEspeciales.setValue(requisitosEspeciales);
    }

    public Boolean getModificacionExitosa() {
        return modificacionExitosa;
    }
}
