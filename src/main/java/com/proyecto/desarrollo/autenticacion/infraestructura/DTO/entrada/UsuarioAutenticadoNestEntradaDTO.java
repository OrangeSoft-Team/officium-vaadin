package com.proyecto.desarrollo.autenticacion.infraestructura.DTO.entrada;

public class UsuarioAutenticadoNestEntradaDTO {
    private String primer_nombre;
    private String primer_apellido;

    public UsuarioAutenticadoNestEntradaDTO(String primer_nombre, String primer_apellido) {
        this.primer_nombre = primer_nombre;
        this.primer_apellido = primer_apellido;
    }

    public String getPrimer_nombre() {
        return primer_nombre;
    }

    public String getPrimer_apellido() {
        return primer_apellido;
    }

}
