package com.proyecto.desarrollo.ofertaLaboral.infraestructura.DTO.salida;

import com.proyecto.desarrollo.comunes.infraestructura.DTOs.HabilidadDTO;

import java.util.Locale;

public class OfertaLaboralModificacion {

    private String titulo;

    private String descripcion;

    private String cargo;

    private float sueldo;

    private int duracionEstimadaValor;

    private String duracionEstimadaEscala;

    private String turnoTrabajo;

    private int numeroVacantes;

    private String requisitosEspeciales;

    private HabilidadDTO[] habilidades;

    public OfertaLaboralModificacion(String titulo, String descripcion, String cargo, float sueldo, int duracionEstimadaValor, String duracionEstimadaEscala, String turnoTrabajo, int numeroVacantes, String requisitosEspeciales, HabilidadDTO[] habilidades) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.cargo = cargo;
        this.sueldo = sueldo;
        this.duracionEstimadaValor = duracionEstimadaValor;
        this.duracionEstimadaEscala = duracionEstimadaEscala.toUpperCase(Locale.ROOT);
        this.turnoTrabajo = turnoTrabajo.toUpperCase(Locale.ROOT);
        this.numeroVacantes = numeroVacantes;
        this.requisitosEspeciales = requisitosEspeciales;
        this.habilidades = habilidades;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getDescripcion() {
        return descripcion;
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

    public String getRequisitosEspeciales() {
        return requisitosEspeciales;
    }

    public HabilidadDTO[] getHabilidades() {
        return habilidades;
    }
}
