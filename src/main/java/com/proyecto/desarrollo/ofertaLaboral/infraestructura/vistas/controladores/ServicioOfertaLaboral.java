package com.proyecto.desarrollo.backend.servicios.ofertaLaboral;

import com.proyecto.desarrollo.backend.entidades.ofertaLaboral.aplicacion.OfertaLaboralMapper;
import com.proyecto.desarrollo.backend.entidades.ofertaLaboral.aplicacion.PersistenciaOfertaLaboral;
import com.proyecto.desarrollo.backend.entidades.ofertaLaboral.infraestructura.DTO.entrada.OfertaLaboralGridVaadin;
import com.proyecto.desarrollo.backend.infraestructura.persistencia.entrada.ofertaLaboral.OfertasLaboralArchivoPersistencia;
import org.springframework.stereotype.Service;
import org.json.simple.parser.ParseException;

import java.io.*;

@Service
public class ServicioOfertaLaboral {

    private OfertaLaboralGridVaadin[] ofertasLaborales;
    private int cont;
    private OfertaLaboralMapper mapper = new OfertaLaboralMapper();
    private PersistenciaOfertaLaboral adaptador;

    public OfertaLaboralGridVaadin[] obtenerData() throws IOException, ParseException {
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