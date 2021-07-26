package com.proyecto.desarrollo.ofertaLaboral.aplicacion;

import com.proyecto.desarrollo.ofertaLaboral.infraestructura.DTO.entrada.OfertaLaboralConsultaDTO;

public class FiltrosOfertaLaboral {

    /*Se filtran por las ofertas que cumplen*/
    public OfertaLaboralConsultaDTO[] filtarPorEstado(String estado, OfertaLaboralConsultaDTO[] ofertas){
        OfertaLaboralConsultaDTO[] filtrado = new OfertaLaboralConsultaDTO[contarFiltrados(ofertas,estado)];
        filtrado = obtenerFiltrados(ofertas,estado,filtrado);
        return filtrado;
    }

    /*Se cuenta la cantidad de ofertas que cumplen con la condicion del estado para asi crear un array con esa cantidad*/
    public int contarFiltrados(OfertaLaboralConsultaDTO[] ofertas, String estado){
        int cont = 0;
        for (int i = 0;i <ofertas.length;i++){
            if (ofertas[i].getEstatus().equals(estado)) cont++;
        }
        System.out.println(cont);
        return cont;
    }

    /*Se obtienen las ofertas que cumplen con el filtro de estado*/
    public OfertaLaboralConsultaDTO[] obtenerFiltrados(OfertaLaboralConsultaDTO[] ofertas, String estado,OfertaLaboralConsultaDTO[] filtrados){
        int cont = 0;
        for (int i = 0;i <ofertas.length;i++){
            if (ofertas[i].getEstatus().equals(estado)) {
                filtrados[cont] = ofertas[i];
                System.out.println(ofertas[i].getEstatus());
                cont++;
                }
            }
        return filtrados;
        }

    }

