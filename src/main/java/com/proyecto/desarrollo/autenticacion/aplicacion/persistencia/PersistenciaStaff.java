package com.proyecto.desarrollo.autenticacion.aplicacion.persistencia;

import com.google.firebase.auth.FirebaseAuthException;
import com.proyecto.desarrollo.autenticacion.dominio.Staff;
import com.proyecto.desarrollo.autenticacion.dominio.excepciones.AutenticacionInvalidaExcepcion;
import com.proyecto.desarrollo.autenticacion.infraestructura.DTO.entrada.DatosBasicosUsuarioEntradaDTO;
import com.proyecto.desarrollo.autenticacion.infraestructura.DTO.entrada.UsuarioAutenticadoFirebaseEntradaDTO;
import com.proyecto.desarrollo.autenticacion.infraestructura.DTO.entrada.UsuarioAutenticadoNestEntradaDTO;
import com.proyecto.desarrollo.autenticacion.infraestructura.DTO.salida.DatosBasicosUsuarioSalidaDTO;
import com.proyecto.desarrollo.autenticacion.infraestructura.DTO.salida.UsuarioAutenticadoFirebaseSalidaDTO;
import com.proyecto.desarrollo.autenticacion.infraestructura.DTO.salida.UsuarioAutenticadoNestSalidaDTO;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.net.MalformedURLException;

public interface PersistenciaStaff {

    public String obtenerStaffs();

    public UsuarioAutenticadoFirebaseEntradaDTO obtener_token(UsuarioAutenticadoFirebaseSalidaDTO credenciales) throws AutenticacionInvalidaExcepcion, IOException, FirebaseAuthException, ParseException;

    public UsuarioAutenticadoNestEntradaDTO obtener_staff(UsuarioAutenticadoNestSalidaDTO credenciales) throws IOException, ParseException;

    public DatosBasicosUsuarioEntradaDTO obtener_datos_basicos() throws MalformedURLException, IOException, ParseException;

    public Boolean ingresar_datos_basicos(DatosBasicosUsuarioSalidaDTO peticion) throws IOException, ParseException;

}
