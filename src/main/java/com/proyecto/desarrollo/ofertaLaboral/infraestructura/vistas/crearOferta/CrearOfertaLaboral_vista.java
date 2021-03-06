package com.proyecto.desarrollo.ofertaLaboral.infraestructura.vistas.crearOferta;

import com.proyecto.desarrollo.comunes.infraestructura.DTOs.HabilidadDTO;
import com.proyecto.desarrollo.empresas.infraestructura.DTO.entrada.ConsultarEmpresasParaCreacionDTO;
import com.proyecto.desarrollo.ofertaLaboral.dominio.OfertaLaboral;
import com.proyecto.desarrollo.ofertaLaboral.infraestructura.vistas.consultarOfertas.OfertasTrabajo_vista;
import com.proyecto.desarrollo.ofertaLaboral.infraestructura.vistas.crearOferta.eventos.confirmacionCreacion.CreacionExitosa;
import com.proyecto.desarrollo.ofertaLaboral.infraestructura.vistas.crearOferta.eventos.confirmacionCreacion.CreacionFallida;
import com.proyecto.desarrollo.ofertaLaboral.infraestructura.vistas.crearOferta.eventos.creacion.CreacionOferta;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.select.Select;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.RouterLink;
import org.json.simple.parser.ParseException;

import java.io.IOException;


