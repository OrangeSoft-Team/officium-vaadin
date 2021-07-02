package com.proyecto.desarrollo.ofertaLaboral.infraestructura.DTO.entrada;

public class OfertaLaboralConsultaDTO {

    private String id;

    private String titulo;

    private String fechaPublicacion;

    private String cargo;

    private float sueldo;

    /*La duracion es la combinacion de la escala y el valor de la duracion, ejm 2 dias, 6 meses, etc*/
    private String duracion;

    private String turnoTrabajo;

    private int numeroVacantes;

    private String nombreEmpresa;

    public OfertaLaboralConsultaDTO(String id, String titulo, String fechaPublicacion, String cargo, float sueldo, int valor , String escala, String turnoTrabajo, int numeroVacantes, String nombreEmpresa) {
        this.id = id;
        this.titulo = titulo;
        this.fechaPublicacion = fechaPublicacion;
        this.cargo = cargo;
        this.sueldo = sueldo;
        /* Ensamblaje de la duracion */
        this.duracion = Integer.toString(valor) + " " + escala ;
        this.turnoTrabajo = turnoTrabajo;
        this.numeroVacantes = numeroVacantes;
        this.nombreEmpresa = nombreEmpresa;
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

    public String getDuracion() {
        return duracion;
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
}
