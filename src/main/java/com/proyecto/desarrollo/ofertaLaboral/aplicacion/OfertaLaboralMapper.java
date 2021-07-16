package com.proyecto.desarrollo.ofertaLaboral.aplicacion;

import com.proyecto.desarrollo.ofertaLaboral.dominio.OfertaLaboral;
import com.proyecto.desarrollo.ofertaLaboral.infraestructura.DTO.entrada.OfertaLaboralDetalleDTO;
import com.proyecto.desarrollo.ofertaLaboral.infraestructura.DTO.entrada.OfertaLaboralConsultaDTO;
import com.proyecto.desarrollo.ofertaLaboral.infraestructura.DTO.salida.OfertaLaboralCreacion;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


public class OfertaLaboralMapper {

    private OfertaLaboralConsultaDTO[] ofertasLaborales;
    private int cont;

    /*Metodo utilizado para convertir una oferta laboral en un DTO para enviar a persistencia*/
    public OfertaLaboralCreacion ofertaLaboralToDTOCreacion(OfertaLaboral ofertaLaboral){
        /*Como oferta laboral utiliza value objetcs, es inevitable el doble get*/
        return new OfertaLaboralCreacion(ofertaLaboral.getTitulo().getTitulo(),ofertaLaboral.getDescripcion().getDescripcion(),ofertaLaboral.getCargo().getCargo(),ofertaLaboral.getSueldo().getSueldo(),ofertaLaboral.getDuracionEstimadaValor().getValor(),ofertaLaboral.getDuracionEstimadaEscala().getEscala(),ofertaLaboral.getTurnoTrabajo().getTurno(),ofertaLaboral.getNumeroVacantes().getVacantes(),ofertaLaboral.getIdEmpresa());
        }

    /*Metodo utilizado para Parsear un Json y obtener un array de ofertasLaboralesGridVaadin*/
    public OfertaLaboralConsultaDTO[] jsonToGrid(String contenido) throws ParseException {
        cont = 0;
        JSONParser parser = new JSONParser();
        Object obj = parser.parse(contenido);
        JSONArray ofertas = (JSONArray) obj;
        ofertasLaborales = new OfertaLaboralConsultaDTO[ofertas.size()];
        ofertas.forEach(ofer -> parsearOfertaLaboral((JSONObject) ofer));
        return this.ofertasLaborales;
    }

    private void parsearOfertaLaboral (JSONObject oferta){
        this.ofertasLaborales[this.cont] = new OfertaLaboralConsultaDTO(
                (String) oferta.get("UUID"),
                (String) oferta.get("Titulo"),
                (String) oferta.get("FechaPublicacion"),
                (String) oferta.get("Cargo"),
                Float.parseFloat((String) oferta.get("Sueldo")),
                Integer.parseInt((String) oferta.get("DuracionEstimadaValor")) ,
                (String) oferta.get("DuracionEstimadaEscala"),
                (String) oferta.get("TurnoTrabajo"),
                Integer.parseInt((String) oferta.get("NumeroVacantes")),
                (String) oferta.get("EmpresaNombre"),
                (String) oferta.get("Estado")
        );
        this.cont++;
    }

    /*Metodo utilizado para convertir un DTO de detalle de oferta laboral en un detalle para mostrar en vaadin*/
    public OfertaLaboralDetalleDTO jsonToDetalle(String contenido) throws ParseException {
        JSONParser parser = new JSONParser();
        Object obj = parser.parse(contenido);
        JSONObject detalle = (JSONObject) obj;
        return convertirDetalle(detalle);
       }

    public OfertaLaboralDetalleDTO convertirDetalle(JSONObject detalle){
        return new OfertaLaboralDetalleDTO(
                (String) detalle.get("UUID"),
                (String) detalle.get("Titulo"),
                (String) detalle.get("FechaPublicacion"),
                (String) detalle.get("FechaModificacion"),
                (String) detalle.get("Cargo"),
                (float) Float.parseFloat((String)detalle.get("Sueldo")),
                (int) Integer.parseInt((String) detalle.get("DuracionEstimadaValor")),
                (String) detalle.get("DuracionEstimadaEscala"),
                (String) detalle.get("Descripcion"),
                (String) detalle.get("TurnoTrabajo"),
                (int) Integer.parseInt((String) detalle.get("NumeroVacantes")),
                (String) detalle.get("UUIDEmpresa"),
                (String) detalle.get("EmpresaNombre"),
                (String) detalle.get("DireccionEmpresa")
        );
    }
   }


