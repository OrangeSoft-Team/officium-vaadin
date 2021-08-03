package com.proyecto.desarrollo.autenticacion.aplicacion.servicios;

import com.proyecto.desarrollo.autenticacion.aplicacion.persistencia.PersistenciaStaff;
import com.proyecto.desarrollo.autenticacion.dominio.Staff;
import com.proyecto.desarrollo.autenticacion.dominio.valueObjects.CargoStaff;
import com.proyecto.desarrollo.autenticacion.dominio.valueObjects.CorreoElectronico;
import com.proyecto.desarrollo.autenticacion.dominio.valueObjects.Nombre;
import com.proyecto.desarrollo.autenticacion.infraestructura.DTO.entrada.DatosBasicosUsuarioEntradaDTO;
import com.proyecto.desarrollo.autenticacion.infraestructura.DTO.salida.DatosBasicosUsuarioSalidaDTO;
import com.proyecto.desarrollo.autenticacion.infraestructura.persistencia.PersistenciaStaffNest;
import org.json.simple.parser.ParseException;

import java.io.IOException;

public class Perfil_servicio {
    private PersistenciaStaff repositorioStaff;

    public Perfil_servicio() {
        this.repositorioStaff = new PersistenciaStaffNest();
    }

    public Staff obtener_staff() throws IOException, ParseException {
        DatosBasicosUsuarioEntradaDTO staff_datos = repositorioStaff.obtener_datos_basicos();
        Staff staff = new Staff(new Nombre(staff_datos.getPrimer_nombre()) , new Nombre(staff_datos.getPrimer_apellido()) , new CargoStaff(staff_datos.getCargo()) , new CorreoElectronico(staff_datos.getCorreo()));
        return staff;
    }

    public Boolean ingresar_datos_basicos(String primer_nombre, String primer_apellido, String cargo) throws IOException, ParseException {
        DatosBasicosUsuarioSalidaDTO datos_staff_salida = new DatosBasicosUsuarioSalidaDTO(primer_nombre , primer_apellido , cargo);
        Boolean ingreso_exitoso = repositorioStaff.ingresar_datos_basicos(datos_staff_salida);
        return ingreso_exitoso;
    }
}
