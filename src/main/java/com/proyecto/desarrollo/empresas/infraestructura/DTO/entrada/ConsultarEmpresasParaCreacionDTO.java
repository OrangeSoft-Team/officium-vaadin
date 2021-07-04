package com.proyecto.desarrollo.empresas.infraestructura.DTO.entrada;

/*Esta clase se utilizará para obtener los nombres de las empresas y sus ids*/
public class ConsultarEmpresasParaCreacionDTO {

    private String UUID;

    private String nombre;

    public ConsultarEmpresasParaCreacionDTO(String UUID, String nombre) {
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
