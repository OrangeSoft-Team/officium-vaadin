package com.proyecto.desarrollo.autenticacion.aplicacion.persistencia;

import com.proyecto.desarrollo.autenticacion.dominio.Staff;
import com.proyecto.desarrollo.autenticacion.dominio.valueObjects.NombreUsuario;
import org.json.simple.parser.ParseException;

import java.io.IOException;

public interface PersistenciaStaff {

    public String obtenerStaffs() throws IOException;

    public Staff obtenerStaffPorNombreUsuario(NombreUsuario nombreusuario) throws ParseException;

}
