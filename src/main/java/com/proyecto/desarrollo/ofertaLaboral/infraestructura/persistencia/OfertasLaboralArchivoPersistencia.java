package com.proyecto.desarrollo.ofertaLaboral.infraestructura.persistencia;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.proyecto.desarrollo.comunes.infraestructura.persistencia.PersistenciaOfertaLaboral;
import com.proyecto.desarrollo.ofertaLaboral.aplicacion.OfertaLaboralMapper;
import com.proyecto.desarrollo.ofertaLaboral.infraestructura.DTO.entrada.OfertaLaboralConsultaDTO;
import com.proyecto.desarrollo.ofertaLaboral.infraestructura.DTO.salida.OfertaLaboralCreacion;
import com.proyecto.desarrollo.ofertaLaboral.infraestructura.DTO.salida.OfertaLaboralModificacion;
import org.json.simple.parser.ParseException;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class OfertasLaboralArchivoPersistencia implements PersistenciaOfertaLaboral {

    @Override
    public String obtenerOfertasLaborales() throws IOException {
        String contenido;
        contenido = "";
        try{
           contenido = Files.readString(Paths.get("src/main/resources/json/ofertasLaborales.json"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return contenido;
    }

    @Override
    public String obtenerDetalles(String uuid) {
        String contenido;
        contenido = "";
        try{
            contenido = Files.readString(Paths.get("src/main/resources/json/detallesOferta.json"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return contenido;
    }

    @Override
    public Boolean crearOferta(OfertaLaboralCreacion oferta) {
        ObjectMapper mapper = new ObjectMapper();
        try{
            FileWriter writer = new FileWriter("src/main/resources/json/creacion.json");
            String json = mapper.writeValueAsString(oferta);
            writer.write(json);
            writer.close();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Boolean cancelarOferta(String uuid) throws IOException, ParseException {
        OfertaLaboralMapper mapperOferta = new OfertaLaboralMapper();
        OfertaLaboralConsultaDTO[] ofertas = mapperOferta.jsonToGrid(obtenerOfertasLaborales());
        for (int i = 0; i < ofertas.length; i++){
            if (ofertas[i].getUuid().equals(uuid)){
                ofertas[i].setEstatus("inactivo");
                break;
            }
        }
        try{
            ObjectMapper mapper = new ObjectMapper();
            FileWriter writer = new FileWriter("src/main/resources/json/ofertasLaborales.json");
            String json = mapper.writeValueAsString(ofertas);
            writer.write(json);
            writer.close();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean modificarOferta(String uuid, OfertaLaboralModificacion oferta) {
        ObjectMapper mapper = new ObjectMapper();
        try{
            FileWriter writer = new FileWriter("src/main/resources/json/modificacionOfertaLaboral.json");
            String json = mapper.writeValueAsString(oferta);
            writer.write(json);
            writer.close();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }
}
