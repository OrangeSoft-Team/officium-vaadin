package com.proyecto.desarrollo.backend.infraestructura.persistencia.entrada.empresas;

import com.proyecto.desarrollo.backend.entidades.empresas.aplicacion.PersistenciaEmpresas;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class EmpresasArchivoPersistencia implements PersistenciaEmpresas {
    public String getEmpresasOfertaLaboral(){
        String contenido;
        contenido = "";
        try{
            contenido = Files.readString(Paths.get("src/main/resources/json/empresas.json"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return contenido;
    }
}
