package com.proyecto.desarrollo.autenticacion.aplicacion.persistencia;

import com.proyecto.desarrollo.autenticacion.dominio.Staff;
import com.proyecto.desarrollo.autenticacion.dominio.excepciones.AutenticacionInvalidaExcepcion;
import com.proyecto.desarrollo.autenticacion.infraestructura.DTO.entrada.UsuarioAutenticadoFirebaseEntradaDTO;
import com.proyecto.desarrollo.autenticacion.infraestructura.DTO.entrada.UsuarioAutenticadoNestEntradaDTO;
import com.proyecto.desarrollo.autenticacion.infraestructura.DTO.salida.UsuarioAutenticadoFirebaseSalidaDTO;
import com.proyecto.desarrollo.autenticacion.infraestructura.DTO.salida.UsuarioAutenticadoNestSalidaDTO;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.net.MalformedURLException;

public interface PersistenciaStaff {

    public String obtenerStaffs();

    public UsuarioAutenticadoFirebaseEntradaDTO obtener_token(UsuarioAutenticadoFirebaseSalidaDTO credenciales) throws AutenticacionInvalidaExcepcion;

    public UsuarioAutenticadoNestEntradaDTO obtener_staff(UsuarioAutenticadoNestSalidaDTO credenciales) throws IOException, ParseException;

}
