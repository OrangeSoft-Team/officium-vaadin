package com.proyecto.desarrollo.autenticacion.infraestructura.DTO.salida;

public class DatosBasicosUsuarioSalidaDTO {
    private String primer_nombre;
    private String primer_apellido;
    private String cargo;

    public DatosBasicosUsuarioSalidaDTO(String primer_nombre, String primer_apellido, String cargo) {
        this.primer_nombre = primer_nombre;
        this.primer_apellido = primer_apellido;
        this.cargo = cargo;
    }

    public String getPrimer_nombre() {
        return primer_nombre;
    }

    public String getPrimer_apellido() {
        return primer_apellido;
    }

    public String getCargo() {
        return cargo;
    }
}
