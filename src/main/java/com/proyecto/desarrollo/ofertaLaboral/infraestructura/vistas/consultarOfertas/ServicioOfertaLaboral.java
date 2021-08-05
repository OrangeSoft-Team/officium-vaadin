package com.proyecto.desarrollo.ofertaLaboral.infraestructura.vistas.consultarOfertas;

import com.proyecto.desarrollo.ofertaLaboral.aplicacion.FiltrosOfertaLaboral;
import com.proyecto.desarrollo.ofertaLaboral.aplicacion.OfertaLaboralMapper;
import com.proyecto.desarrollo.comunes.infraestructura.persistencia.PersistenciaOfertaLaboral;
import com.proyecto.desarrollo.ofertaLaboral.dominio.OfertaLaboral;
import com.proyecto.desarrollo.ofertaLaboral.infraestructura.DTO.entrada.OfertaLaboralConsultaDTO;
import com.proyecto.desarrollo.ofertaLaboral.infraestructura.DTO.entrada.OfertaLaboralDetalleDTO;
import com.proyecto.desarrollo.ofertaLaboral.infraestructura.persistencia.OfertaLaboralAdaptadorSpring;
import com.proyecto.desarrollo.ofertaLaboral.infraestructura.persistencia.OfertasLaboralArchivoPersistencia;
import org.springframework.stereotype.Service;
import org.json.simple.parser.ParseException;

import java.io.*;
import java.time.LocalDate;
import java.util.Locale;

@Service
public class ServicioOfertaLaboral {

    private OfertaLaboralConsultaDTO[] ofertasLaborales;
    private int cont;
    private OfertaLaboralMapper mapper ;
    private PersistenciaOfertaLaboral adaptador;

    public ServicioOfertaLaboral(){
        /*Se crear una instancia del adaptador*/
        adaptador = new OfertaLaboralAdaptadorSpring();
        this.mapper = new OfertaLaboralMapper();
    }

    public OfertaLaboralConsultaDTO[] obtenerData() throws IOException, ParseException {
        /*Se obtiene un json del adaptador*/
        String stringDeOfertas = adaptador.obtenerOfertasLaborales();
        /*Se pasa el Json al mapper para crear las intancias de ofertasLaborales*/
        this.ofertasLaborales = mapper.jsonToGrid(stringDeOfertas);
        if(this.ofertasLaborales.length == 0)
            return null;
        return ofertasLaborales;
    }

    public OfertaLaboralConsultaDTO[] filtrar(String estado){
        FiltrosOfertaLaboral filtrados = new FiltrosOfertaLaboral();
        return filtrados.filtarPorEstado(estado,this.ofertasLaborales);
    }

    public OfertaLaboralConsultaDTO[] getOfertasLaborales() {
        return ofertasLaborales;
    }

    public OfertaLaboralConsultaDTO[] filtrarEmpresa(String nombreEmpresa) {
        if (nombreEmpresa.equals("")){
            return this.ofertasLaborales;
        }
        OfertaLaboralConsultaDTO[] filtradas = new OfertaLaboralConsultaDTO[contarOfertasConNombre(nombreEmpresa)];
        int indice = 0;
        for (int i = 0; i < this.ofertasLaborales.length; i++) {
            if (this.ofertasLaborales[i].getNombreEmpresa().toLowerCase(Locale.ROOT).contains(nombreEmpresa.toLowerCase(Locale.ROOT))) {
                filtradas[indice] = this.ofertasLaborales[i];
                indice++;
            }
        }
        return filtradas;
    }

    public int contarOfertasConNombre(String nombreEmpresa){
        int contador = 0;
        for (int i = 0 ; i < this.ofertasLaborales.length ; i++){
            if(this.ofertasLaborales[i].getNombreEmpresa().toLowerCase(Locale.ROOT).contains(nombreEmpresa.toLowerCase(Locale.ROOT))){
                contador++;
            }
        }
        return contador;
    }

    public OfertaLaboralConsultaDTO[] filtrarFechaPubli(String format) {
        OfertaLaboralConsultaDTO[] filtradas = new OfertaLaboralConsultaDTO[contrarOfertasConFecha(format)];
        System.out.println();
        int indice = 0;
        for (int i = 0; i < this.ofertasLaborales.length;i++){
            System.out.println(this.ofertasLaborales[i].getFechaPublicacion());
            if (this.ofertasLaborales[i].getFechaPublicacion().equals(format)){
                filtradas[indice] = this.ofertasLaborales[i];
                indice++;
            }
        }
        return filtradas;
    }

    public int contrarOfertasConFecha(String value){
        int contador = 0;
        for (int i = 0; i < this.ofertasLaborales.length;i++){
            if (this.ofertasLaborales[i].getFechaPublicacion().equals(value)){
                contador++;
            }
        }
        return contador;
    }

    public Boolean cancelarOferta(String uuid)  {
        try {
            if (adaptador.cancelarOferta(uuid)) {
                return true;
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return false;
    }

    public Boolean duplicarOferta(String uuid) throws ParseException, IOException {
        this.adaptador = new OfertasLaboralArchivoPersistencia();
        OfertaLaboralDetalleDTO detalle = mapper.jsonToDetalle(adaptador.obtenerDetalles(uuid));
        OfertaLaboral duplicado = new OfertaLaboral(detalle.getTitulo(),detalle.getDescripcion(),detalle.getCargo(),detalle.getSueldo(),detalle.getDuracionValor(), detalle.getDuracionEscala(), detalle.getTurnoTrabajo(),detalle.getNumeroVacantes(), detalle.getIdEmpresa(), detalle.getRequerimientoEspecial(),detalle.getHabilidades());
        if (adaptador.crearOferta(this.mapper.ofertaLaboralToDTOCreacion(duplicado))){
            return true;
        }
        return false;
    }
}