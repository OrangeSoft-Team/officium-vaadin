package com.proyecto.desarrollo.ofertaLaboral.infraestructura.vistas;

import com.proyecto.desarrollo.comunes.infraestructura.DTOs.HabilidadDTO;
import com.proyecto.desarrollo.empresas.infraestructura.DTO.entrada.ConsultarEmpresasParaCreacionDTO;
import com.proyecto.desarrollo.ofertaLaboral.dominio.OfertaLaboral;
import com.proyecto.desarrollo.ofertaLaboral.infraestructura.vistas.crearOferta.CrearOfertaLaboral_vista;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.fail;


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
        HabilidadDTO[] habilidades = new HabilidadDTO[2];
        habilidades[0] = new HabilidadDTO("1","conserje","limpieza");
        habilidades[1] = new HabilidadDTO("2","administrado","recursos humanos");
        /*Se crea una oferta laboral con la empresa 1*/
        ofertaLaboral = new OfertaLaboral("Se busca Conserje","Se busca un conserje para que labore en la empresa Orangesoft durante el dia","Vendedor",(float)700.16,4,"dia", "diurno",8,empresas.get(0).getUUID(),"edad",habilidades);
    }

    /*mvn -Dtest=CrearOfertaLaboral_vistaTest#crearOferta test*/
    @Test
    public void crearOferta(){
        /*Se poblan los campos de la vista*/
        CrearOfertaLaboral_vista oferta = new CrearOfertaLaboral_vista(ofertaLaboral);
        /*Se revisa si los datos son validos en el campo*/
        Assert.assertEquals("Se busca Conserje",oferta.getTitulo().getValue());
        Assert.assertEquals("Se busca un conserje para que labore en la empresa Orangesoft durante el dia",oferta.getDescripcion().getValue());
        Assert.assertEquals("Vendedor",oferta.getCargo().getValue());
        Assert.assertEquals(4,Integer.parseInt(oferta.getDuracion().getValue()));
        Assert.assertEquals("dia",oferta.getEscala().getValue());
        Assert.assertEquals("diurno",oferta.getTurno().getValue());
        Assert.assertEquals(8,Integer.parseInt(oferta.getVacantes().getValue()));
        Assert.assertEquals("1",oferta.getEmpresas().getValue().getUUID());
        Assert.assertEquals(700.16,Float.parseFloat(oferta.getSueldo().getValue()),0.01f);
        Assert.assertEquals("edad",oferta.getRequisitosEspeciales().getValue());
        for (int i = 0; i < oferta.getHabilidades().length;i++){
            if (i == 0){
                Assert.assertEquals("1",oferta.getHabilidades()[i].getId());
                Assert.assertEquals("conserje",oferta.getHabilidades()[i].getNombre());
                Assert.assertEquals("limpieza",oferta.getHabilidades()[i].getCategoria());
            }
            else {
                Assert.assertEquals("2",oferta.getHabilidades()[i].getId());
                Assert.assertEquals("administrado",oferta.getHabilidades()[i].getNombre());
                Assert.assertEquals("recursos humanos",oferta.getHabilidades()[i].getCategoria());
            }
        }
        System.out.println("Todo correcto");
    }

    /*mvn -Dtest=CrearOfertaLaboral_vistaTest#ofertaLaboralGenerada test*/
    @Test
    public void ofertaLaboralGenerada(){
        /*Se poblan los campos de la vista*/
        CrearOfertaLaboral_vista oferta = new CrearOfertaLaboral_vista(ofertaLaboral);
        /*Se le hace click al boton de crear*/
        oferta.getSubmitt().click();
        /*Verificamos que la oferta laboral si haya sido creada exitosamente*/
        Assert.assertEquals("Se busca Conserje",oferta.getOfertaCreada().getTitulo().getTitulo());
        Assert.assertEquals("Se busca un conserje para que labore en la empresa Orangesoft durante el dia",oferta.getOfertaCreada().getDescripcion().getDescripcion());
        Assert.assertEquals("Vendedor",oferta.getOfertaCreada().getCargo().getCargo());
        Assert.assertEquals(4,oferta.getOfertaCreada().getDuracionEstimadaValor().getValor());
        Assert.assertEquals("dia",oferta.getOfertaCreada().getDuracionEstimadaEscala().getEscala());
        Assert.assertEquals("diurno",oferta.getOfertaCreada().getTurnoTrabajo().getTurno());
        Assert.assertEquals(8,oferta.getOfertaCreada().getNumeroVacantes().getVacantes());
        Assert.assertEquals("1",oferta.getOfertaCreada().getUuidEmpresa());
        Assert.assertEquals(700.16,oferta.getOfertaCreada().getSueldo().getSueldo(),0.01f);
        for (int i = 0; i < oferta.getHabilidades().length;i++){
            if (i == 0){
                Assert.assertEquals("1",oferta.getOfertaCreada().getHabilidades()[i].getId());
                Assert.assertEquals("conserje",oferta.getOfertaCreada().getHabilidades()[i].getNombre());
                Assert.assertEquals("limpieza",oferta.getOfertaCreada().getHabilidades()[i].getCategoria());
            }
            else {
                Assert.assertEquals("2",oferta.getOfertaCreada().getHabilidades()[i].getId());
                Assert.assertEquals("administrado",oferta.getOfertaCreada().getHabilidades()[i].getNombre());
                Assert.assertEquals("recursos humanos",oferta.getOfertaCreada().getHabilidades()[i].getCategoria());
            }
        }
        if (!oferta.getControlador().isExito())
            fail("La creacion en persistencia no fue exitosa");


    }

}
