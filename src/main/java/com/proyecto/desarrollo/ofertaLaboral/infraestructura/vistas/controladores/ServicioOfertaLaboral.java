package com.proyecto.desarrollo.ofertaLaboral.infraestructura.vistas.controladores;

import com.proyecto.desarrollo.ofertaLaboral.aplicacion.OfertaLaboralMapper;
import com.proyecto.desarrollo.comunes.infraestructura.persistencia.PersistenciaOfertaLaboral;
import com.proyecto.desarrollo.ofertaLaboral.infraestructura.DTO.entrada.OfertaLaboralConsultaDTO;
import com.proyecto.desarrollo.ofertaLaboral.infraestructura.persistencia.OfertasLaboralArchivoPersistencia;
import org.springframework.stereotype.Service;
import org.json.simple.parser.ParseException;

import java.io.*;

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



    /** Esto funciona cuando es un solo objeto en el json
     * JSONParser parser = new JSONParser();
     *         try (FileReader reader = new FileReader("src/main/resources/json/ofertasLaborales.json")){
     *             Object obj = parser.parse(reader);
     *             JSONObject ofertas = (JSONObject) obj;
     *             parsearOfertaLaboral(ofertas);
     */


}