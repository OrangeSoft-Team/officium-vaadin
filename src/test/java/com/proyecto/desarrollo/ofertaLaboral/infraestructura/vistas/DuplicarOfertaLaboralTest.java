package com.proyecto.desarrollo.ofertaLaboral.infraestructura.vistas;

import com.proyecto.desarrollo.ofertaLaboral.infraestructura.vistas.consultarOfertas.ServicioOfertaLaboral;
import org.json.simple.parser.ParseException;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.fail;

public class DuplicarOfertaLaboralTest {

    ServicioOfertaLaboral controlador = new ServicioOfertaLaboral();


    @Test
    public void pruebaDuplicado() throws ParseException, IOException {
        if (!controlador.duplicarOferta("1")){
            fail("No se pudo duplicar, fallo el adaptador");
        }
        System.out.println("Duplicación exitosa");
    }
}
