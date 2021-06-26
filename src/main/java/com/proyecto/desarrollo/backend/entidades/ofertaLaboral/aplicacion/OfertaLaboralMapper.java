package com.proyecto.desarrollo.backend.entidades.ofertaLaboral.aplicacion;

import com.proyecto.desarrollo.backend.entidades.ofertaLaboral.dominio.OfertaLaboral;
import com.proyecto.desarrollo.backend.entidades.ofertaLaboral.infraestructura.ClasesParaVaadin.OfertaLaboralDetalleVaadin;
import com.proyecto.desarrollo.backend.entidades.ofertaLaboral.infraestructura.ClasesParaVaadin.OfertaLaboralGridVaadin;
import com.proyecto.desarrollo.backend.entidades.ofertaLaboral.infraestructura.DTO.entrante.OfertaLaboralConsultaDTO;
import com.proyecto.desarrollo.backend.entidades.ofertaLaboral.infraestructura.DTO.saliente.OfertaLaboralCreacionDTO;
import com.proyecto.desarrollo.backend.entidades.ofertaLaboral.infraestructura.DTO.entrante.OfertaLaboralDetalleDTO;

public class OfertaLaboralMapper {

    /*Metodo utilizado para convertir un DTO en data para el Grid de consulta de Oferta Laboral*/
    public OfertaLaboralGridVaadin dtoToGridVaadin(OfertaLaboralConsultaDTO ofertaDTO){
        OfertaLaboralGridVaadin ofertaDelGrid = new OfertaLaboralGridVaadin(ofertaDTO.getId(), ofertaDTO.getTitulo(), ofertaDTO.getFechaPublicacion(), ofertaDTO.getCargo(),ofertaDTO.getSueldo(),ofertaDTO.getDuracionEstimadaValor(),ofertaDTO.getDuracionEstimadaEscala(),ofertaDTO.getTurnoTrabajo(),ofertaDTO.getNumeroVacantes(),ofertaDTO.getEmpresaNombre());
        return ofertaDelGrid;
    }

    /*Metodo utilizado para convertir una oferta laboral en un DTO para enviar a persistencia*/
    public OfertaLaboralCreacionDTO ofertaLaboralToDTOCreacion(OfertaLaboral ofertaLaboral){
        /*Como oferta laboral utiliza value objetcs, es inevitable el doble get*/
        return new OfertaLaboralCreacionDTO(ofertaLaboral.getTitulo().getTitulo(),ofertaLaboral.getDescripcion().getDescripcion(),ofertaLaboral.getCargo().getCargo(),ofertaLaboral.getSueldo().getSueldo(),ofertaLaboral.getDuracionEstimadaValor().getValor(),ofertaLaboral.getDuracionEstimadaEscala().getEscala(),ofertaLaboral.getTurnoTrabajo().getTurno(),ofertaLaboral.getNumeroVacantes().getVacantes(),ofertaLaboral.getIdEmpresa());
        }

    /*Metodo utilizado para convertir un DTO de detalle de oferta laboral en un detalle para mostrar en vaadin*/
    /*public OfertaLaboralDetalleVaadin dtoDetalleToDetalleVaadin(OfertaLaboralDetalleDTO ofertaDetalleDTO){
        return new OfertaLaboralDetalleVaadin(ofertaDetalleDTO.get);
       }
    */
   }


