package com.proyecto.desarrollo.entrevistas.infraestructura.DTOs.entrada;

public class ConsultaPropuestaEntrevistaDTO {

    private String uuid;

    private String fechaPautada;

    private String asunto;

    private String estatus;

    private String vinculo;


    public ConsultaPropuestaEntrevistaDTO(String uuid, String fechaPautada, String asunto, String estatus, String vinculo) {
        this.uuid = uuid;
        this.fechaPautada = fechaPautada;
        this.asunto = asunto;
        this.estatus = estatus;
        this.vinculo = vinculo;
    }

    public String getUuid() {
        return uuid;
    }

    public String getFechaPautada() {
        return fechaPautada;
    }

    public String getAsunto() {
        return asunto;
    }

    public String getEstatus() {
        return estatus;
    }

    public String getVinculo() {
        return vinculo;
    }
}
