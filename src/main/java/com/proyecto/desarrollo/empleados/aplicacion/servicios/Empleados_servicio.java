package com.proyecto.desarrollo.empleados.aplicacion.servicios;

import com.proyecto.desarrollo.empleados.infraestructura.DTO.entrada.EmpleadoEntradaDTO;

import java.util.ArrayList;
import java.util.List;

public class Empleados_servicio {
    public Empleados_servicio() {
    }

    public ArrayList<EmpleadoEntradaDTO> obtener_lista_empleados(){
        ArrayList<EmpleadoEntradaDTO> lista_empleados = new ArrayList<EmpleadoEntradaDTO>();
        lista_empleados.add(new EmpleadoEntradaDTO("444" , "Juan" , "Roberto" , "correo@correo" , "activo" , "mascuino"));
        lista_empleados.add(new EmpleadoEntradaDTO("222" , "Luis" , "Salazar" , "correo22@correo" , "activo" , "mascuino"));
        return lista_empleados;
    }
}
