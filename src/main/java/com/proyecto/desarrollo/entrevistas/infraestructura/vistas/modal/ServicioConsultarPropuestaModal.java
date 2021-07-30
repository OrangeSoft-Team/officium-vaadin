package com.proyecto.desarrollo.entrevistas.infraestructura.vistas.modal;

import com.proyecto.desarrollo.comunes.infraestructura.persistencia.PersistenciaPropuestaEntrevistas;
import com.proyecto.desarrollo.entrevistas.aplicacion.EntrevistasMapper;
import com.proyecto.desarrollo.entrevistas.infraestructura.DTOs.entrada.ConsultaPropuestaEntrevistaDTO;
import com.proyecto.desarrollo.entrevistas.infraestructura.persistencia.PersistenciaPropuestaEntrevistaArchivo;
import org.json.simple.parser.ParseException;

public class ServicioConsultarPropuestaModal {

    private ConsultaPropuestaEntrevistaDTO propuesta;

    private PersistenciaPropuestaEntrevistas adaptador;

    private EntrevistasMapper mapper;

    public ServicioConsultarPropuestaModal() {
        this.adaptador = new PersistenciaPropuestaEntrevistaArchivo();
        this.mapper = new EntrevistasMapper();
    }

    public void obtenerPropuesta(String uuid) throws ParseException {
        this.propuesta = mapper.jsonToPropuesta(adaptador.consultaPropuestaEntrevista(uuid));
        System.out.println("hola");
    }

    public ConsultaPropuestaEntrevistaDTO getPropuesta() {
        return propuesta;
    }
}

