package com.proyecto.desarrollo.ofertaLaboral.infraestructura.vistas;

import com.proyecto.desarrollo.comunes.infraestructura.DTOs.HabilidadDTO;
import com.proyecto.desarrollo.ofertaLaboral.dominio.OfertaLaboral;
import com.proyecto.desarrollo.ofertaLaboral.infraestructura.vistas.detallesOferta.DetallesOfertaLaboral;
import org.json.simple.parser.ParseException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.fail;

public class ModificarOfertaLaboralTest {

    private OfertaLaboral datosParaModificar;

    private String uuidOferta;

    private DetallesOfertaLaboral vista;

    @Before
    public void inicializarDatos() throws ParseException {
        /*Se crea un arrray con habilidades*/
        HabilidadDTO[] habilidades = new HabilidadDTO[1];
        habilidades[0] = new HabilidadDTO("76da530e-a50b-43d5-874a-f7d48d9d8ab4","Computadoras","Manteninimiento");
        /*Se crea una oferta laboral con la empresa 1*/
        datosParaModificar = new OfertaLaboral("Se busca Desarrollador Jr","Se busca un Desarrollador Jr para que labore en la empresa Orangesoft durante el dia y no salga de la oficina en todo el dia","Desarrollador",(float)70.15,4,"mes", "mixto",8,null,"Que no necesite descansos ni comer",habilidades);
        uuidOferta = "1";
        vista = new DetallesOfertaLaboral(true);
    }

    @Test
    public void modificacionTest() throws ParseException {
        /*Se rellena la vista con los datos de la oferta que se modificara*/
        vista.setOfertaDetallada(this.uuidOferta);
        /*Una vez la vista ya tiene los datos, se procederan a hacer modificaciones en los campos y se revisa que se ingresaron bien los cambiso en los campos*/
        vista.setTitulo(datosParaModificar.getTitulo().getTitulo());
        Assert.assertEquals(vista.getTitulo(),datosParaModificar.getTitulo().getTitulo());

        vista.setCargo(datosParaModificar.getCargo().getCargo());
        Assert.assertEquals(vista.getCargo(),datosParaModificar.getCargo().getCargo());

        vista.setDescripcion(datosParaModificar.getDescripcion().getDescripcion());
        Assert.assertEquals(vista.getDescripcion(),datosParaModificar.getDescripcion().getDescripcion());

        vista.setVacantes(Integer.toString(datosParaModificar.getNumeroVacantes().getVacantes()));
        Assert.assertEquals(vista.getVacantes(),Integer.toString(datosParaModificar.getNumeroVacantes().getVacantes()));

        vista.setEscala(datosParaModificar.getDuracionEstimadaEscala().getEscala());
        Assert.assertEquals(vista.getEscala(),datosParaModificar.getDuracionEstimadaEscala().getEscala());

        vista.getEnviarModificacion().click();
        if (!vista.getModificacionExitosa())
            fail("No se pudo realizar la modificacion");
    }
}
