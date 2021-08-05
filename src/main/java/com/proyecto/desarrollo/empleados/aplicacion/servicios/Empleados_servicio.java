package com.proyecto.desarrollo.empleados.aplicacion.servicios;

import com.proyecto.desarrollo.autenticacion.dominio.excepciones.AutenticacionInvalidaExcepcion;
import com.proyecto.desarrollo.comunes.dominio.excepciones.ErrorGeneralExcepcion;
import com.proyecto.desarrollo.empleados.aplicacion.persistencia.PersistenciaEmpleado;
import com.proyecto.desarrollo.empleados.infraestructura.DTO.entrada.EmpleadoDetalleEntradaDTO;
import com.proyecto.desarrollo.empleados.infraestructura.DTO.entrada.EmpleadoEntradaDTO;
import com.proyecto.desarrollo.empleados.infraestructura.DTO.salida.EmpleadoDetalleSalidaDTO;
import com.proyecto.desarrollo.empleados.infraestructura.persistencia.PersistenciaEmpleadoNest;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Empleados_servicio {
    PersistenciaEmpleado repositorio;

    public Empleados_servicio() {
        this.repositorio = new PersistenciaEmpleadoNest();
    }

    public ArrayList<EmpleadoEntradaDTO> obtener_lista_empleados() throws ErrorGeneralExcepcion {
        try {
            ArrayList<EmpleadoEntradaDTO> lista_empleados = this.repositorio.obtener_lista_empleados();
            return lista_empleados;
        }
        catch (Exception e){
            e.printStackTrace();
            throw new ErrorGeneralExcepcion();
        }

    }

    public EmpleadoDetalleEntradaDTO obtener_detalle_empleado(String uuid) throws ErrorGeneralExcepcion{
        try {
            EmpleadoDetalleSalidaDTO peticion = new EmpleadoDetalleSalidaDTO(uuid);
            EmpleadoDetalleEntradaDTO empleado_detalle = this.repositorio.obtener_detalle_empleado(peticion);
            return empleado_detalle;
        }
        catch (Exception e){
            e.printStackTrace();
            throw new ErrorGeneralExcepcion();
        }
    }

    public ArrayList<EmpleadoEntradaDTO> filtrarEmpleadosPorCorreo(ArrayList<EmpleadoEntradaDTO> lista_empleados , String correo){
        ArrayList<EmpleadoEntradaDTO> lista_empleados_filtrada = new ArrayList<EmpleadoEntradaDTO>();
        lista_empleados.forEach(empleado -> {
            if(empleado.getCorreo().contains(correo)){
                lista_empleados_filtrada.add(empleado);
            }
        });
        return lista_empleados_filtrada;
    }

}
