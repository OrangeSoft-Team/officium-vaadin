package com.proyecto.desarrollo.entrevistas.infraestructura.DTOs.salida;

public class CrearPropuestaEntrevistaDTO {

    private String dateFormateada;

    public CrearPropuestaEntrevistaDTO(String dateFormateada) {
        this.dateFormateada = dateFormateada;
    }

    public String getDateFormateada() {
        return dateFormateada;
    }
}
