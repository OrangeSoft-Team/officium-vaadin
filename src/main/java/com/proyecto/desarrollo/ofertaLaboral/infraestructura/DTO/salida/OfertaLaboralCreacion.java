package com.proyecto.desarrollo.ofertaLaboral.infraestructura.DTO.salida;

import com.proyecto.desarrollo.comunes.infraestructura.DTOs.HabilidadDTO;
import com.proyecto.desarrollo.ofertaLaboral.dominio.valueObjects.Habilidades;

public class OfertaLaboralCreacion {

        private String titulo;

        private String descripcion;

        private String cargo;

        private float sueldo;

        private int duracionEstimadaValor;

        private String duracionEstimadaEscala;

        private String turnoTrabajo;

        private int numeroVacantes;

        private String idEmpresa;

        private String requisitosEspeciales;

        private Habilidades[] habilidades;

    public OfertaLaboralCreacion(String titulo, String descripcion, String cargo, float sueldo, int duracionEstimadaValor, String duracionEstimadaEscala, String turnoTrabajo, int numeroVacantes, String idEmpresa, String requisitosEspeciales, Habilidades[] habilidades) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.cargo = cargo;
        this.sueldo = sueldo;
        this.duracionEstimadaValor = duracionEstimadaValor;
        this.duracionEstimadaEscala = duracionEstimadaEscala;
        this.turnoTrabajo = turnoTrabajo;
        this.numeroVacantes = numeroVacantes;
        this.idEmpresa = idEmpresa;
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

    public String getIdEmpresa() {
        return idEmpresa;
    }

    public String getRequisitosEspeciales() {
        return requisitosEspeciales;
    }

    public Habilidades[] getHabilidades() {
        return habilidades;
    }
}
