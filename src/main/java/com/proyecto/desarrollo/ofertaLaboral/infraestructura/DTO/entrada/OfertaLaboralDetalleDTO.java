package com.proyecto.desarrollo.ofertaLaboral.infraestructura.DTO.entrada;

import com.proyecto.desarrollo.comunes.infraestructura.DTOs.HabilidadDTO;

import java.util.StringTokenizer;

public class OfertaLaboralDetalleDTO {

    private String id;

    private String titulo;

    private String fechaPublicacion;

    private String fechaModificacion;

    private String cargo;

    private float sueldo;

    private String descripcion;

    private int duracionValor;

    private String duracionEscala;

    private String turnoTrabajo;

    private int numeroVacantes;

    private String idEmpresa;

    private String nombreEmpresa;

    private String direccionEmpresa;

    private String requerimientoEspecial;

    private HabilidadDTO[] habilidades;

    public OfertaLaboralDetalleDTO(String id, String titulo, String fechaPublicacion, String fechaModificacion, String cargo, float sueldo, int duracionValor, String duracionEscala, String descripcion, String turnoTrabajo, int numeroVacantes, String idEmpresa, String nombreEmpresa, String direccionEmpresa, String requerimientoEspecial, HabilidadDTO[] habilidades) {
        this.id = id;
        this.titulo = titulo;
        this.fechaPublicacion = fechaPublicacion;
        this.fechaModificacion = fechaModificacion;
        this.cargo = cargo;
        this.sueldo = sueldo;
        this.descripcion = descripcion;
        this.duracionValor = duracionValor;
        this.duracionEscala =  duracionEscala;
        this.turnoTrabajo = turnoTrabajo;
        this.numeroVacantes = numeroVacantes;
        this.idEmpresa = idEmpresa;
        this.nombreEmpresa = nombreEmpresa;
        this.direccionEmpresa = direccionEmpresa;
        this.requerimientoEspecial = requerimientoEspecial;
        this.habilidades = habilidades;
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

    public String getFechaModificacion() {
        return fechaModificacion;
    }

    public String getCargo() {
        return cargo;
    }

    public float getSueldo() {
        return sueldo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public int getDuracionValor() {
        return duracionValor;
    }

    public String getDuracionEscala() {
        return duracionEscala;
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

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public String getDireccionEmpresa() {
        return direccionEmpresa;
    }

    public String getRequerimientoEspecial() {
        return requerimientoEspecial;
    }

    public HabilidadDTO[] getHabilidades() {
        return habilidades;
    }
}
