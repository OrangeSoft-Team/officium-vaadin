package com.proyecto.desarrollo.empleados.aplicacion.servicios;

import com.google.firebase.auth.FirebaseAuthException;
import com.proyecto.desarrollo.autenticacion.dominio.excepciones.AutenticacionInvalidaExcepcion;
import com.proyecto.desarrollo.autenticacion.infraestructura.DTO.entrada.UsuarioAutenticadoFirebaseEntradaDTO;
import com.proyecto.desarrollo.autenticacion.infraestructura.DTO.entrada.UsuarioAutenticadoNestEntradaDTO;
import com.proyecto.desarrollo.autenticacion.infraestructura.DTO.salida.UsuarioAutenticadoFirebaseSalidaDTO;
import com.proyecto.desarrollo.autenticacion.infraestructura.DTO.salida.UsuarioAutenticadoNestSalidaDTO;
import com.proyecto.desarrollo.autenticacion.infraestructura.persistencia.PersistenciaStaffNest;
import com.proyecto.desarrollo.empleados.infraestructura.DTO.entrada.EmpleadoEntradaDTO;
import org.json.simple.parser.ParseException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;

public class FiltrarEmpleadosPorCorreoTest {
    private ArrayList<EmpleadoEntradaDTO> lista_empleados;
    private ArrayList<EmpleadoEntradaDTO> lista_empleados_filtrada;
    private String correo_buscar;
    private Empleados_servicio servicio_aplicacion;

    @Before
    public void instanciarAtributos(){
        this.correo_buscar = new String("andres");
        this.servicio_aplicacion = new Empleados_servicio();
        this.lista_empleados = new ArrayList<EmpleadoEntradaDTO>();
        this.lista_empleados_filtrada = new ArrayList<EmpleadoEntradaDTO>();
        this.lista_empleados.add(new EmpleadoEntradaDTO("uuid1" , "Andres" , "Bello" , "andres@test.com" , "activo" , "masculino"));
        this.lista_empleados.add(new EmpleadoEntradaDTO("uuid2" , "Andres" , "Bello" , "andres1@test.com" , "activo" , "masculino"));
        this.lista_empleados.add(new EmpleadoEntradaDTO("uuid3" , "Andres" , "Bello" , "andres2@test.com" , "activo" , "masculino"));
        this.lista_empleados.add(new EmpleadoEntradaDTO("uuid4" , "Andres" , "Bello" , "jose@test.com" , "activo" , "masculino"));
        this.lista_empleados.add(new EmpleadoEntradaDTO("uuid5" , "Andres" , "Bello" , "luis@test.com" , "activo" , "masculino"));
    }

    //    mvn -Dtest=FiltrarEmpleadosPorCorreoTest#filtrarEmpleadoPorCorreo test
    @Test
    public void filtrarEmpleadoPorCorreo() {
        this.lista_empleados_filtrada = this.servicio_aplicacion.filtrarEmpleadosPorCorreo(this.lista_empleados , this.correo_buscar);
        Assert.assertEquals(this.lista_empleados_filtrada.size() , 3);
    }

}
