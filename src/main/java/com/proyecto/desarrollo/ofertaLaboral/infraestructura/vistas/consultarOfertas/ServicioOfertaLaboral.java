package com.proyecto.desarrollo.ofertaLaboral.infraestructura.vistas.consultarOfertas;

import com.proyecto.desarrollo.ofertaLaboral.aplicacion.FiltrosOfertaLaboral;
import com.proyecto.desarrollo.ofertaLaboral.aplicacion.OfertaLaboralMapper;
import com.proyecto.desarrollo.comunes.infraestructura.persistencia.PersistenciaOfertaLaboral;
import com.proyecto.desarrollo.ofertaLaboral.infraestructura.DTO.entrada.OfertaLaboralConsultaDTO;
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
    private OfertaLaboralMapper mapper = new OfertaLaboralMapper();
    private PersistenciaOfertaLaboral adaptador;

    public OfertaLaboralConsultaDTO[] obtenerData() throws IOException, ParseException {
        /*Se crear una instancia del adaptador*/
        adaptador = new OfertasLaboralArchivoPersistencia();
        /*Se obtiene un json del adaptador*/
        String stringDeOfertas = adaptador.obtenerOfertasLaborales();
        /*Se pasa el Json al mapper para crear las intancias de ofertasLaborales*/
        this.ofertasLaborales = mapper.jsonToGrid(stringDeOfertas);
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
}