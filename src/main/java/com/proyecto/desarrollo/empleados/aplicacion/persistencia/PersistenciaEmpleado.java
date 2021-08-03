package com.proyecto.desarrollo.empleados.aplicacion.persistencia;

import com.proyecto.desarrollo.empleados.infraestructura.DTO.entrada.EmpleadoDetalleEntradaDTO;
import com.proyecto.desarrollo.empleados.infraestructura.DTO.salida.EmpleadoDetalleSalidaDTO;
import com.proyecto.desarrollo.empleados.infraestructura.DTO.entrada.EmpleadoEntradaDTO;

import java.io.IOException;
import java.util.ArrayList;

public interface PersistenciaEmpleado {

    public ArrayList<EmpleadoEntradaDTO> obtener_lista_empleados() throws IOException;
    public EmpleadoDetalleEntradaDTO obtener_detalle_empleado(EmpleadoDetalleSalidaDTO credenciales) throws IOException;

}
