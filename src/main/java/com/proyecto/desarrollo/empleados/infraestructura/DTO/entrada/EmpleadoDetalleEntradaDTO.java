package com.proyecto.desarrollo.empleados.infraestructura.DTO.entrada;

import com.proyecto.desarrollo.empleados.infraestructura.DTO.EmpleadoExperienciaDTO;
import com.proyecto.desarrollo.empleados.infraestructura.DTO.EmpleadoHabilidadDTO;

import java.util.ArrayList;
import java.util.Date;

public class EmpleadoDetalleEntradaDTO {
    private String uuid;
    private String primerNombre;
    private String primerApellido;
    private String segundoNombre;
    private String segundoApellido;
    private String correo;
    private String estatus;
    private String genero;
    private Date fechaNacimiento;
    private String calleUno;
    private String calleDos;
    private String nombrePais;
    private String nombreEstado;
    private String nombreCiudad;
    private ArrayList<EmpleadoHabilidadDTO> habilidades;
    private ArrayList<EmpleadoExperienciaDTO> experiencias;

    public EmpleadoDetalleEntradaDTO(String uuid, String primerNombre, String primerApellido, String segundoNombre, String segundoApellido, String correo, String estatus, String genero, Date fechaNacimiento, String calleUno, String calleDos, String nombrePais, String nombreEstado, String nombreCiudad, ArrayList<EmpleadoHabilidadDTO> habilidades, ArrayList<EmpleadoExperienciaDTO> experiencias) {
        this.uuid = uuid;
        this.primerNombre = primerNombre;
        this.primerApellido = primerApellido;
        this.segundoNombre = segundoNombre;
        this.segundoApellido = segundoApellido;
        this.correo = correo;
        this.estatus = estatus;
        this.genero = genero;
        this.fechaNacimiento = fechaNacimiento;
        this.calleUno = calleUno;
        this.calleDos = calleDos;
        this.nombrePais = nombrePais;
        this.nombreEstado = nombreEstado;
        this.nombreCiudad = nombreCiudad;
        this.habilidades = habilidades;
        this.experiencias = experiencias;
    }

    public String getUuid() {
        return uuid;
    }

    public String getPrimerNombre() {
        return primerNombre;
    }

    public String getPrimerApellido() {
        return primerApellido;
    }

    public String getSegundoNombre() {
        return segundoNombre;
    }

    public String getSegundoApellido() {
        return segundoApellido;
    }

    public String getCorreo() {
        return correo;
    }

    public String getEstatus() {
        return estatus;
    }

    public String getGenero() {
        return genero;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public String getCalleUno() {
        return calleUno;
    }

    public String getCalleDos() {
        return calleDos;
    }

    public String getNombrePais() {
        return nombrePais;
    }

    public String getNombreEstado() {
        return nombreEstado;
    }

    public String getNombreCiudad() {
        return nombreCiudad;
    }

    public ArrayList<EmpleadoHabilidadDTO> getHabilidades() {
        return habilidades;
    }

    public ArrayList<EmpleadoExperienciaDTO> getExperiencias() {
        return experiencias;
    }
}
