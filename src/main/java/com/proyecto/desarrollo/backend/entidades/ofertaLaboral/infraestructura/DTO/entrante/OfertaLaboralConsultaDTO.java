package com.proyecto.desarrollo.backend.entidades.ofertaLaboral.infraestructura.DTO.entrante;

import com.proyecto.desarrollo.backend.entidades.ofertaLaboral.dominio.valueObjects.DuracionEstimadaEscala;
import com.proyecto.desarrollo.backend.entidades.ofertaLaboral.dominio.valueObjects.DuracionEstimadaValor;

public class OfertaLaboralConsultaDTO {
    private String id;

    private String titulo;

    private String fechaPublicacion;

    private String cargo;

    private float sueldo;

    private int duracionEstimadaValor;

    private String duracionEstimadaEscala;

    private String turnoTrabajo;

    private int numeroVacantes;

    private String empresaNombre;

    public OfertaLaboralConsultaDTO(String id, String titulo, String fechaPublicacion, String cargo, float sueldo, int duracionEstimadaValor, String duracionEstimadaEscala, String turnoTrabajo, int numeroVacantes,String empresaNombre) {
        this.id = id;
        this.titulo = titulo;
        this.fechaPublicacion = fechaPublicacion;
        this.cargo = cargo;
        this.sueldo = sueldo;
        this.duracionEstimadaValor = duracionEstimadaValor;
        this.duracionEstimadaEscala = duracionEstimadaEscala;
        this.turnoTrabajo = turnoTrabajo;
        this.numeroVacantes = numeroVacantes;
        this.empresaNombre = empresaNombre;
    }

    public String getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getFechaPublicacion() {
        return fechaPublicacion;
    }

    public String getCargo() {
        return cargo;
    }

    public float getSueldo() {
        return sueldo;
    }

    public int getDuracionEstimadaValor() {
        return duracionEstimadaValor;
    }

    public String getDuracionEstimadaEscala() {
        return duracionEstimadaEscala;
    }

    public String getTurnoTrabajo() {
        return turnoTrabajo;
    }

    public int getNumeroVacantes() {
        return numeroVacantes;
    }

    public String getEmpresaNombre() {
        return empresaNombre;
    }
}