//@Route(value = "crear-ofertas-laboral", layout = MainLayout.class)
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

    private Select<ConsultarEmpresasParaCreacionDTO> empresas;

    private Button submitt;

    private Button cancelar;

    private ServicioCrearOfertaLaboral controlador = new ServicioCrearOfertaLaboral();;

    /*Se guarda para test ya que no se ha implementado los eventos*/
    private OfertaLaboral ofertaCreada;

    private Select<HabilidadDTO> habilidades1;

    private Select<HabilidadDTO> habilidades2;

    private Select<HabilidadDTO> habilidades3;

    private TextArea requisitosEspeciales;

    private HabilidadDTO[] habilidades = new HabilidadDTO[3];

    public CrearOfertaLaboral_vista() throws ParseException {
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
            if (listoParaEnviar() && !sueldo.isInvalid() && !duracion.isInvalid() && !vacantes.isInvalid()) {
                submitt.setEnabled(true);
                submitt.setClassName("btonEnviar-active");
            }
        });
        titulo.setLabel("Titulo");
        titulo.setPlaceholder("Se busca Conserje");

        descripcion = new TextArea();
        descripcion.setMaxLength(512);
        descripcion.setHelperText("Maximo 512 caracteres");
        descripcion.addValueChangeListener(e-> {
            if (listoParaEnviar() && !sueldo.isInvalid() && !duracion.isInvalid() && !vacantes.isInvalid()) {
                submitt.setEnabled(true);
                submitt.setClassName("btonEnviar-active");
            }
        });
        descripcion.setLabel("Descripci??n");
        descripcion.setPlaceholder("Se solicita personal de limpieza para la empresa Orangesoft");

        cargo = new TextField();
        cargo.setMaxLength(40);
        cargo.setHelperText("Maximo 40 caracteres");
        cargo.addValueChangeListener(e-> {
            if (listoParaEnviar() && !sueldo.isInvalid() && !duracion.isInvalid() && !vacantes.isInvalid()) {
                submitt.setEnabled(true);
                submitt.setClassName("btonEnviar-active");
            }
        });
        cargo.setLabel("Cargo");
        cargo.setPlaceholder("Conserje");


        sueldo = new TextField();
        sueldo.setPattern("^([0-9]*[.])?[0-9]{2}$");
        sueldo.setMaxLength(9);
        sueldo.setHelperText("Maximo 2 decimales y 1000000.   Ej: 5012.00");
        sueldo.addValueChangeListener(e-> {
            if (listoParaEnviar() && !sueldo.isInvalid() && !duracion.isInvalid() && !vacantes.isInvalid()) {
                submitt.setEnabled(true);
                submitt.setClassName("btonEnviar-active");
            }

        });
        sueldo.setLabel("Sueldo($)");
        sueldo.setPlaceholder("800");

        duracion = new TextField();
        duracion.setMaxLength(2);
        duracion.setHelperText("Maximo 99");
        duracion.addValueChangeListener(e-> {
            if (listoParaEnviar() && !sueldo.isInvalid() && !duracion.isInvalid() && !vacantes.isInvalid()) {
                submitt.setEnabled(true);
                submitt.setClassName("btonEnviar-active");
            }
        });
        duracion.setPattern("[1-9]?[0-9]");
        duracion.setLabel("Duracion");
        duracion.setPlaceholder("5");

        escala = new Select<>();
        escala.addValueChangeListener(e-> {
            if (listoParaEnviar() && !sueldo.isInvalid() && !duracion.isInvalid() && !vacantes.isInvalid()) {
                submitt.setEnabled(true);
                submitt.setClassName("btonEnviar-active");
            }
        });
        escala.setItems("hora","dia","semana","mes");
        escala.setValue("hora");

        turno = new Select<>();
        turno.addValueChangeListener(e-> {
            if (listoParaEnviar() && !sueldo.isInvalid() && !duracion.isInvalid() && !vacantes.isInvalid()) {
                submitt.setEnabled(true);
                submitt.setClassName("btonEnviar-active");
            }
        });
        turno.setItems("diurno","nocturno","mixto");
        turno.setValue("diurno");
        turno.setLabel("Turno de trabajo");
        turno.setWidth("3em");

        vacantes = new TextField();
        vacantes.setMaxLength(2);
        vacantes.setHelperText("Maximo 99");
        vacantes.addValueChangeListener(e-> {
            if (listoParaEnviar() && !sueldo.isInvalid() && !duracion.isInvalid() && !vacantes.isInvalid()) {
                submitt.setEnabled(true);
                submitt.setClassName("btonEnviar-active");
            }
        });
        vacantes.setLabel("Cantidad de puestos disponibles");
        vacantes.setPattern("[1-9]?[0-9]");
        vacantes.setPlaceholder("3");

        empresas = new Select<>();
        empresas.setLabel("Empresa a la que pertenece");
        empresas.setItemLabelGenerator(ConsultarEmpresasParaCreacionDTO::getNombre);
        empresas.setItems(controlador.obtenerEmpresas());
        empresas.addValueChangeListener(e-> {
            if (listoParaEnviar() && !sueldo.isInvalid() && !duracion.isInvalid() && !vacantes.isInvalid()) {
                submitt.setEnabled(true);
                submitt.setClassName("btonEnviar-active");
            }
        });

        habilidades1 = new Select<>();
        habilidades1.setLabel("Habilidades requeridas");
        habilidades1.setItemLabelGenerator(HabilidadDTO::getNombre);
        habilidades1.setItems(controlador.obtenerHabilidades());
        habilidades1.addValueChangeListener(e->{
           if (listoParaEnviar() && !sueldo.isInvalid() && !duracion.isInvalid() && !vacantes.isInvalid()){
               submitt.setEnabled(true);
               submitt.setClassName("btonEnviar-active");
           }
        });


        habilidades2 = new Select<>();
        habilidades2.setLabel("Habilidades requeridas (opcional)");
        habilidades2.setItemLabelGenerator(HabilidadDTO::getNombre);
        habilidades2.setItems(controlador.obtenerHabilidades());

        habilidades3 = new Select<>();
        habilidades3.setLabel("Habilidades requeridas (opcional)");
        habilidades3.setItemLabelGenerator(HabilidadDTO::getNombre);
        habilidades3.setItems(controlador.obtenerHabilidades());



        requisitosEspeciales = new TextArea();
        requisitosEspeciales.setLabel("Requisitos Adicionales (Opcional)");
        requisitosEspeciales.setMaxLength(256);
        requisitosEspeciales.setHelperText("Minimo 4 y Maximo 256 caracteres");
        requisitosEspeciales.setPlaceholder("El solicitante debe estar en un rango de edad de entre 20 - 50 a??os");

        /*Falta el ID de la empresa*/
        crearOferta.add(titulo, cargo,sueldo,duracion,escala,turno,vacantes,descripcion,empresas, habilidades1,habilidades2,habilidades3, requisitosEspeciales);

        contenido.add(crearOferta);
        contenido.setClassName("espacio");


        Div enviar = new Div();
        enviar.setWidthFull();

        Div inner = new Div();
        inner.setWidth("250px");
        inner.setClassName("enviar");

        configurarBotones();
        RouterLink routerLink = new RouterLink("", OfertasTrabajo_vista.class);
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
        /*Agregar un listener a la vista para el evento de creacion*/
        addListener(CreacionOferta.class,this::crearOfertaPersistencia);
        /*Agregar un listener para saber si la creacion en persistencia fue exitosa*/
        addListener(CreacionExitosa.class,this::ofertaCreadaExitosamente);
        /*Agregar un listener para saber si la creacion en persistencia fue fallida*/
        addListener(CreacionFallida.class,this::ofertaNoCreada);
    }

    public CrearOfertaLaboral_vista(OfertaLaboral oferta) {
        this.titulo = new TextField();
        this.titulo.setValue(oferta.getTitulo().getTitulo());
        this.descripcion = new TextArea();
        this.descripcion.setValue(oferta.getDescripcion().getDescripcion());
        this.cargo = new TextField();
        this.cargo.setValue(oferta.getCargo().getCargo());
        this.sueldo = new TextField();
        this.sueldo.setValue(Float.toString(oferta.getSueldo().getSueldo()));
        this.duracion = new TextField();
        this.duracion.setValue(Integer.toString(oferta.getDuracionEstimadaValor().getValor()));
        this.escala = new Select<>();
        this.escala.setValue(oferta.getDuracionEstimadaEscala().getEscala());
        this.turno = new Select<>();
        this.turno.setValue(oferta.getTurnoTrabajo().getTurno());
        this.vacantes = new TextField();
        this.vacantes.setValue(Integer.toString(oferta.getNumeroVacantes().getVacantes()));
        this.empresas = new Select<>();
        this.empresas.setValue(new ConsultarEmpresasParaCreacionDTO(oferta.getUuidEmpresa(), " "));
        this.requisitosEspeciales = new TextArea();
        this.requisitosEspeciales.setValue(oferta.getRequisitosEspeciales().getRequisitosEspeciales());
        this.habilidades = new HabilidadDTO[2];
        this.habilidades1 = new Select<>();
        this.habilidades1.setValue(new HabilidadDTO(oferta.getHabilidades()[0].getId(),oferta.getHabilidades()[0].getNombre(),oferta.getHabilidades()[0].getCategoria()));
        this.habilidades2 = new Select<>();
        this.habilidades[0] = this.habilidades1.getValue();
        this.habilidades[1] = this.habilidades2.getValue();
        this.habilidades3 = new Select<>();
        this.submitt = new Button();
        this.submitt.addClickListener(e -> verificar());
        /*Agregar un listener a la vista para el evento de creacion*/
        addListener(CreacionOferta.class,this::crearOfertaPersistencia);
    }


    /*Inicialmente se verifica si la oferta laboral cumple con los parametros, en caso afirmativo se genera un evento*/
    private void verificar() {
        if (!habilidades3.isEmpty()){
            habilidades = new HabilidadDTO[3];
            habilidades[0] = habilidades1.getValue();
            habilidades[1] = habilidades2.getValue();
            habilidades[2] = habilidades3.getValue();
        }
        else if (!habilidades2.isEmpty()){
            habilidades = new HabilidadDTO[2];
            habilidades[0] = habilidades1.getValue();
            habilidades[1] = habilidades2.getValue();
        }
        else{
            habilidades = new HabilidadDTO[1];
            habilidades[0] = habilidades1.getValue();
        }
        if(controlador.ofertaValida(controlador.generarOferta(this.titulo.getValue(),this.descripcion.getValue(),this.cargo.getValue(),Float.parseFloat(this.sueldo.getValue()),Integer.parseInt(this.duracion.getValue()),this.escala.getValue(),this.turno.getValue(), Integer.parseInt(this.vacantes.getValue()),this.empresas.getValue().getUUID(),this.requisitosEspeciales.getValue(),habilidades))) {
            ofertaCreada = controlador.generarOferta(this.titulo.getValue(),this.descripcion.getValue(),this.cargo.getValue(),Float.parseFloat(this.sueldo.getValue()),Integer.parseInt(this.duracion.getValue()),this.escala.getValue(),this.turno.getValue(), Integer.parseInt(this.vacantes.getValue()),this.empresas.getValue().getUUID(),this.requisitosEspeciales.getValue(),this.habilidades);
            fireEvent(new CreacionOferta(this,ofertaCreada));
        }
    }

    /*Se atrapa el evento de creacion y se crea la nueva oferta*/
    private void crearOfertaPersistencia(CreacionOferta evento){
        try {
            controlador.crearOferta(evento.getContenido());
            /*Si la creaci??n es exitosa se cambia de vista y se dispara el evento de creaci??n fallida*/
            if (controlador.isExito()) {
                this.submitt.getUI().ifPresent(ui -> ui.navigate(OfertasTrabajo_vista.class));
                fireEvent(new CreacionExitosa(this));
            }
            /*Si la creacion es fallida se distapara el evento de creacion fallida*/
            else {
                fireEvent(new CreacionFallida(this));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    private void configurarBotones(){
        submitt = new Button("Crear");
        submitt.setClassName("btonEnviar");
        submitt.addClickListener(e -> verificar());
        submitt.setEnabled(false);
        cancelar = new Button("Cancelar");

        cancelar.setClassName("cancelar buttonsSpace");
    }

    private void ofertaCreadaExitosamente(CreacionExitosa evento){
        Notification notificacion = new Notification("Oferta creada exitosamente");
        notificacion.setPosition(Notification.Position.TOP_CENTER);
        notificacion.setDuration(3000);
        notificacion.open();
    }

    private void ofertaNoCreada(CreacionFallida evento){
        Dialog modal = new Dialog();
        modal.add(new Div(new Text("Creacion Fallida")), new Button("Cerrar", event -> modal.close()));
        modal.open();
    }

    private boolean listoParaEnviar(){
        if (this.titulo.isEmpty() || this.descripcion.isEmpty() || this.cargo.isEmpty() || this.sueldo.isEmpty() || this.duracion.isEmpty() || this.escala.isEmpty() || this.turno.isEmpty() || this.vacantes.isEmpty() || this.empresas.isEmpty() || this.habilidades1.isEmpty())
            return false;
        return true;
    }

    public TextField getTitulo() {
        return titulo;
    }

    public TextArea getDescripcion() {
        return descripcion;
    }

    public TextField getCargo() {
        return cargo;
    }

    public TextField getSueldo() {
        return sueldo;
    }

    public TextField getDuracion() {
        return duracion;
    }

    public Select<String> getEscala() {
        return escala;
    }

    public Select<String> getTurno() {
        return turno;
    }

    public TextField getVacantes() {
        return vacantes;
    }

    public Select<ConsultarEmpresasParaCreacionDTO> getEmpresas() {
        return empresas;
    }

    public Button getSubmitt() {
        return submitt;
    }

    public Button getCancelar() {
        return cancelar;
    }

    public ServicioCrearOfertaLaboral getControlador() {
        return controlador;
    }

    public OfertaLaboral getOfertaCreada() {
        return ofertaCreada;
    }

    public Select<HabilidadDTO> getHabilidades1() {
        return habilidades1;
    }

    public Select<HabilidadDTO> getHabilidades2() {
        return habilidades2;
    }

    public Select<HabilidadDTO> getHabilidades3() {
        return habilidades3;
    }

    public TextArea getRequisitosEspeciales() {
        return requisitosEspeciales;
    }

    public HabilidadDTO[] getHabilidades() {
        return habilidades;
    }
}
