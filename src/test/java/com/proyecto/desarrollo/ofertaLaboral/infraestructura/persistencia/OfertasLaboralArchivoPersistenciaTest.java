package com.proyecto.desarrollo.ofertaLaboral.infraestructura.persistencia;

import com.proyecto.desarrollo.ofertaLaboral.aplicacion.OfertaLaboralMapper;
import com.proyecto.desarrollo.ofertaLaboral.dominio.OfertaLaboral;
import com.proyecto.desarrollo.ofertaLaboral.infraestructura.DTO.salida.OfertaLaboralCreacion;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Fail.fail;

public class OfertasLaboralArchivoPersistenciaTest {

    OfertaLaboralCreacion ofertaACrear;
    OfertasLaboralArchivoPersistencia adaptador;

    @Before
    public void crearDatosPrueba() {
        OfertaLaboralMapper mapper =  new OfertaLaboralMapper();
        OfertaLaboral oferta = new OfertaLaboral("Se busca Conserje","Se busca un conserje para que labore en la empresa Orangesoft durante el dia","Vendedor",(float)700.16,4,"dia", "diurno",8,"2");
        ofertaACrear = mapper.ofertaLaboralToDTOCreacion(oferta);
        adaptador = new OfertasLaboralArchivoPersistencia();
    }

    /*mvn -Dtest=OfertasLaboralArchivoPersistenciaTest#guardarOferta test*/
    @Test
    public void guardarOferta(){
        if (!adaptador.crearOferta(ofertaACrear))
            fail("La creacion Falló, no pudo escribirse en el archivo");
        System.out.println("Creación exitosa");
    }
}
