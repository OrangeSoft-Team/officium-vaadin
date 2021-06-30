package com.proyecto.desarrollo.backend.infraestructura.persistencia.entrada.empresas;

import com.proyecto.desarrollo.backend.entidades.empresas.infraestructura.DTO.entrada.ConsultarEmpresasParaCreacion;

import java.net.MalformedURLException;

public interface PersistenciaEmpresas {

    public String getEmpresasOfertaLaboral() throws MalformedURLException;

}