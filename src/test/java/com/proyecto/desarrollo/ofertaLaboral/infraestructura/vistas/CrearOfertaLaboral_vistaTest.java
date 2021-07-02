package com.proyecto.desarrollo.ofertaLaboral.infraestructura.vistas;

import com.proyecto.desarrollo.empresas.infraestructura.DTO.entrada.ConsultarEmpresasParaCreacionDTO;
import com.proyecto.desarrollo.ofertaLaboral.dominio.OfertaLaboral;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class CrearOfertaLaboral_vistaTest {

    /*Lista que contiene empresas para simular las opciones del form*/
    private List<ConsultarEmpresasParaCreacionDTO> empresas;
    /*Oferta laboral que se creara para testear el guardado*/
    private OfertaLaboral ofertaLaboral;
    /*Empresa 1*/
    private ConsultarEmpresasParaCreacionDTO empresa1;
    /*Empresa 2*/
    private ConsultarEmpresasParaCreacionDTO empresa2;

    /*inicialmente se inicializa la informacion que se usará en el test*/
    @Before
    public void crearDatosPrueba(){
        empresas = new ArrayList<>();
        empresa1 = new ConsultarEmpresasParaCreacionDTO("1","OrangeSoft");
        empresas.add(empresa1);
        empresa2 = new ConsultarEmpresasParaCreacionDTO("2","Racoon Lovers");
        empresas.add(empresa2);
        /*Se crea una oferta laboral con la empresa 1*/
        ofertaLaboral = new OfertaLaboral("Se busca Conserje","Se busca un conserje para que labore en la empresa Orangesoft durante el dia","Vendedor",(float)700.16,4,"dia", "diurno",8,empresas.get(0).getUUID());
    }

    /*mvn -Dtest=CrearOfertaLaboral_vistaTest#crearOferta test*/
    @Test
    public void crearOferta(){
        CrearOfertaLaboral_vista oferta = new CrearOfertaLaboral_vista(ofertaLaboral);
        Assert.assertEquals("Se busca Conserje",oferta.getTitulo().getValue());
        Assert.assertEquals("Se busca un conserje para que labore en la empresa Orangesoft durante el dia",oferta.getDescripcion().getValue());
        Assert.assertEquals("Vendedor",oferta.getCargo().getValue());
        Assert.assertEquals(4,Integer.parseInt(oferta.getDuracion().getValue()));
        Assert.assertEquals("dia",oferta.getEscala().getValue());
        Assert.assertEquals("diurno",oferta.getTurno().getValue());
        Assert.assertEquals(8,Integer.parseInt(oferta.getVacantes().getValue()));
        Assert.assertEquals("1",oferta.getEmpresas().getValue().getUUID());
        Assert.assertEquals(700.16,Float.parseFloat(oferta.getSueldo().getValue()),0.01f);
    }


}