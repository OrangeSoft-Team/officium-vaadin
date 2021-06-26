package com.proyecto.desarrollo.backend.entidades.ofertaLaboral.infraestructura.DTO.saliente;

import com.proyecto.desarrollo.backend.entidades.ofertaLaboral.dominio.valueObjects.*;

public class OfertaLaboralCreacionDTO {

    private String titulo;

    private String descripcion;

    private String cargo;

    private float sueldo;

    private int duracionEstimadaValor;

    private String duracionEstimadaEscala;

    private String turnoTrabajo;

    private int numeroVacantes;

    private String idEmpresa;

    public OfertaLaboralCreacionDTO(String titulo, String descripcion, String cargo, float sueldo, int duracionEstimadaValor, String duracionEstimadaEscala, String turnoTrabajo, int numeroVacantes, String idEmpresa) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.cargo = cargo;
        this.sueldo = sueldo;
        this.duracionEstimadaValor = duracionEstimadaValor;
        this.duracionEstimadaEscala = duracionEstimadaEscala;
        this.turnoTrabajo = turnoTrabajo;
        this.numeroVacantes = numeroVacantes;
        this.idEmpresa = idEmpresa;
    }
}
