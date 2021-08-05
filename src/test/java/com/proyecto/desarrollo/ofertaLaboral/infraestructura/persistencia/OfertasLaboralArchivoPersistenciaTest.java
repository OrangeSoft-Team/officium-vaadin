package com.proyecto.desarrollo.ofertaLaboral.infraestructura.persistencia;

import com.proyecto.desarrollo.comunes.infraestructura.DTOs.HabilidadDTO;
import com.proyecto.desarrollo.comunes.infraestructura.persistencia.PersistenciaOfertaLaboral;
import com.proyecto.desarrollo.ofertaLaboral.aplicacion.OfertaLaboralMapper;
import com.proyecto.desarrollo.ofertaLaboral.dominio.OfertaLaboral;
import com.proyecto.desarrollo.ofertaLaboral.infraestructura.DTO.salida.OfertaLaboralCreacion;
import org.json.simple.parser.ParseException;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.assertj.core.api.Fail.fail;

public class OfertasLaboralArchivoPersistenciaTest {

    OfertaLaboralCreacion ofertaACrear;
    PersistenciaOfertaLaboral adaptador;

    @Before
    public void crearDatosPrueba() {
        OfertaLaboralMapper mapper =  new OfertaLaboralMapper();
        HabilidadDTO[] habilidades = new HabilidadDTO[1];
        habilidades[0] = new HabilidadDTO("76da530e-a50b-43d5-874a-f7d48d9d8ab4","Computadoras","Manteninimiento");
        OfertaLaboral oferta = new OfertaLaboral("Se busca Conserje","Se busca un conserje para que labore en la empresa Orangesoft durante el dia","Vendedor",(float)700.16,4,"dia", "diurno",8,"2","estudiante",habilidades);
        ofertaACrear = mapper.ofertaLaboralToDTOCreacion(oferta);
        adaptador = new OfertaLaboralAdaptadorSpring();
    }

    /*mvn -Dtest=OfertasLaboralArchivoPersistenciaTest#guardarOferta test*/
    @Test
    public void guardarOferta() throws IOException, ParseException {
        if (!adaptador.crearOferta(ofertaACrear))
            fail("La creacion Falló, no pudo escribirse en el archivo");
        System.out.println("Creación exitosa");
    }
}
