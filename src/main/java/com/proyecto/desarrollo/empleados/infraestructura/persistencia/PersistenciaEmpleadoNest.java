package com.proyecto.desarrollo.empleados.infraestructura.persistencia;

import com.proyecto.desarrollo.empleados.aplicacion.persistencia.PersistenciaEmpleado;
import com.proyecto.desarrollo.empleados.infraestructura.DTO.entrada.EmpleadoDetalleEntradaDTO;
import com.proyecto.desarrollo.empleados.infraestructura.DTO.entrada.EmpleadoEntradaDTO;
import com.proyecto.desarrollo.empleados.infraestructura.DTO.salida.EmpleadoDetalleSalidaDTO;

import java.io.IOException;
import java.util.ArrayList;

public class PersistenciaEmpleadoNest implements PersistenciaEmpleado {


    @Override
    public ArrayList<EmpleadoEntradaDTO> obtener_lista_empleados() throws IOException {
        ArrayList<EmpleadoEntradaDTO> lista_empleados = new ArrayList<EmpleadoEntradaDTO>();
        lista_empleados.add(new EmpleadoEntradaDTO("444" , "Juan" , "Roberto" , "correo@correo" , "activo" , "mascuino"));
        lista_empleados.add(new EmpleadoEntradaDTO("222" , "Luis" , "Salazar" , "correo22@correo" , "activo" , "mascuino"));
        return lista_empleados;
    }

    @Override
    public EmpleadoDetalleEntradaDTO obtener_detalle_empleado(EmpleadoDetalleSalidaDTO credenciales) throws IOException {
        return null;
    }



}
