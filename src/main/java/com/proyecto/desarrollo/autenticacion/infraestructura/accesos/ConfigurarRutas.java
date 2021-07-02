package com.proyecto.desarrollo.autenticacion.infraestructura.accesos;

import com.proyecto.desarrollo.comunes.infraestructura.layout.MainLayout;
import com.proyecto.desarrollo.empresas.infraestructura.vista.Empresas_vista;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.router.RouteConfiguration;

import java.util.ArrayList;

public class ConfigurarRutas {

    private ArrayList<Ruta> rutas;

    public ConfigurarRutas() {
//        this.rutas.add(new Ruta("empresas" , "Empresas" , Empresas_vista.class));
        RouteConfiguration.forSessionScope().setRoute("empresas" , Empresas_vista.class, MainLayout.class);
    }

    public ArrayList<Ruta> getRutas() {
        return rutas;
    }

    public void permitirRutas(){
        this.rutas.forEach(ruta ->
                RouteConfiguration.forSessionScope().setRoute(ruta.getRuta() , ruta.getVista() , MainLayout.class));
    }

}
