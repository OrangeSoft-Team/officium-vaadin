package com.proyecto.desarrollo.autenticacion.aplicacion.servicios;

import com.proyecto.desarrollo.autenticacion.aplicacion.persistencia.PersistenciaStaff;
import com.proyecto.desarrollo.autenticacion.dominio.Staff;
import com.proyecto.desarrollo.autenticacion.dominio.excepciones.AutenticacionInvalidaExcepcion;
import com.proyecto.desarrollo.autenticacion.dominio.valueObjects.NombreUsuario;
import com.proyecto.desarrollo.autenticacion.infraestructura.accesos.ConfigurarRutas;
import com.proyecto.desarrollo.autenticacion.infraestructura.persistencia.StaffArchivoPersistencia;


public class Autenticar_servicio {

    private PersistenciaStaff repositorioStaff;

    public Autenticar_servicio() {
        this.repositorioStaff = new StaffArchivoPersistencia();
    }

    public Staff autenticar(String nombreusuario_string , String contrasena_string) throws AutenticacionInvalidaExcepcion {
        NombreUsuario nombreusuario = new NombreUsuario(nombreusuario_string);
        try {
            Staff staff = repositorioStaff.obtenerStaffPorNombreUsuario(nombreusuario);
            if (staff != null && staff.validar_contrasena(contrasena_string)){
                return staff;
            }
            else{
                throw new AutenticacionInvalidaExcepcion();
            }
        }
        catch (Exception e){
            throw new AutenticacionInvalidaExcepcion();
        }

    }

}
