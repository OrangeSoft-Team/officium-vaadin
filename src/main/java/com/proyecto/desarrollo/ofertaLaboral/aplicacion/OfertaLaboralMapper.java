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
        return new OfertaLaboralCreacion(ofertaLaboral.getTitulo().getTitulo(),ofertaLaboral.getDescripcion().getDescripcion(),ofertaLaboral.getCargo().getCargo(),ofertaLaboral.getSueldo().getSueldo(),ofertaLaboral.getDuracionEstimadaValor().getValor(),ofertaLaboral.getDuracionEstimadaEscala().getEscala(),ofertaLaboral.getTurnoTrabajo().getTurno(),ofertaLaboral.getNumeroVacantes().getVacantes(),ofertaLaboral.getIdEmpresa(),ofertaLaboral.getRequisitosEspeciales().getRequisitosEspeciales(), ofertaLaboral.getHabilidades());
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
                (String) oferta.get("uuid"),
                (String) oferta.get("titulo"),
                (String) oferta.get("fechaPublicacion"),
                (String) oferta.get("cargo"),
                Float.parseFloat((String) oferta.get("sueldo")),
                Integer.parseInt((String) oferta.get("duracionEstimadaValor")) ,
                (String) oferta.get("duracionEstimadaEscala"),
                (String) oferta.get("turnoTrabajo"),
                Integer.parseInt((String) oferta.get("numeroVacantes")),
                (String) oferta.get("empresaNombre")
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
                (String) detalle.get("uuid"),
                (String) detalle.get("titulo"),
                (String) detalle.get("fechaPublicacion"),
                (String) detalle.get("fechaModificacion"),
                (String) detalle.get("cargo"),
                (float) Float.parseFloat((String)detalle.get("sueldo")),
                (int) Integer.parseInt((String) detalle.get("duracionEstimadaValor")),
                (String) detalle.get("duracionEstimadaEscala"),
                (String) detalle.get("descripcion"),
                (String) detalle.get("turnoTrabajo"),
                (int) Integer.parseInt((String) detalle.get("numeroVacantes")),
                (String) detalle.get("uuidEmpresa"),
                (String) detalle.get("empresaNombre"),
                (String) detalle.get("direccionEmpresa")
        );
    }
   }


