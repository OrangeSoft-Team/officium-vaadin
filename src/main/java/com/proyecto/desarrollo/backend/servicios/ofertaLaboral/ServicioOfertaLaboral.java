package com.proyecto.desarrollo.backend.servicios.ofertaLaboral;

import com.proyecto.desarrollo.backend.entidades.ofertaLaboral.infraestructura.DTO.entrada.OfertaLaboralGridVaadin;
import com.proyecto.desarrollo.ui.vistas.ofertasTrabajo.CrearOfertaLaboral_vista;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.stereotype.Service;
import org.json.simple.parser.ParseException;

import java.io.*;

@Service
public class ServicioOfertaLaboral {

    private OfertaLaboralGridVaadin[] ofertasLaborales;
    private int cont;

    public OfertaLaboralGridVaadin[] obtenerData() throws FileNotFoundException,
            IOException, ParseException{

        this.cont = 0;
        JSONParser parser = new JSONParser();
        /*Se busca el archivo*/
        try (FileReader reader = new FileReader("src/main/resources/json/prueba.json")){
            Object obj = parser.parse(reader);
            JSONArray ofertas = (JSONArray) obj;
            /*Se inicializa el el array de ofertas laborales*/
            ofertasLaborales = new OfertaLaboralGridVaadin[ofertas.size()];
            /*Se rellena el array de ofertas laborales*/
            ofertas.forEach(ofer -> parsearOfertaLaboral((JSONObject) ofer));

        } catch (Exception e){
            e.printStackTrace();
        }
        return ofertasLaborales;
    }

    private void parsearOfertaLaboral (JSONObject oferta){
            this.ofertasLaborales[this.cont] = new OfertaLaboralGridVaadin(
                    (String) oferta.get("UUID"),
                    (String) oferta.get("Titulo"),
                    (String) oferta.get("FechaPublicacion"),
                    (String) oferta.get("Cargo"),
                    Float.parseFloat((String) oferta.get("Sueldo")),
                    Integer.parseInt((String) oferta.get("DuracionEstimadaValor")) ,
                    (String) oferta.get("DuracionEstimadaEscala"),
                    (String) oferta.get("TurnoTrabajo"),
                    Integer.parseInt((String) oferta.get("NumeroVacantes")),
                    (String) oferta.get("EmpresaNombre")
            );
            this.cont++;
    }


    /** Esto funciona cuando es un solo objeto en el json
     * JSONParser parser = new JSONParser();
     *         try (FileReader reader = new FileReader("src/main/resources/json/prueba.json")){
     *             Object obj = parser.parse(reader);
     *             JSONObject ofertas = (JSONObject) obj;
     *             parsearOfertaLaboral(ofertas);
     */


}
