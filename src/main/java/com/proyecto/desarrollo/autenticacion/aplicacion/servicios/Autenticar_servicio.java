package com.proyecto.desarrollo.autenticacion.aplicacion.servicios;

import com.proyecto.desarrollo.autenticacion.aplicacion.persistencia.PersistenciaStaff;
import com.proyecto.desarrollo.autenticacion.dominio.Staff;
import com.proyecto.desarrollo.autenticacion.dominio.excepciones.AutenticacionInvalidaExcepcion;
import com.proyecto.desarrollo.autenticacion.dominio.valueObjects.Nombre;
import com.proyecto.desarrollo.autenticacion.infraestructura.DTO.entrada.UsuarioAutenticadoFirebaseEntradaDTO;
import com.proyecto.desarrollo.autenticacion.infraestructura.DTO.entrada.UsuarioAutenticadoNestEntradaDTO;
import com.proyecto.desarrollo.autenticacion.infraestructura.DTO.salida.UsuarioAutenticadoFirebaseSalidaDTO;
import com.proyecto.desarrollo.autenticacion.infraestructura.DTO.salida.UsuarioAutenticadoNestSalidaDTO;
import com.proyecto.desarrollo.autenticacion.infraestructura.persistencia.PersistenciaStaffNest;


public class Autenticar_servicio {

    private PersistenciaStaff repositorioStaff;

    public Autenticar_servicio() {
        this.repositorioStaff = new PersistenciaStaffNest();
    }

    public Staff autenticar(String nombreusuario_string , String contrasena_string) throws AutenticacionInvalidaExcepcion {
        try {
            UsuarioAutenticadoFirebaseSalidaDTO peticion_datos_token = new UsuarioAutenticadoFirebaseSalidaDTO(nombreusuario_string , contrasena_string);
            UsuarioAutenticadoFirebaseEntradaDTO token = repositorioStaff.obtener_token(peticion_datos_token);

            UsuarioAutenticadoNestSalidaDTO peticion_datos_staff = new UsuarioAutenticadoNestSalidaDTO(nombreusuario_string , token.getUuid());
            UsuarioAutenticadoNestEntradaDTO staff_datos = repositorioStaff.obtener_staff(peticion_datos_staff);
            Staff staff = new Staff(new Nombre(staff_datos.getPrimer_nombre()) , new Nombre(staff_datos.getPrimer_apellido()));
            return staff;

        }
        catch (Exception e){
            e.printStackTrace();
            throw new AutenticacionInvalidaExcepcion();
        }

    }

}
