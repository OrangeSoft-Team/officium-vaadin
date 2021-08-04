package com.proyecto.desarrollo.empleados.infraestructura.DTO.entrada;

import com.proyecto.desarrollo.empleados.infraestructura.DTO.EmpleadoExperienciaDTO;
import com.proyecto.desarrollo.empleados.infraestructura.DTO.EmpleadoHabilidadDTO;

import java.util.ArrayList;
import java.util.Date;

public class EmpleadoDetalleEntradaDTO {
    private String uuid;
    private String primerNombre;
    private String segundoNombre;
    private String primerApellido;
    private String segundoApellido;
    private String correo;
    private String estatus;
    private String genero;
    private String fechaNacimiento;
    private String calleUno;
    private String calleDos;
    private String codigoPostal;
    private String nombrePais;
    private String nombreEstado;
    private String nombreCiudad;
    private ArrayList<EmpleadoHabilidadDTO> habilidades;
    private ArrayList<EmpleadoExperienciaDTO> experiencias;

    public EmpleadoDetalleEntradaDTO() {
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

    public String getFechaNacimiento() {
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

    public String getCodigoPostal() {
        return codigoPostal;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public void setPrimerNombre(String primerNombre) {
        this.primerNombre = primerNombre;
    }

    public void setSegundoNombre(String segundoNombre) {
        this.segundoNombre = segundoNombre;
    }

    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }

    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

        public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public void setCalleUno(String calleUno) {
        this.calleUno = calleUno;
    }

    public void setCalleDos(String calleDos) {
        this.calleDos = calleDos;
    }

    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public void setNombrePais(String nombrePais) {
        this.nombrePais = nombrePais;
    }

    public void setNombreEstado(String nombreEstado) {
        this.nombreEstado = nombreEstado;
    }

    public void setNombreCiudad(String nombreCiudad) {
        this.nombreCiudad = nombreCiudad;
    }

    public void setHabilidades(ArrayList<EmpleadoHabilidadDTO> habilidades) {
        this.habilidades = habilidades;
    }

    public void setExperiencias(ArrayList<EmpleadoExperienciaDTO> experiencias) {
        this.experiencias = experiencias;
    }
}
