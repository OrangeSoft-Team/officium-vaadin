package com.proyecto.desarrollo.autenticacion.infraestructura.DTO.salida;

public class UsuarioAutenticadoFirebaseSalidaDTO {
    private String correo;
    private String contrasena;

    public UsuarioAutenticadoFirebaseSalidaDTO(String correo, String contrasena) {
        this.correo = correo;
        this.contrasena = contrasena;
    }

    public String getCorreo() {
        return correo;
    }

    public String getContrasena() {
        return contrasena;
    }
}
