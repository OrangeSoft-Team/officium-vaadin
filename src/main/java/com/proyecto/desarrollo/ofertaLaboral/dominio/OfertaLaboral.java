package com.proyecto.desarrollo.ofertaLaboral.dominio;

import com.proyecto.desarrollo.comunes.infraestructura.DTOs.HabilidadDTO;
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

    private String uuidEmpresa;

    private Habilidades[] habilidades;

    private RequisitosEspeciales requisitosEspeciales;

    public OfertaLaboral(String titulo, String descripcion, String cargo, Float sueldo, int duracionEstimadaValor, String duracionEstimadaEscala, String turnoTrabajo, int numeroVacantes, String idEmpresa, String requisitoEspecial, HabilidadDTO[] habilidadesObtenidas) {
        this.titulo = new Titulo(titulo);
        this.descripcion = new Descripcion(descripcion);
        this.cargo = new Cargo(cargo);
        this.sueldo = new Sueldo(sueldo);
        this.duracionEstimadaValor = new DuracionEstimadaValor(duracionEstimadaValor);
        this.duracionEstimadaEscala = new DuracionEstimadaEscala(duracionEstimadaEscala);
        this.turnoTrabajo = new TurnoTrabajo(turnoTrabajo);
        this.numeroVacantes = new NumeroVacantes(numeroVacantes);
        this.uuidEmpresa = idEmpresa;
        /*Como es opcional, si es null no se hace la comprobación*/
        if (requisitoEspecial == null) this.requisitosEspeciales = null;
        else this.requisitosEspeciales = new RequisitosEspeciales(requisitoEspecial);
        this.habilidades = new Habilidades[habilidadesObtenidas.length];
        for (int i = 0 ; i < habilidades.length; i++){
            this.habilidades[i] = new Habilidades(habilidadesObtenidas[i].getId(),habilidadesObtenidas[i].getNombre(),habilidadesObtenidas[i].getCategoria());
        }
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

    public String getUuidEmpresa() {
        return uuidEmpresa;
    }

    public Habilidades[] getHabilidades() {
        return habilidades;
    }

    public RequisitosEspeciales getRequisitosEspeciales() {
        return requisitosEspeciales;
    }
}
