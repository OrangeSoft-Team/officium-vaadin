package com.proyecto.desarrollo.autenticacion.infraestructura.vistas.controladores;
import com.proyecto.desarrollo.autenticacion.aplicacion.servicios.Autenticar_servicio;
import com.proyecto.desarrollo.autenticacion.dominio.excepciones.AutenticacionInvalidaExcepcion;
import com.proyecto.desarrollo.autenticacion.infraestructura.accesos.ConfigurarRutas;
import org.springframework.stereotype.Service;

@Service
public class Login_controlador {

    private Autenticar_servicio autenticar_servicio;

    public Login_controlador() {
        this.autenticar_servicio = new Autenticar_servicio();
    }


    public void autenticar(String nombreusuario_string , String contrasena_string) throws AutenticacionInvalidaExcepcion {
        boolean autenticado_exitosamente = autenticar_servicio.autenticar(nombreusuario_string , contrasena_string);
        if (autenticado_exitosamente){
            ConfigurarRutas configurar_rutas = new ConfigurarRutas();
            configurar_rutas.habilitar_rutas();
        }
    }

}
