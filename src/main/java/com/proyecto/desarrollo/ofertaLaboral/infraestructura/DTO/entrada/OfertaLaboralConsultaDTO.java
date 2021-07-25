package com.proyecto.desarrollo.ofertaLaboral.infraestructura.DTO.entrada;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(value ={"duracion"})
public class OfertaLaboralConsultaDTO {

    private String uuid;

    private String titulo;

    private String fechaPublicacion;

    private String cargo;

    private float sueldo;

    /*La duracion es la combinacion de la escala y el valor de la duracion, ejm 2 dias, 6 meses, etc*/
    private int duracionEstimadaValor;

    private String duracionEstimadaEscala;

    private String turnoTrabajo;

    private int numeroVacantes;

    private String nombreEmpresa;

    private String estatus;

    public OfertaLaboralConsultaDTO(String id, String titulo, String fechaPublicacion, String cargo, float sueldo, int valor , String escala, String turnoTrabajo, int numeroVacantes, String nombreEmpresa,String estado) {
        this.uuid = id;
        this.titulo = titulo;
        this.fechaPublicacion = fechaPublicacion;
        this.cargo = cargo;
        this.sueldo = sueldo;
        /* Ensamblaje de la duracion */
        this.duracionEstimadaValor = valor;
        this.duracionEstimadaEscala = escala;
        this.turnoTrabajo = turnoTrabajo;
        this.numeroVacantes = numeroVacantes;
        this.nombreEmpresa = nombreEmpresa;
        this.estatus = estado;
    }

    public String getUuid() {
        return uuid;
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

    public String getDuracion() {
        if (this.duracionEstimadaEscala.equals("mes") && this.duracionEstimadaValor > 1)
            return Integer.toString(this.duracionEstimadaValor) + " " + this.duracionEstimadaEscala+"es";
        else if(this.duracionEstimadaEscala.equals("dia") || this.duracionEstimadaEscala.equals("hora") || this.duracionEstimadaEscala.equals("año") ){
            if (this.duracionEstimadaValor > 1)
                return Integer.toString(this.duracionEstimadaValor) + " " + this.duracionEstimadaEscala+"s";
        }
        return Integer.toString(this.duracionEstimadaValor) + " " + this.duracionEstimadaEscala;
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

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public String getEstatus() {
        return estatus;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }
}
