package com.proyecto.desarrollo.autenticacion.infraestructura.persistencia;

import com.proyecto.desarrollo.autenticacion.aplicacion.persistencia.PersistenciaStaff;
import com.proyecto.desarrollo.autenticacion.dominio.excepciones.AutenticacionInvalidaExcepcion;
import com.proyecto.desarrollo.autenticacion.infraestructura.DTO.entrada.UsuarioAutenticadoFirebaseEntradaDTO;
import com.proyecto.desarrollo.autenticacion.infraestructura.DTO.entrada.UsuarioAutenticadoNestEntradaDTO;
import com.proyecto.desarrollo.autenticacion.infraestructura.DTO.salida.UsuarioAutenticadoFirebaseSalidaDTO;
import com.proyecto.desarrollo.autenticacion.infraestructura.DTO.salida.UsuarioAutenticadoNestSalidaDTO;
import org.json.simple.parser.ParseException;

import java.io.IOException;

public class PersistenciaStaffNest implements PersistenciaStaff {


    @Override
    public String obtenerStaffs(){
        return null;
    }

    @Override
    public UsuarioAutenticadoFirebaseEntradaDTO obtener_token(UsuarioAutenticadoFirebaseSalidaDTO credenciales) throws AutenticacionInvalidaExcepcion{
        UsuarioAutenticadoFirebaseEntradaDTO respuesta = new UsuarioAutenticadoFirebaseEntradaDTO("uuid prueba");
        return respuesta;
    }

    @Override
    public UsuarioAutenticadoNestEntradaDTO obtener_staff(UsuarioAutenticadoNestSalidaDTO credenciales) {
        UsuarioAutenticadoNestEntradaDTO respuesta = new UsuarioAutenticadoNestEntradaDTO("Juan" , "Perez");
        return respuesta;
    }
}
