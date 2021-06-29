package com.proyecto.desarrollo.backend.entidades.ofertaLaboral.aplicacion;

import com.proyecto.desarrollo.backend.entidades.ofertaLaboral.dominio.OfertaLaboral;
import com.proyecto.desarrollo.backend.entidades.ofertaLaboral.infraestructura.DTO.salida.OfertaLaboralCreacion;


public class OfertaLaboralMapper {

    /*Metodo utilizado para convertir una oferta laboral en un DTO para enviar a persistencia*/
    public OfertaLaboralCreacion ofertaLaboralToDTOCreacion(OfertaLaboral ofertaLaboral){
        /*Como oferta laboral utiliza value objetcs, es inevitable el doble get*/
        return new OfertaLaboralCreacion(ofertaLaboral.getTitulo().getTitulo(),ofertaLaboral.getDescripcion().getDescripcion(),ofertaLaboral.getCargo().getCargo(),ofertaLaboral.getSueldo().getSueldo(),ofertaLaboral.getDuracionEstimadaValor().getValor(),ofertaLaboral.getDuracionEstimadaEscala().getEscala(),ofertaLaboral.getTurnoTrabajo().getTurno(),ofertaLaboral.getNumeroVacantes().getVacantes(),ofertaLaboral.getIdEmpresa());
        }

    /*Metodo utilizado para convertir un DTO de detalle de oferta laboral en un detalle para mostrar en vaadin*/
    /*public OfertaLaboralDetalleVaadin dtoDetalleToDetalleVaadin(OfertaLaboralDetalleDTO ofertaDetalleDTO){
        return new OfertaLaboralDetalleVaadin(ofertaDetalleDTO.get);
       }
    */
   }


