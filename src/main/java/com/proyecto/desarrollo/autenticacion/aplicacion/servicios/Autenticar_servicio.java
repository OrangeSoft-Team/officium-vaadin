package com.proyecto.desarrollo.autenticacion.aplicacion.servicios;

import com.proyecto.desarrollo.autenticacion.aplicacion.persistencia.PersistenciaStaff;
import com.proyecto.desarrollo.autenticacion.dominio.Staff;
import com.proyecto.desarrollo.autenticacion.dominio.excepciones.AutenticacionInvalidaExcepcion;
import com.proyecto.desarrollo.autenticacion.dominio.valueObjects.NombreUsuario;
import com.proyecto.desarrollo.autenticacion.infraestructura.accesos.ConfigurarRutas;
import com.proyecto.desarrollo.autenticacion.infraestructura.persistencia.StaffArchivoPersistencia;
import com.vaadin.flow.component.notification.Notification;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Service;

@Service
public class Autenticar_servicio {

    private PersistenciaStaff repositorioStaff;

    public Autenticar_servicio() {
        this.repositorioStaff = new StaffArchivoPersistencia();
    }

    public void autenticar(String nombreusuario_string , String contrasena_string) throws AutenticacionInvalidaExcepcion {
        NombreUsuario nombreusuario = new NombreUsuario(nombreusuario_string);
        try {
            Staff staff = repositorioStaff.obtenerStaffPorNombreUsuario(nombreusuario);
            if (staff != null && staff.validar_contrasena(contrasena_string)){
                ConfigurarRutas configurar_rutas = new ConfigurarRutas();
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
