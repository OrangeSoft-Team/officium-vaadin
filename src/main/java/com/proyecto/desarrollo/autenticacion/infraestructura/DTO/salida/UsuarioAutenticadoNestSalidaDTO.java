package com.proyecto.desarrollo.autenticacion.infraestructura.DTO.salida;

public class UsuarioAutenticadoNestSalidaDTO {
    private String correo;
    private String token;

    public UsuarioAutenticadoNestSalidaDTO(String correo, String token) {
        this.correo = correo;
        this.token = token;
    }

    public String getCorreo() {
        return correo;
    }

    public String getToken() {
        return token;
    }
}
