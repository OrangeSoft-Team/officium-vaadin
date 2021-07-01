package com.proyecto.desarrollo.ofertaLaboral.dominio;

import com.proyecto.desarrollo.ofertaLaboral.dominio.valueObjects.*;

public class OfertaLaboral {

    private Titulo titulo;

    private Descripcion descripcion;

    private Cargo cargo;

    private Sueldo sueldo;

    private DuracionEstimadaValor duracionEstimadaValor;

    private DuracionEstimadaEscala duracionEstimadaEscala;

    private TurnoTrabajo turnoTrabajo;

    private NumeroVacantes numeroVacantes;

    private String idEmpresa;

    public OfertaLaboral(String titulo, String descripcion, String cargo, Float sueldo, int duracionEstimadaValor, String duracionEstimadaEscala, String turnoTrabajo, int numeroVacantes, String idEmpresa) {
        this.titulo = new Titulo(titulo);
        this.descripcion = new Descripcion(descripcion);
        this.cargo = new Cargo(cargo);
        this.sueldo = new Sueldo(sueldo);
        this.duracionEstimadaValor = new DuracionEstimadaValor(duracionEstimadaValor);
        this.duracionEstimadaEscala = new DuracionEstimadaEscala(duracionEstimadaEscala);
        this.turnoTrabajo = new TurnoTrabajo(turnoTrabajo);
        this.numeroVacantes = new NumeroVacantes(numeroVacantes);
        this.idEmpresa = idEmpresa;
    }

    public Titulo getTitulo() {
        return titulo;
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

    public Descripcion getDescripcion(){return descripcion;}

    public String getIdEmpresa() {
        return idEmpresa;
    }


}
