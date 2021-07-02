package com.proyecto.desarrollo.autenticacion.infraestructura.accesos;

import com.proyecto.desarrollo.comunes.infraestructura.layout.MainLayout;
import com.proyecto.desarrollo.empresas.infraestructura.vista.Empresas_vista;
import com.proyecto.desarrollo.ofertaLaboral.infraestructura.vistas.CrearOfertaLaboral_vista;
import com.proyecto.desarrollo.ofertaLaboral.infraestructura.vistas.DetallesOfertaLaboral;
import com.proyecto.desarrollo.ofertaLaboral.infraestructura.vistas.OfertasTrabajo_vista;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.router.RouteConfiguration;

import java.util.ArrayList;

public class ConfigurarRutas {

    private final ArrayList<Ruta> rutas;

    public ConfigurarRutas() {
        this.rutas = new ArrayList<Ruta>();
    }

    public void habilitar_rutas(){
        this.generar_rutas();
        this.permitirRutas();
    }

    public void generar_rutas(){
        this.rutas.add(new Ruta("empresas" , "Empresas" , Empresas_vista.class));
        this.rutas.add(new Ruta("crear-ofertas-laboral" , "Crear Oferta Laboral" , CrearOfertaLaboral_vista.class));
        this.rutas.add(new Ruta("detalle-oferta" , "Detalle Oferta Laboral" , DetallesOfertaLaboral.class));
        this.rutas.add(new Ruta("ofertas_trabajo" , "Ofertas de Trabajo" , OfertasTrabajo_vista.class));
    }

    public void generar_rutas_menu(){
        this.rutas.add(new Ruta("ofertas_trabajo" , "Ofertas de Trabajo" , OfertasTrabajo_vista.class));
    }

    public ArrayList<Ruta> getRutas() {
        return rutas;
    }

    public void permitirRutas(){
        this.rutas.forEach(ruta ->
                RouteConfiguration.forSessionScope().setRoute(ruta.getRuta() , ruta.getVista() , MainLayout.class));
    }

}
