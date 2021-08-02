package com.proyecto.desarrollo.autenticacion.infraestructura.accesos;

import com.proyecto.desarrollo.autenticacion.infraestructura.vistas.Logout_vista;
import com.proyecto.desarrollo.comunes.infraestructura.layout.MainLayout;
import com.proyecto.desarrollo.empleados.infraestructura.vistas.ListaEmpleados_vista;
import com.proyecto.desarrollo.empresas.infraestructura.vista.Empresas_vista;
import com.proyecto.desarrollo.ofertaLaboral.infraestructura.vistas.crearOferta.CrearOfertaLaboral_vista;
import com.proyecto.desarrollo.ofertaLaboral.infraestructura.vistas.detallesOferta.DetallesOfertaLaboral;
import com.proyecto.desarrollo.ofertaLaboral.infraestructura.vistas.consultarOfertas.OfertasTrabajo_vista;
import com.proyecto.desarrollo.solicitud.infraestructura.vistas.consultaSolicitudes.ConsultarSolicitudes_vista;
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
        this.rutas.add(new Ruta("empleados" , "Empleados" , ListaEmpleados_vista.class));
        this.rutas.add(new Ruta("empresas" , "Empresas" , Empresas_vista.class));
        this.rutas.add(new Ruta("crear-ofertas-laboral" , "Crear Oferta Laboral" , CrearOfertaLaboral_vista.class));
        this.rutas.add(new Ruta("detalle-oferta/:ofertaID?" , "Detalle Oferta Laboral" , DetallesOfertaLaboral.class));
        this.rutas.add(new Ruta("ofertas_trabajo" , "Ofertas de Trabajo" , OfertasTrabajo_vista.class));
        this.rutas.add(new Ruta("solicitudes-laborales" , "Solicitudes Laborales" , ConsultarSolicitudes_vista.class));
    }

    public void generar_rutas_menu(){
        this.rutas.add(new Ruta("empleados" , "Empleados" , ListaEmpleados_vista.class));
        this.rutas.add(new Ruta("ofertas_trabajo" , "Ofertas de Trabajo" , OfertasTrabajo_vista.class));
        this.rutas.add(new Ruta("solicitudes-laborales" , "Solicitudes Laborales" , ConsultarSolicitudes_vista.class));
        this.rutas.add(new Ruta("logout" , "Cerrar Sesión" , Logout_vista.class));

    }

    public ArrayList<Ruta> getRutas() {
        return rutas;
    }

    public void permitirRutas(){
        this.rutas.forEach(ruta ->
                RouteConfiguration.forSessionScope().setRoute(ruta.getRuta() , ruta.getVista() , MainLayout.class));
    }

}
