package com.proyecto.desarrollo.ofertaLaboral.infraestructura.vistas.crearOferta;

import com.proyecto.desarrollo.comunes.aplicacion.HabilidadesMapper;
import com.proyecto.desarrollo.comunes.infraestructura.DTOs.HabilidadDTO;
import com.proyecto.desarrollo.comunes.infraestructura.persistencia.PersistenciaHabilidades;
import com.proyecto.desarrollo.comunes.infraestructura.persistencia.PersistenciaOfertaLaboral;
import com.proyecto.desarrollo.comunes.infraestructura.persistencia.entrada.HabilidadesArchivoPersistencia;
import com.proyecto.desarrollo.empresas.aplicacion.EmpresasMapper;
import com.proyecto.desarrollo.comunes.infraestructura.persistencia.PersistenciaEmpresas;
import com.proyecto.desarrollo.empresas.infraestructura.DTO.entrada.ConsultarEmpresasParaCreacionDTO;
import com.proyecto.desarrollo.ofertaLaboral.aplicacion.OfertaLaboralMapper;
import com.proyecto.desarrollo.ofertaLaboral.dominio.OfertaLaboral;
import com.proyecto.desarrollo.empresas.infraestructura.Persistencia.EmpresasArchivoPersistencia;
import com.proyecto.desarrollo.ofertaLaboral.infraestructura.persistencia.OfertasLaboralArchivoPersistencia;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.html.Div;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Service;

@Service
public class ServicioCrearOfertaLaboral {

    /*Empresas en el sistema*/
    private ConsultarEmpresasParaCreacionDTO[] empresas;
    /*Mapper para empresas*/
    private EmpresasMapper mapper;
    /*Mapper para ofertas laborales*/
    private OfertaLaboralMapper mapperOferta;
    /*Adaptador para Empresas*/
    private PersistenciaEmpresas adaptador;
    /*Adaptador para creacion oferta*/
    private PersistenciaOfertaLaboral ofertaAdapter;
    /*Helper*/
    private int cont;
    /*Creacion exitosa*/
    private boolean exito = false;

    private HabilidadDTO[] habilidades;

    public ServicioCrearOfertaLaboral() {
        this.mapper = new EmpresasMapper();
        this.mapperOferta = new OfertaLaboralMapper();
        this.adaptador = new EmpresasArchivoPersistencia();
        this.ofertaAdapter = new OfertasLaboralArchivoPersistencia();
    }

    public ConsultarEmpresasParaCreacionDTO[] obtenerEmpresas() throws ParseException {
        String json = adaptador.getEmpresasOfertaLaboral();
        this.empresas = this.mapper.jsonToEmpresasCreacion(json);
        return this.empresas;
    }

    public HabilidadDTO[] obtenerHabilidades() throws ParseException{
        PersistenciaHabilidades adaptadorHabilidades = new HabilidadesArchivoPersistencia();
        String json = adaptadorHabilidades.getHabilidadesOfertasLaborales();
        HabilidadesMapper mapperHabilidades = new HabilidadesMapper();
        this.habilidades = mapperHabilidades.jsonToHabilidadesDTO(json);
        return this.habilidades;
    }

    public OfertaLaboral generarOferta(String titulo, String descripcion, String cargo, float sueldo, int valor, String escala, String turno, int vacantes, String empresa,String requerimientoEspecial,HabilidadDTO[] habilidades){
        return new OfertaLaboral(titulo,descripcion,cargo,sueldo,valor,escala,turno,vacantes,empresa,requerimientoEspecial,habilidades);
    }


    /*Segunda capa de validacion para saber si todo cumple con las reglas, en caso negativo, mostrara un modal diciendo que falla*/
    public boolean ofertaValida(OfertaLaboral ofertaCreada) {
        Dialog modal = new Dialog();
        if (ofertaCreada.getTitulo().getTitulo() == "invalido"){

            modal.add(new Div(new Text("El titulo debe contener de 4 a 80 caracteres")), new Button("Cerrar", event -> modal.close()));
            modal.open();
            return false;
        }

        else if (ofertaCreada.getDescripcion().getDescripcion() == "invalido"){
            modal.add(new Div(new Text("La descripcion debe contener de 32 a 512 caracteres")), new Button("Cerrar", event -> modal.close()));
            modal.open();
        return false;
        }

        else if (ofertaCreada.getCargo().getCargo() == "invalido"){
            modal.add(new Div(new Text("El cargo debe contener de 4 a 40 caracteres")), new Button("Cerrar", event -> modal.close()));
            modal.open();
            return false;
        }

        else if (ofertaCreada.getDuracionEstimadaEscala().getEscala() == "invalido"){
            modal.add(new Div(new Text("La duracion debe ser horas, dias, semanas o meses")), new Button("Cerrar", event -> modal.close()));
            modal.open();
        return false;
        }

        else if (ofertaCreada.getTurnoTrabajo().getTurno() == "invalido"){
            modal.add(new Div(new Text("Los turnos pueden ser diurno, nocturno o mixto")), new Button("Cerrar", event -> modal.close()));
            modal.open();
            return false;
        }

        else if(ofertaCreada.getSueldo().getSueldo() == -1){
            modal.add(new Div(new Text("El sueldo debe ser mayor a 0 pero menor a 1.000.000")), new Button("Cerrar", event -> modal.close()));
            modal.open();
        return false;
    }

        else if (ofertaCreada.getDuracionEstimadaValor().getValor() == -1){
            modal.add(new Div(new Text("La duracion puede ser desde 0 a 99 (horas, dias, meses, años)")), new Button("Cerrar", event -> modal.close()));
            modal.open();
            return false;
        }

        else if (ofertaCreada.getNumeroVacantes().getVacantes() == -1) {
            modal.add(new Div(new Text("Los puestos disponibles pueden ser desde 0 a 99")), new Button("Cerrar", event -> modal.close()));
            modal.open();
            return false;
        }

        else if (ofertaCreada.getHabilidades()[0].getId() == "invalido" || ofertaCreada.getHabilidades()[0].getNombre() == "invalido" || ofertaCreada.getHabilidades()[0].getCategoria() == "invalido") {
            modal.add(new Div(new Text("La habilidad no es valida")), new Button("Cerrar", event -> modal.close()));
            modal.open();
            return false;
        }

        return true;
    }

    public void crearOferta(OfertaLaboral ofertaCreada) {
        if(ofertaAdapter.crearOferta(this.mapperOferta.ofertaLaboralToDTOCreacion(ofertaCreada))){
            exito = true;
        }
    }

    public boolean isExito() {
        return exito;
    }
}
