package com.proyecto.desarrollo.entrevista.infraestructura.persistencia;

import com.proyecto.desarrollo.comunes.infraestructura.persistencia.PersistenciaPropuestaEntrevistas;
import com.proyecto.desarrollo.entrevistas.aplicacion.EntrevistasMapper;
import com.proyecto.desarrollo.entrevistas.infraestructura.DTOs.entrada.ConsultaPropuestaEntrevistaDTO;
import com.proyecto.desarrollo.entrevistas.infraestructura.persistencia.PersistenciaPropuestaEntrevistaArchivo;
import org.json.simple.parser.ParseException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.fail;

public class ProponerEntrevistaTest {

    private PersistenciaPropuestaEntrevistas adaptador;

    @Before
    public void instanciarAtributos(){
        adaptador = new PersistenciaPropuestaEntrevistaArchivo();
    }

    @Test
    public void consultaEntrevista() throws ParseException {
        if (!adaptador.proponerEntrevista("1"))
            fail("Fallo al proponer la entrevista, puede ser que ya haya una entrevista activa.");
    }
}
