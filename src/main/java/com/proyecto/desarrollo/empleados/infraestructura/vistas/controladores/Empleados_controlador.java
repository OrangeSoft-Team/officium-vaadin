package com.proyecto.desarrollo.empleados.infraestructura.vistas.controladores;

import com.proyecto.desarrollo.empleados.aplicacion.servicios.Empleados_servicio;
import com.proyecto.desarrollo.empleados.infraestructura.DTO.entrada.EmpleadoEntradaDTO;
import com.proyecto.desarrollo.ofertaLaboral.infraestructura.DTO.entrada.OfertaLaboralConsultaDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class Empleados_controlador {
    private Empleados_servicio empleados_servicio;

    public Empleados_controlador() {
        this.empleados_servicio = new Empleados_servicio();
    }

    public ArrayList<EmpleadoEntradaDTO> obtener_lista_empleados(){

        ArrayList<EmpleadoEntradaDTO> lista_empleados = this.empleados_servicio.obtener_lista_empleados();
        return lista_empleados;
    }
}
