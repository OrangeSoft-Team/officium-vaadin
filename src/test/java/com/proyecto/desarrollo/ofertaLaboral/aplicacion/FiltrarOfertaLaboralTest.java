package com.proyecto.desarrollo.ofertaLaboral.aplicacion;

import com.proyecto.desarrollo.ofertaLaboral.infraestructura.DTO.entrada.OfertaLaboralConsultaDTO;
import com.proyecto.desarrollo.ofertaLaboral.infraestructura.persistencia.OfertasLaboralArchivoPersistencia;
import com.proyecto.desarrollo.ofertaLaboral.infraestructura.vistas.consultarOfertas.ServicioOfertaLaboral;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class FiltrarOfertaLaboralTest {

    private OfertaLaboralConsultaDTO[] ofertas;

    private String estado;

    private FiltrosOfertaLaboral controlador;

    @Before
    public void crearDatos() {
       ofertas = new OfertaLaboralConsultaDTO[3];
       ofertas[0] = new OfertaLaboralConsultaDTO(null,null,null,null,0,0,null,null,0,null,"activo");
        ofertas[1] = new OfertaLaboralConsultaDTO(null,null,null,null,0,0,null,null,0,null,"activo");
        ofertas[2] = new OfertaLaboralConsultaDTO(null,null,null,null,0,0,null,null,0,null,"inactivo");
        this.estado = "inactivo";
    }

    /*mvn -Dtest=FiltrarOfertaLaboralTest#filtroAplicadoCorrectamente test*/
    @Test
    public void filtroAplicadoCorrectamente(){
        int contador = 0 ;
        this.controlador = new FiltrosOfertaLaboral();
        contador = controlador.contarFiltrados(this.ofertas,this.estado);
        if (estado.equals("activo")){
            Assert.assertEquals(2,contador);
        }
        else{
            Assert.assertEquals(1,contador);
        }
        System.out.println("Se esperan " + contador + " registros");
    }
}
