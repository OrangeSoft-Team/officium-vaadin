package com.proyecto.desarrollo.backend.servicios.ofertaLaboral;

import com.proyecto.desarrollo.backend.entidades.empresas.aplicacion.EmpresasMapper;
import com.proyecto.desarrollo.backend.entidades.empresas.aplicacion.PersistenciaEmpresas;
import com.proyecto.desarrollo.backend.entidades.empresas.infraestructura.DTO.entrada.ConsultarEmpresasParaCreacion;
import com.proyecto.desarrollo.backend.entidades.ofertaLaboral.dominio.OfertaLaboral;
import com.proyecto.desarrollo.backend.infraestructura.persistencia.entrada.empresas.EmpresasArchivoPersistencia;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.html.Div;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Service;

@Service
public class ServicioCrearOfertaLaboral {
    private ConsultarEmpresasParaCreacion[] empresas;
    private int cont;

    public ConsultarEmpresasParaCreacion[] obtenerEmpresas() throws ParseException {
        EmpresasMapper mapper = new EmpresasMapper();
        PersistenciaEmpresas adaptador = new EmpresasArchivoPersistencia();
        String json = adaptador.getEmpresasOfertaLaboral();
        this.empresas = mapper.jsonToEmpresasCreacion(json);
        return this.empresas;
    }

    public OfertaLaboral crearOferta(String titulo, String descripcion, String cargo, float sueldo, int valor, String escala, String turno, int vacantes, String empresa){
        return new OfertaLaboral(titulo,descripcion,cargo,sueldo,valor,escala,turno,vacantes,empresa);
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

        return true;
    }
}
