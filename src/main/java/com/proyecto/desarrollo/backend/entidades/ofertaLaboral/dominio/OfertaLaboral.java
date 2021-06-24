package com.proyecto.desarrollo.backend.entidades.ofertaLaboral.dominio;

import com.proyecto.desarrollo.backend.entidades.ofertaLaboral.dominio.valueObjects.*;

public class OfertaLaboral {
    private String id;

    private Titulo titulo;

    private String fechaPublicacion;

    private Cargo cargo;

    private Sueldo sueldo;

    private DuracionEstimadaValor duracionEstimadaValor;

    private DuracionEstimadaEscala duracionEstimadaEscala;

    private TurnoTrabajo turnoTrabajo;

    private NumeroVacantes numeroVacantes;

    /*Constructor utilizado cuando la oferta laboral viene desde BD*/
    public OfertaLaboral(String id, Titulo titulo, String fechaPublicacion, Cargo cargo, Sueldo sueldo, DuracionEstimadaValor duracionEstimadaValor, DuracionEstimadaEscala duracionEstimadaEscala, TurnoTrabajo turnoTrabajo, NumeroVacantes numeroVacantes) {
        this.id = id;
        this.titulo = titulo;
        this.fechaPublicacion = fechaPublicacion;
        this.cargo = cargo;
        this.sueldo = sueldo;
        this.duracionEstimadaValor = duracionEstimadaValor;
        this.duracionEstimadaEscala = duracionEstimadaEscala;
        this.turnoTrabajo = turnoTrabajo;
        this.numeroVacantes = numeroVacantes;
    }
    /*Constructor utilizado cuando se crea una nueva oferta laboral*/

    public OfertaLaboral(Titulo titulo, String fechaPublicacion, Cargo cargo, Sueldo sueldo, DuracionEstimadaValor duracionEstimadaValor, DuracionEstimadaEscala duracionEstimadaEscala, TurnoTrabajo turnoTrabajo, NumeroVacantes numeroVacantes) {
        this.titulo = titulo;
        this.fechaPublicacion = fechaPublicacion;
        this.cargo = cargo;
        this.sueldo = sueldo;
        this.duracionEstimadaValor = duracionEstimadaValor;
        this.duracionEstimadaEscala = duracionEstimadaEscala;
        this.turnoTrabajo = turnoTrabajo;
        this.numeroVacantes = numeroVacantes;
    }

    public String getId() {
        return id;
    }

    public Titulo getTitulo() {
        return titulo;
    }

    public String getFechaPublicacion() {
        return fechaPublicacion;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public Sueldo getSueldo() {
        return sueldo;
    }

    public DuracionEstimadaValor getDuracionEstimadaValor() {
        return duracionEstimadaValor;
    }

    public DuracionEstimadaEscala getDuracionEstimadaEscala() {
        return duracionEstimadaEscala;
    }

    public TurnoTrabajo getTurnoTrabajo() {
        return turnoTrabajo;
    }

    public NumeroVacantes getNumeroVacantes() {
        return numeroVacantes;
    }
}
