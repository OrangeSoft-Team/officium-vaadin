package com.proyecto.desarrollo.empresas.infraestructura.DTO.entrada;

/*Esta clase se utilizará para obtener los nombres de las empresas y sus ids*/
public class ConsultarEmpresasParaCreacion {

    private String UUID;

    private String nombre;

    public ConsultarEmpresasParaCreacion(String UUID, String nombre) {
        this.UUID = UUID;
        this.nombre = nombre;
    }

    public String getUUID() {
        return UUID;
    }

    public String getNombre() {
        return nombre;
    }

}
