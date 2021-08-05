package com.proyecto.desarrollo.autenticacion.infraestructura.persistencia;

import com.google.firebase.auth.FirebaseAuthException;
import com.proyecto.desarrollo.autenticacion.aplicacion.persistencia.PersistenciaStaff;
import com.proyecto.desarrollo.autenticacion.dominio.excepciones.AutenticacionInvalidaExcepcion;
import com.proyecto.desarrollo.autenticacion.infraestructura.DTO.entrada.UsuarioAutenticadoFirebaseEntradaDTO;
import com.proyecto.desarrollo.autenticacion.infraestructura.DTO.entrada.UsuarioAutenticadoNestEntradaDTO;
import com.proyecto.desarrollo.autenticacion.infraestructura.DTO.salida.UsuarioAutenticadoFirebaseSalidaDTO;
import com.proyecto.desarrollo.autenticacion.infraestructura.DTO.salida.UsuarioAutenticadoNestSalidaDTO;
import com.proyecto.desarrollo.entrevistas.aplicacion.EntrevistasMapper;
import com.proyecto.desarrollo.entrevistas.infraestructura.DTOs.entrada.ConsultaPropuestaEntrevistaDTO;
import com.proyecto.desarrollo.entrevistas.infraestructura.persistencia.PersistenciaPropuestaEntrevistaArchivo;
import org.json.simple.parser.ParseException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

public class IniciarSesionTest {
    private String correo = "robert@officium.com";
    private String clave = "123456";
    private UsuarioAutenticadoFirebaseSalidaDTO credenciales_firebase;
    private UsuarioAutenticadoNestSalidaDTO credenciales_nest;
    private PersistenciaStaff adaptador;

    @Before
    public void instanciarAtributos(){
//        un staff registrado
        this.credenciales_firebase = new UsuarioAutenticadoFirebaseSalidaDTO(this.correo , this.clave);
        this.adaptador = new PersistenciaStaffNest();
    }

//    mvn -Dtest=IniciarSesionTest#iniciarSesion test
    @Test
    public void iniciarSesion() throws IOException, ParseException, AutenticacionInvalidaExcepcion, FirebaseAuthException {
        UsuarioAutenticadoFirebaseEntradaDTO respuesta_firebase = adaptador.obtener_token(this.credenciales_firebase);
        credenciales_nest  = new UsuarioAutenticadoNestSalidaDTO(this.correo , respuesta_firebase.getUuid());
        UsuarioAutenticadoNestEntradaDTO respuesta_nest = adaptador.obtener_staff(credenciales_nest);
        Assert.assertEquals(respuesta_nest.getPrimer_nombre() , "Robert");
        Assert.assertEquals(respuesta_nest.getPrimer_apellido() , "Gonzales");
    }

}
