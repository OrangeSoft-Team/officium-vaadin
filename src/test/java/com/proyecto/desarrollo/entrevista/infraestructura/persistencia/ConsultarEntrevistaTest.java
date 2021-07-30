package com.proyecto.desarrollo.entrevista.infraestructura.persistencia;

import com.proyecto.desarrollo.comunes.infraestructura.persistencia.PersistenciaPropuestaEntrevistas;
import com.proyecto.desarrollo.entrevistas.aplicacion.EntrevistasMapper;
import com.proyecto.desarrollo.entrevistas.infraestructura.DTOs.entrada.ConsultaPropuestaEntrevistaDTO;
import com.proyecto.desarrollo.entrevistas.infraestructura.persistencia.PersistenciaPropuestaEntrevistaArchivo;
import org.json.simple.parser.ParseException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ConsultarEntrevistaTest {

    private ConsultaPropuestaEntrevistaDTO entrevista;

    private PersistenciaPropuestaEntrevistas adaptador;

    private EntrevistasMapper mapper;

    @Before
    public void instanciarAtributos(){
        entrevista = new ConsultaPropuestaEntrevistaDTO("1","15/1/2020","Entrevista para Se busca Cocinero","activo","htttp://www.prueba.com");
        adaptador = new PersistenciaPropuestaEntrevistaArchivo();
        mapper = new EntrevistasMapper();
    }

    @Test
    public void consultaEntrevista() throws ParseException {
        ConsultaPropuestaEntrevistaDTO entrevistaConsultada;
        entrevistaConsultada = mapper.jsonToPropuesta(adaptador.consultaPropuestaEntrevista("1"));
        Assert.assertEquals(this.entrevista.getUuid(),entrevistaConsultada.getUuid());
        Assert.assertEquals(this.entrevista.getAsunto(),entrevistaConsultada.getAsunto());
        Assert.assertEquals(this.entrevista.getEstatus(),entrevistaConsultada.getEstatus());
        Assert.assertEquals(this.entrevista.getVinculo(),entrevistaConsultada.getVinculo());
        Assert.assertEquals(this.entrevista.getFechaPautada(),entrevistaConsultada.getFechaPautada());
    }
}
