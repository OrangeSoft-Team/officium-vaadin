package com.proyecto.desarrollo.entrevista.infraestructura.persistencia;

import com.proyecto.desarrollo.entrevistas.infraestructura.vistas.modal.ConsultarPropuestaEntrevistaModal;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.fail;

public class PruebaAceptacionProponerEntrevista {

    private ConsultarPropuestaEntrevistaModal modal;

    @Before
    public void instanciarAtributos(){
        /*En este caso de prueba, se coloca 1 porque el registro con id de propuesta 1 en la base no tendra entrevista programada*/
        modal = new ConsultarPropuestaEntrevistaModal("1");
    }

    @Test
    public void proponerEntrevistaTest(){
        /*En caso de probarse con archivos, ir al archivo json que contiene la entrevista y colocar el uuid como null*/
        modal.buscarEntrevista("1");
        /*En este caso no hago click al boton, porque ese boton acciona que aparezca una notificacion,
        * y como no se esta creando interfaz, arroja un error, por lo cual se llama a una version
        * del metodo que llama el boton pero sin la creación de la notificacion*/
        if (!modal.getControlador().proponerEntrevista("1",true))
            fail("Fallo al proponer la entrevista");
    }
}
