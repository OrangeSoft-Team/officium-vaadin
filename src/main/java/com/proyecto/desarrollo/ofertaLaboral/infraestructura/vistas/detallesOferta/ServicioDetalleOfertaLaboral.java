package com.proyecto.desarrollo.ofertaLaboral.infraestructura.vistas.detallesOferta;

import com.proyecto.desarrollo.comunes.aplicacion.HabilidadesMapper;
import com.proyecto.desarrollo.comunes.infraestructura.DTOs.HabilidadDTO;
import com.proyecto.desarrollo.comunes.infraestructura.persistencia.PersistenciaHabilidades;
import com.proyecto.desarrollo.comunes.infraestructura.persistencia.PersistenciaOfertaLaboral;
import com.proyecto.desarrollo.comunes.infraestructura.persistencia.entrada.HabilidadesAdaptadorSpring;
import com.proyecto.desarrollo.comunes.infraestructura.persistencia.entrada.HabilidadesArchivoPersistencia;
import com.proyecto.desarrollo.ofertaLaboral.aplicacion.OfertaLaboralMapper;
import com.proyecto.desarrollo.ofertaLaboral.dominio.OfertaLaboral;
import com.proyecto.desarrollo.ofertaLaboral.infraestructura.DTO.entrada.OfertaLaboralDetalleDTO;
import com.proyecto.desarrollo.ofertaLaboral.infraestructura.DTO.salida.OfertaLaboralModificacion;
import com.proyecto.desarrollo.ofertaLaboral.infraestructura.persistencia.OfertasLaboralArchivoPersistencia;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.html.Div;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.net.MalformedURLException;

public class ServicioDetalleOfertaLaboral {

    private OfertaLaboralDetalleDTO oferta;
    private HabilidadDTO[] habilidades;
    PersistenciaOfertaLaboral adaptador;

    public ServicioDetalleOfertaLaboral(){
        adaptador = new OfertasLaboralArchivoPersistencia();
    }

    public OfertaLaboralDetalleDTO obtenerOferta(String uuid) throws ParseException, IOException {
        OfertaLaboralMapper mapper = new OfertaLaboralMapper();
        this.oferta = mapper.jsonToDetalle(adaptador.obtenerDetalles(uuid));
        return this.oferta;
    }

    public HabilidadDTO[] obtenerHabilidades() throws ParseException{
        PersistenciaHabilidades adaptadorHabilidades = new HabilidadesAdaptadorSpring();
        try {
            String json = adaptadorHabilidades.getHabilidadesOfertasLaborales();
            HabilidadesMapper mapperHabilidades = new HabilidadesMapper();
            this.habilidades = mapperHabilidades.jsonToHabilidadesDTO(json);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return this.habilidades;
    }

    public int getHabilidad(HabilidadDTO[] habilidades, String uuid) {
        for (int i = 0 ; i < habilidades.length; i++){
            if (habilidades[i].getUuid().equals(uuid))
                return i;
        }
        return 0;
    }

    public boolean verificar(OfertaLaboral modificacion, String uuid) throws IOException, ParseException {
        Dialog modal = new Dialog();
        if (modificacion.getTitulo().getTitulo().equals("invalido")){
            modal.add(new Div(new Text("El titulo debe contener de 4 a 80 caracteres")), new Button("Cerrar", event -> modal.close()));
            modal.open();
            return false;
        }



        else if (modificacion.getCargo().getCargo().equals("invalido")){
            modal.add(new Div(new Text("El cargo debe contener de 4 a 40 caracteres")), new Button("Cerrar", event -> modal.close()));
            modal.open();
            return false;
        }

        else if (modificacion.getDuracionEstimadaEscala().getEscala().equals("invalido")){
            modal.add(new Div(new Text("La duracion debe ser horas, dias, semanas, meses o años")), new Button("Cerrar", event -> modal.close()));
            modal.open();
            return false;
        }

        else if(modificacion.getSueldo().getSueldo() == -1 ){
            modal.add(new Div(new Text("El sueldo debe ser mayor a 0 pero menor a 1.000.000")), new Button("Cerrar", event -> modal.close()));
            modal.open();
            return false;
        }

        else if (modificacion.getTurnoTrabajo().getTurno().equals("invalido")){
            modal.add(new Div(new Text("Los turnos pueden ser diurno, nocturno o mixto")), new Button("Cerrar", event -> modal.close()));
            modal.open();
            return false;
        }

        else if (modificacion.getDuracionEstimadaValor().getValor() == -1){
            modal.add(new Div(new Text("La duracion puede ser desde 0 a 99 (horas, dias, meses, años)")), new Button("Cerrar", event -> modal.close()));
            modal.open();
            return false;
        }

        else if (modificacion.getNumeroVacantes().getVacantes() == -1) {
            modal.add(new Div(new Text("Los puestos disponibles pueden ser desde 0 a 99")), new Button("Cerrar", event -> modal.close()));
            modal.open();
            return false;
        }

        else if (modificacion.getHabilidades()[0].getId() == "invalido" || modificacion.getHabilidades()[0].getNombre() == "invalido" || modificacion.getHabilidades()[0].getCategoria() == "invalido") {
            modal.add(new Div(new Text("La habilidad no es valida")), new Button("Cerrar", event -> modal.close()));
            modal.open();
            return false;
        }

        else if (modificacion.getDescripcion().getDescripcion().equals("invalido")){
            modal.add(new Div(new Text("La descripcion debe contener de 32 a 512 caracteres")), new Button("Cerrar", event -> modal.close()));
            modal.open();
            return false;
        }

        else if (modificacion.getRequisitosEspeciales().getRequisitosEspeciales() == "invalido") {
            modal.add(new Div(new Text("El requerimiento especial no es valido")), new Button("Cerrar", event -> modal.close()));
            modal.open();
            return false;
        }

        HabilidadDTO[] habilidades = new HabilidadDTO[modificacion.getHabilidades().length];
        for (int i = 0; i < modificacion.getHabilidades().length ; i++) {
            habilidades[i] = new HabilidadDTO(modificacion.getHabilidades()[i].getId(), modificacion.getHabilidades()[i].getNombre(), modificacion.getHabilidades()[i].getCategoria());
        }

        OfertaLaboralModificacion ofertaModificada = new OfertaLaboralModificacion(
                modificacion.getTitulo().getTitulo(),
                modificacion.getDescripcion().getDescripcion(),
                modificacion.getCargo().getCargo(),
                modificacion.getSueldo().getSueldo(),
                modificacion.getDuracionEstimadaValor().getValor(),
                modificacion.getDuracionEstimadaEscala().getEscala(),
                modificacion.getTurnoTrabajo().getTurno(),
                modificacion.getNumeroVacantes().getVacantes(),
                modificacion.getRequisitosEspeciales().getRequisitosEspeciales(),
                habilidades
        );
        if (adaptador.modificarOferta(uuid,ofertaModificada)){
            return true;
        }
        return false;
    }
}
